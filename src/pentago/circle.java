package pentago;

import java.util.Random;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class circle extends StackPane {

    //circle with radius = 35 place for marbles
    Circle c = new Circle(35);
    static AudioClip As, Alose;

    static int step = 0;

    public circle() {

        Alose = new AudioClip(this.getClass().getResource("lose.mp3").toString());
        As = new AudioClip(this.getClass().getResource("s.mp3").toString());

        c.setFill(null);
        c.setFill(Color.RED);
        getChildren().add(c);

        setOnMouseClicked(event -> {
            //left click
            if (event.getButton() == MouseButton.PRIMARY) {
                //check that circles are empty to put marbles 
                if (c.getFill() != Color.BLACK & c.getFill() != Color.WHITE) {
                    //check end game / check if black turn / check for rotation (if rotation happend can fill circles)
                    if (!board.end & board.BlackTurn & board.rotation) {
                        board.BlackTurn = false;
                        //sound of fill circles
                        AudioClip a = new AudioClip(this.getClass().getResource("s.mp3").toString());
                        a.play();

                        drawBlack();
                        fillCircle();
                        //check if black win
                        if (board.checkwin(1)) {
                            //sound of winning
                            a = new AudioClip(this.getClass().getResource("win.mp3").toString());
                            a.play();
                            board.end = true;
                            return;
                        }
                        board.rotation = false;
                        board.rotateflag = true;
                    }
                }
            }
        });
    }

    //draw black circle 
    public void drawBlack() {
        c.setFill(Color.BLACK);
    }

    //draw white circle
    public void drawWhite() {
        c.setFill(Color.WHITE);
    }

    //return color of circle
    public Paint getcolor() {
        return c.getFill();
    }

    //set marble 1 if color of circle is black
    public void fillCircle() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (board.c[j][i].getcolor() == Color.BLACK) {
                    board.marble[i][j] = 1;
                }
            }
        }
    }

    public static void white_turn() {
        //check end game / check if white turn / check for rotation (if rotation happend can fill circles)
        if (!board.end & !board.BlackTurn & board.rotation) {

            if (step >= 2) {
                step += 1;

                String[] sh = {"00", "01", "02", "10", "11", "12", "20", "21", "22",
                    "03", "04", "05", "13", "14", "15", "23", "24", "25",
                    "30", "31", "32", "40", "41", "42", "50", "51", "52",
                    "33", "34", "35", "43", "44", "45", "53", "54", "55"};

                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 6; j++) {
                        if (board.marble[i][j] != 0) {
                            sh = board.removeElement(sh, String.valueOf(i) + String.valueOf(j));
                        }
                    }
                }

                board.a = Integer.MIN_VALUE;
                board.b = Integer.MAX_VALUE;
                while (sh != null) {

                    String str = board.randomElement(sh);
                    int i = Character.getNumericValue(str.charAt(0));
                    int j = Character.getNumericValue(str.charAt(1));
                    sh = board.removeElement(sh, String.valueOf(i) + String.valueOf(j));

                    board.marble[i][j] = 2;
                    for (int k = 0; k < 8; k++) {
                        board.rot(k);
                        board.BlackTurn = true;
                        if (step < 10) {
                            board.v = board.mini_max_algo_alpha_beta(0, board.a, board.b, 3);
                        } else {
                            board.v = board.mini_max_algo_alpha_beta(0, board.a, board.b, 4);
                        }
                        if (board.v < board.b) {
                            board.b = board.v;
                            board.khold = k;
                            board.ihold = i;
                            board.jhold = j;
                        }

                        if (k % 2 == 0) {
                            board.rot(k + 1);
                        } else {
                            board.rot(k - 1);
                        }

                        if (board.a >= board.b) {
                            break;
                        }
                    }
                    board.marble[i][j] = 0;
                    if (board.a >= board.b) {
                        break;
                    }
                }

                board.marble[board.ihold][board.jhold] = 2;
                //sound of fill circles
                As.play();
                board.c[board.jhold][board.ihold].drawWhite();
                //check if white win
                if (board.checkwin(2)) {
                    //sound of winning
                    Alose.play();
                    board.end = true;
                }
                board.BlackTurn = true;
                board.rotateflag = true;
                board.rotation = false;
                board.rot_animation(board.khold);
                board.text.setText("");
                //the first move
            } else {
                step += 1;
                if (board.marble[1][1] == 0) {
                    board.marble[1][1] = 2;
                    //sound of fill circles
                    As.play();
                    board.c[1][1].drawWhite();
                } else if (board.marble[1][4] == 0) {
                    board.marble[1][4] = 2;
                    //sound of fill circles
                    As.play();
                    board.c[4][1].drawWhite();
                } else if (board.marble[4][1] == 0) {
                    board.marble[4][1] = 2;
                    //sound of fill circles
                    As.play();
                    board.c[1][4].drawWhite();
                } else if (board.marble[4][4] == 0) {
                    board.marble[4][4] = 2;
                    //sound of fill circles
                    As.play();
                    board.c[4][4].drawWhite();
                }
                board.BlackTurn = true;
                board.rotateflag = true;
                board.rotation = false;
                int rnd = new Random().nextInt(8);
                board.rot_animation(rnd);
                board.text.setText("");
            }
        }
    }
}
