package pentago;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class board {

    static circle[][] c = new circle[6][6];

    static int[][] marble = new int[6][6];//2 = white, 1 = black

    static boolean BlackTurn = true;
    static boolean end = false;
    static boolean rotation = true;
    static boolean rotateflag;
    static boolean flag = true;
    static int v, a, b;
    static int ihold, jhold, khold;

    static AnchorPane root = new AnchorPane();
    static Pane p1 = new Pane();
    static Pane p2 = new Pane();
    static Pane p3 = new Pane();
    static Pane p4 = new Pane();

    static AudioClip Ac, Awin, Alose;

    static Text text = new Text();

    public void start(Stage stage) {
        text.setX(300);
        text.setY(30);
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        text.setFill(Color.RED);

        //sounds 
        Ac = new AudioClip(this.getClass().getResource("c.mp3").toString());
        Awin = new AudioClip(this.getClass().getResource("win.mp3").toString());
        Alose = new AudioClip(this.getClass().getResource("lose.mp3").toString());

        root.setPrefSize(700, 700);
        root.setStyle("-fx-background-color: black");

        p1.setPrefSize(300, 300);
        p1.setStyle("-fx-background-color: #c30a0a; -fx-background-radius: 20;");
        p1.setLayoutX(48.0);
        p1.setLayoutY(48.0);

        p2.setPrefSize(300, 300);
        p2.setStyle("-fx-background-color: #c30a0a; -fx-background-radius: 20;");
        p2.setLayoutX(352.0);
        p2.setLayoutY(48.0);

        p3.setPrefSize(300, 300);
        p3.setStyle("-fx-background-color: #c30a0a; -fx-background-radius: 20;");
        p3.setLayoutX(48.0);
        p3.setLayoutY(352.0);

        p4.setPrefSize(300, 300);
        p4.setStyle("-fx-background-color: #c30a0a; -fx-background-radius: 20;");
        p4.setLayoutX(352.0);
        p4.setLayoutY(352.0);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                c[i][j] = new circle();
            }
        }

        drawboard();

        //
        Font f1 = new Font(64);
        Text t1 = new Text("⤿");
        t1.fontProperty().setValue(f1);
        t1.setFill(Color.RED);
        t1.setLayoutX(10);
        t1.setLayoutY(110);
        t1.setRotate(30);

        Text t2 = new Text("⤾");
        t2.fontProperty().setValue(f1);
        t2.setFill(Color.RED);
        t2.setLayoutX(65);
        t2.setLayoutY(60);
        t2.setRotate(-120);

        Text t3 = new Text("⤿");
        t3.fontProperty().setValue(f1);
        t3.setFill(Color.RED);
        t3.setLayoutX(590);
        t3.setLayoutY(60);
        t3.setRotate(120);

        Text t4 = new Text("⤾");
        t4.fontProperty().setValue(f1);
        t4.setFill(Color.RED);
        t4.setLayoutX(645);
        t4.setLayoutY(110);
        t4.setRotate(-30);

        Text t5 = new Text("⤾");
        t5.fontProperty().setValue(f1);
        t5.setFill(Color.RED);
        t5.setLayoutX(10);
        t5.setLayoutY(635);
        t5.setRotate(150);

        Text t6 = new Text("⤿");
        t6.fontProperty().setValue(f1);
        t6.setFill(Color.RED);
        t6.setLayoutX(65);
        t6.setLayoutY(693);
        t6.setRotate(-60);

        Text t7 = new Text("⤾");
        t7.fontProperty().setValue(f1);
        t7.setFill(Color.RED);
        t7.setLayoutX(590);
        t7.setLayoutY(693);
        t7.setRotate(60);

        Text t8 = new Text("⤿");
        t8.fontProperty().setValue(f1);
        t8.setFill(Color.RED);
        t8.setLayoutX(645);
        t8.setLayoutY(635);
        t8.setRotate(-150);
        //

        t1.setOnMouseClicked(event -> {
            rot_animation(0);
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), (ActionEvent event1) -> {
                circle.white_turn();
            }));
            timeline.play();
        });

        t2.setOnMouseClicked(event -> {
            rot_animation(1);
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), (ActionEvent event1) -> {
                circle.white_turn();
            }));
            timeline.play();
        });

        t3.setOnMouseClicked(event -> {
            rot_animation(2);
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), (ActionEvent event1) -> {
                circle.white_turn();
            }));
            timeline.play();
        });

        t4.setOnMouseClicked(event -> {
            rot_animation(3);
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), (ActionEvent event1) -> {
                circle.white_turn();
            }));
            timeline.play();
        });

        t5.setOnMouseClicked(event -> {
            rot_animation(4);
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), (ActionEvent event1) -> {
                circle.white_turn();
            }));
            timeline.play();
        });

        t6.setOnMouseClicked(event -> {
            rot_animation(5);
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), (ActionEvent event1) -> {
                circle.white_turn();
            }));
            timeline.play();
        });

        t7.setOnMouseClicked(event -> {
            rot_animation(6);
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), (ActionEvent event1) -> {
                circle.white_turn();
            }));
            timeline.play();
        });

        t8.setOnMouseClicked(event -> {
            rot_animation(7);
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), (ActionEvent event1) -> {
                circle.white_turn();
            }));
            timeline.play();
        });

        root.getChildren().addAll(p1, p2, p3, p4, text, t1, t2, t3, t4, t5, t6, t7, t8);
        Scene s = new Scene(root);
        stage.setScene(s);
        stage.show();
    }

    public static int mini_max_algo_alpha_beta(int depth, int a, int b, int level) {

        if (checkwin(1) & checkwin(2)) {
            return +10;
        }
        if (checkwin(1)) {
            return +5;
        }
        if (checkwin(2)) {
            return -5;
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (marble[i][j] == 0) {
                    flag = false;
                }
            }
        }
        if (flag) {
            return 0;
        }
        flag = true;

        if (depth == level) {
            if (chech_4_in_a_row(1)) {
                return +3;
            }
            if (chech_4_in_a_row(2)) {
                return -3;
            }
            if (chech_3_in_a_row(1)) {
                return +1;
            }
            if (chech_3_in_a_row(2)) {
                return -1;
            }
            return 0;
        }
        
        String[] sh = {"00", "10", "20", "30", "40", "50",
            "01", "11", "21", "31", "41", "51",
            "02", "12", "22", "32", "42", "52",
            "03", "13", "23", "33", "43", "53",
            "04", "14", "24", "34", "44", "54",
            "05", "15", "25", "35", "45", "55",};

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (marble[i][j] != 0) {
                    sh = removeElement(sh, String.valueOf(i) + String.valueOf(j));
                }
            }
        }

        if (BlackTurn) {
            BlackTurn = false;
            while (sh != null) {

                String str = randomElement(sh);
                int i = Character.getNumericValue(str.charAt(0));
                int j = Character.getNumericValue(str.charAt(1));
                sh = removeElement(sh, String.valueOf(i) + String.valueOf(j));

                marble[i][j] = 1;
                for (int k = 0; k < 8; k++) {
                    rot(k);
                    BlackTurn = false;
                    v = mini_max_algo_alpha_beta(depth + 1, a, b, level);
                    if (v > a) {
                        a = v;
                    }
                    //////////////////////
                    if (k % 2 == 0) {
                        rot(k + 1);
                    } else {
                        rot(k - 1);
                    }

                    if (a >= b) {
                        break;
                    }
                }
                marble[i][j] = 0;
                if (a >= b) {
                    break;
                }
            }
            return a;
        } else {
            BlackTurn = true;
            while (sh != null) {

                String str = randomElement(sh);
                int i = Character.getNumericValue(str.charAt(0));
                int j = Character.getNumericValue(str.charAt(1));
                sh = removeElement(sh, String.valueOf(i) + String.valueOf(j));
                
                marble[i][j] = 2;
                for (int k = 0; k < 8; k++) {
                    rot(k);
                    BlackTurn = true;
                    v = mini_max_algo_alpha_beta(depth + 1, a, b, level);
                    if (v < b) {
                        b = v;
                    }
                    ///////////////////
                    if (k % 2 == 0) {
                        rot(k + 1);
                    } else {
                        rot(k - 1);
                    }

                    if (a >= b) {
                        break;
                    }
                }
                marble[i][j] = 0;
                if (a >= b) {
                    break;
                }
            }
            return b;
        }
    }

    public static String randomElement(String[] sh) {
        int rnd = new Random().nextInt(sh.length);
        return sh[rnd];
    }

    public static String[] removeElement(String[] sh, String element) {
        int x = 0;
        for (int i = 0; i < sh.length; i++) {
            if (sh[i].equals(element)) {
                x = i;
                break;
            }
        }
        if (sh.length == 1) {
            sh = null;
        } else {
            String[] copy = new String[sh.length - 1];
            for (int i = 0, k = 0; i < sh.length; i++) {

                // if the index is the removal element index
                if (i == x) {
                    continue;
                }

                // if the index is not the removal element index
                copy[k++] = sh[i];
            }
            sh = copy;
        }
        return sh;
    }

    //draw pentago board
    public void drawboard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i < 3 & j < 3) {
                    c[i][j].setLayoutX(92.5 * i + 22.5);
                    c[i][j].setLayoutY(92.5 * j + 22.5);
                    p1.getChildren().add(c[i][j]);
                }
                if (i > 2 & i < 6 & j < 3) {
                    c[i][j].setLayoutX(92.5 * (i - 3) + 22.5);
                    c[i][j].setLayoutY(92.5 * j + 22.5);
                    p2.getChildren().add(c[i][j]);
                }
                if (i < 3 & j > 2 & j < 6) {
                    c[i][j].setLayoutX(92.5 * i + 22.5);
                    c[i][j].setLayoutY(92.5 * (j - 3) + 22.5);
                    p3.getChildren().add(c[i][j]);
                }
                if (i > 2 & i < 6 & j > 2 & j < 6) {
                    c[i][j].setLayoutX(92.5 * (i - 3) + 22.5);
                    c[i][j].setLayoutY(92.5 * (j - 3) + 22.5);
                    p4.getChildren().add(c[i][j]);
                }
            }
        }
    }

    //check winning of black if x = 1 and white if x = 2 
    public static boolean checkwin(int x) {
        //check row
        for (int i = 0; i < 6; i++) {
            if ((marble[i][0] == x & marble[i][1] == x & marble[i][2] == x & marble[i][3] == x & marble[i][4] == x)
                    | (marble[i][1] == x & marble[i][2] == x & marble[i][3] == x & marble[i][4] == x & marble[i][5] == x)) {
                return true;
            }
        }
        //check column
        for (int i = 0; i < 6; i++) {
            if ((marble[0][i] == x & marble[1][i] == x & marble[2][i] == x & marble[3][i] == x & marble[4][i] == x)
                    | (marble[1][i] == x & marble[2][i] == x & marble[3][i] == x & marble[4][i] == x & marble[5][i] == x)) {
                return true;
            }
        }
        //check diameters
        if (marble[0][0] == x & marble[1][1] == x & marble[2][2] == x & marble[3][3] == x & marble[4][4] == x) {
            return true;
        }
        if (marble[1][1] == x & marble[2][2] == x & marble[3][3] == x & marble[4][4] == x & marble[5][5] == x) {
            return true;
        }
        if (marble[1][0] == x & marble[2][1] == x & marble[3][2] == x & marble[4][3] == x & marble[5][4] == x) {
            return true;
        }
        if (marble[0][1] == x & marble[1][2] == x & marble[2][3] == x & marble[3][4] == x & marble[4][5] == x) {
            return true;
        }
        if (marble[5][0] == x & marble[4][1] == x & marble[3][2] == x & marble[2][3] == x & marble[1][4] == x) {
            return true;
        }
        if (marble[4][1] == x & marble[3][2] == x & marble[2][3] == x & marble[1][4] == x & marble[0][5] == x) {
            return true;
        }
        if (marble[4][0] == x & marble[3][1] == x & marble[2][2] == x & marble[1][3] == x & marble[0][4] == x) {
            return true;
        }
        if (marble[5][1] == x & marble[4][2] == x & marble[3][3] == x & marble[2][4] == x & marble[1][5] == x) {
            return true;
        }
        return false;
    }

    public static boolean chech_4_in_a_row(int x) {
        //check row
        for (int i = 0; i < 6; i++) {
            if ((marble[i][0] == x & marble[i][1] == x & marble[i][2] == x & marble[i][3] == x)
                    | (marble[i][1] == x & marble[i][2] == x & marble[i][3] == x & marble[i][4] == x)
                    | (marble[i][2] == x & marble[i][3] == x & marble[i][4] == x & marble[i][5] == x)) {
                return true;
            }
        }
        //check column
        for (int i = 0; i < 6; i++) {
            if ((marble[0][i] == x & marble[1][i] == x & marble[2][i] == x & marble[3][i] == x)
                    | (marble[1][i] == x & marble[2][i] == x & marble[3][i] == x & marble[4][i] == x)
                    | (marble[2][i] == x & marble[3][i] == x & marble[4][i] == x & marble[5][i] == x)) {
                return true;
            }
        }
        //check diameters
        if (marble[0][0] == x & marble[1][1] == x & marble[2][2] == x & marble[3][3] == x) {
            return true;
        }
        if (marble[1][1] == x & marble[2][2] == x & marble[3][3] == x & marble[4][4] == x) {
            return true;
        }
        if (marble[2][2] == x & marble[3][3] == x & marble[4][4] == x & marble[5][5] == x) {
            return true;
        }
        if (marble[1][0] == x & marble[2][1] == x & marble[3][2] == x & marble[4][3] == x) {
            return true;
        }
        if (marble[2][1] == x & marble[3][2] == x & marble[4][3] == x & marble[5][4] == x) {
            return true;
        }
        if (marble[0][1] == x & marble[1][2] == x & marble[2][3] == x & marble[3][4] == x) {
            return true;
        }
        if (marble[1][2] == x & marble[2][3] == x & marble[3][4] == x & marble[4][5] == x) {
            return true;
        }
        if (marble[5][0] == x & marble[4][1] == x & marble[3][2] == x & marble[2][3] == x) {
            return true;
        }
        if (marble[4][1] == x & marble[3][2] == x & marble[2][3] == x & marble[1][4] == x) {
            return true;
        }
        if (marble[3][2] == x & marble[2][3] == x & marble[1][4] == x & marble[0][5] == x) {
            return true;
        }
        if (marble[4][0] == x & marble[3][1] == x & marble[2][2] == x & marble[1][3] == x) {
            return true;
        }
        if (marble[3][1] == x & marble[2][2] == x & marble[1][3] == x & marble[0][4] == x) {
            return true;
        }
        if (marble[5][1] == x & marble[4][2] == x & marble[3][3] == x & marble[2][4] == x) {
            return true;
        }
        if (marble[4][2] == x & marble[3][3] == x & marble[2][4] == x & marble[1][5] == x) {
            return true;
        }
        return false;
    }

    public static boolean chech_3_in_a_row(int x) {
        //check row
        for (int i = 0; i < 6; i++) {
            if ((marble[i][0] == x & marble[i][1] == x & marble[i][2] == x)
                    | (marble[i][1] == x & marble[i][2] == x & marble[i][3] == x)
                    | (marble[i][2] == x & marble[i][3] == x & marble[i][4] == x)
                    | (marble[i][3] == x & marble[i][4] == x & marble[i][5] == x)) {
                return true;
            }
        }
        //check column
        for (int i = 0; i < 6; i++) {
            if ((marble[0][i] == x & marble[1][i] == x & marble[2][i] == x)
                    | (marble[1][i] == x & marble[2][i] == x & marble[3][i] == x)
                    | (marble[2][i] == x & marble[3][i] == x & marble[4][i] == x)
                    | (marble[3][i] == x & marble[4][i] == x & marble[5][i] == x)) {
                return true;
            }
        }
        //check diameters
        for (int i = 0; i < 4; i++) {
            if (marble[i][i] == x & marble[i + 1][i + 1] == x & marble[i + 2][i + 2] == x) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if ((marble[i + 1][i] == x & marble[i + 2][i + 1] == x & marble[i + 3][i + 2] == x)
                    | (marble[i][i + 1] == x & marble[i + 1][i + 2] == x & marble[i + 2][i + 3] == x)) {
                return true;
            }
        }
        if (marble[5][0] == x & marble[4][1] == x & marble[3][2] == x) {
            return true;
        }
        if (marble[4][1] == x & marble[3][2] == x & marble[2][3] == x) {
            return true;
        }
        if (marble[3][2] == x & marble[2][3] == x & marble[1][4] == x) {
            return true;
        }
        if (marble[2][3] == x & marble[1][4] == x & marble[0][5] == x) {
            return true;
        }
        if (marble[4][0] == x & marble[3][1] == x & marble[2][2] == x) {
            return true;
        }
        if (marble[3][1] == x & marble[2][2] == x & marble[1][3] == x) {
            return true;
        }
        if (marble[2][2] == x & marble[1][3] == x & marble[0][4] == x) {
            return true;
        }
        if (marble[5][1] == x & marble[4][2] == x & marble[3][3] == x) {
            return true;
        }
        if (marble[4][2] == x & marble[3][3] == x & marble[2][4] == x) {
            return true;
        }
        if (marble[3][3] == x & marble[2][4] == x & marble[1][5] == x) {
            return true;
        }
        return false;
    }

    //rotation
    public static void rot_animation(int x) {
        int[] angle = {-90, 90, -90, 90, 90, -90, 90, -90};
        if (!end & rotateflag) {

            //sound of rotation
            Ac.play();

            //animation of rotation
            RotateTransition rotate;
            if (x == 0 | x == 1) {
                rotate = new RotateTransition(javafx.util.Duration.seconds(1.2), p1);
            } else if (x == 2 | x == 3) {
                rotate = new RotateTransition(javafx.util.Duration.seconds(1.2), p2);
            } else if (x == 4 | x == 5) {
                rotate = new RotateTransition(javafx.util.Duration.seconds(1.2), p3);
            } else if (x == 6 | x == 7) {
                rotate = new RotateTransition(javafx.util.Duration.seconds(1.2), p4);
            } else {
                return;
            }
            rotate.setByAngle(angle[x]);
            rotate.play();

            rot(x);
            cir(x);

            if (checkwin(1)) {
                //sound of winning
                Awin.play();
                end = true;
                return;
            } else if (checkwin(2)) {
                //sound of winning
                Alose.play();
                end = true;
                return;
            }

            rotation = true;
            rotateflag = false;
            //change background color to show turn
            if (BlackTurn) {
                root.setStyle("-fx-background-color: black");
            } else {
                root.setStyle("-fx-background-color: white");
            }

            text.setText("Processing...");
        }
    }

    public static void rot(int x) {
        int temp, temp1;
        switch (x) {
            case 0:
                //rot1_270
                temp = marble[0][0];
                marble[0][0] = marble[0][2];
                temp1 = marble[2][0];
                marble[2][0] = temp;
                marble[0][2] = marble[2][2];
                marble[2][2] = temp1;
                //
                temp = marble[1][0];
                marble[1][0] = marble[0][1];
                temp1 = marble[2][1];
                marble[2][1] = temp;
                marble[0][1] = marble[1][2];
                marble[1][2] = temp1;

                break;
            case 1:
                //rot1_90
                temp = marble[0][0];
                marble[0][0] = marble[2][0];
                temp1 = marble[0][2];
                marble[0][2] = temp;
                marble[2][0] = marble[2][2];
                marble[2][2] = temp1;
                //
                temp = marble[0][1];
                marble[0][1] = marble[1][0];
                temp1 = marble[1][2];
                marble[1][2] = temp;
                marble[1][0] = marble[2][1];
                marble[2][1] = temp1;
                break;
            case 2:
                //rot2_270
                temp = marble[0][3];
                marble[0][3] = marble[0][5];
                temp1 = marble[2][3];
                marble[2][3] = temp;
                marble[0][5] = marble[2][5];
                marble[2][5] = temp1;
                //
                temp = marble[0][4];
                marble[0][4] = marble[1][5];
                temp1 = marble[1][3];
                marble[1][3] = temp;
                marble[1][5] = marble[2][4];
                marble[2][4] = temp1;
                break;
            case 3:
                //rot2_90
                temp = marble[0][5];
                marble[0][5] = marble[0][3];
                temp1 = marble[2][5];
                marble[2][5] = temp;
                marble[0][3] = marble[2][3];
                marble[2][3] = temp1;
                //
                temp = marble[1][5];
                marble[1][5] = marble[0][4];
                temp1 = marble[2][4];
                marble[2][4] = temp;
                marble[0][4] = marble[1][3];
                marble[1][3] = temp1;
                break;
            case 4:
                //rot3_90
                temp = marble[3][2];
                marble[3][2] = marble[3][0];
                temp1 = marble[5][2];
                marble[5][2] = temp;
                marble[3][0] = marble[5][0];
                marble[5][0] = temp1;
                //
                temp = marble[5][1];
                marble[5][1] = marble[4][2];
                temp1 = marble[4][0];
                marble[4][0] = temp;
                marble[4][2] = marble[3][1];
                marble[3][1] = temp1;
                break;
            case 5:
                //rot3_270
                temp = marble[3][0];
                marble[3][0] = marble[3][2];
                temp1 = marble[5][0];
                marble[5][0] = temp;
                marble[3][2] = marble[5][2];
                marble[5][2] = temp1;
                //
                temp = marble[5][1];
                marble[5][1] = marble[4][0];
                temp1 = marble[4][2];
                marble[4][2] = temp;
                marble[4][0] = marble[3][1];
                marble[3][1] = temp1;
                break;
            case 6:
                //rot4_90
                temp = marble[3][5];
                marble[3][5] = marble[3][3];
                temp1 = marble[5][5];
                marble[5][5] = temp;
                marble[3][3] = marble[5][3];
                marble[5][3] = temp1;
                //
                temp = marble[4][5];
                marble[4][5] = marble[3][4];
                temp1 = marble[5][4];
                marble[5][4] = temp;
                marble[3][4] = marble[4][3];
                marble[4][3] = temp1;
                break;
            case 7:
                //rot4_270
                temp = marble[3][5];
                marble[3][5] = marble[5][5];
                temp1 = marble[3][3];
                marble[3][3] = temp;
                marble[5][5] = marble[5][3];
                marble[5][3] = temp1;
                //
                temp = marble[4][5];
                marble[4][5] = marble[5][4];
                temp1 = marble[3][4];
                marble[3][4] = temp;
                marble[5][4] = marble[4][3];
                marble[4][3] = temp1;
                break;
            default:
                break;
        }
    }

    public static void cir(int x) {
        circle t;
        circle t1;
        switch (x) {
            //p1 - 270
            case 0:
                t = c[0][0];
                c[0][0] = c[2][0];
                t1 = c[0][2];
                c[0][2] = t;
                c[2][0] = c[2][2];
                c[2][2] = t1;
                //
                t = c[1][0];
                c[1][0] = c[2][1];
                t1 = c[0][1];
                c[0][1] = t;
                c[2][1] = c[1][2];
                c[1][2] = t1;
                break;
            //p1 - 90
            case 1:
                t = c[0][0];
                c[0][0] = c[0][2];
                t1 = c[2][0];
                c[2][0] = t;
                c[0][2] = c[2][2];
                c[2][2] = t1;
                //
                t = c[1][0];
                c[1][0] = c[0][1];
                t1 = c[2][1];
                c[2][1] = t;
                c[0][1] = c[1][2];
                c[1][2] = t1;
                break;
            //p2 - 270
            case 2:
                t = c[3][2];
                c[3][2] = c[3][0];
                t1 = c[5][2];
                c[5][2] = t;
                c[3][0] = c[5][0];
                c[5][0] = t1;
                //
                t = c[5][1];
                c[5][1] = c[4][2];
                t1 = c[4][0];
                c[4][0] = t;
                c[4][2] = c[3][1];
                c[3][1] = t1;
                break;
            //p2 - 90
            case 3:
                t = c[3][0];
                c[3][0] = c[3][2];
                t1 = c[5][0];
                c[5][0] = t;
                c[3][2] = c[5][2];
                c[5][2] = t1;
                //
                t = c[5][1];
                c[5][1] = c[4][0];
                t1 = c[4][2];
                c[4][2] = t;
                c[4][0] = c[3][1];
                c[3][1] = t1;
                break;
            //p3 - 270
            case 4:
                t = c[0][3];
                c[0][3] = c[0][5];
                t1 = c[2][3];
                c[2][3] = t;
                c[0][5] = c[2][5];
                c[2][5] = t1;
                //
                t = c[0][4];
                c[0][4] = c[1][5];
                t1 = c[1][3];
                c[1][3] = t;
                c[1][5] = c[2][4];
                c[2][4] = t1;
                break;
            //p3 - 90
            case 5:
                t = c[0][3];
                c[0][3] = c[2][3];
                t1 = c[0][5];
                c[0][5] = t;
                c[2][3] = c[2][5];
                c[2][5] = t1;
                //
                t = c[0][4];
                c[0][4] = c[1][3];
                t1 = c[1][5];
                c[1][5] = t;
                c[1][3] = c[2][4];
                c[2][4] = t1;
                break;
            //p4 - 270
            case 6:
                t = c[3][5];
                c[3][5] = c[5][5];
                t1 = c[3][3];
                c[3][3] = t;
                c[5][5] = c[5][3];
                c[5][3] = t1;
                //
                t = c[4][5];
                c[4][5] = c[5][4];
                t1 = c[3][4];
                c[3][4] = t;
                c[5][4] = c[4][3];
                c[4][3] = t1;
                break;
            //p4 - 90
            case 7:
                t = c[3][5];
                c[3][5] = c[3][3];
                t1 = c[5][5];
                c[5][5] = t;
                c[3][3] = c[5][3];
                c[5][3] = t1;
                //
                t = c[4][5];
                c[4][5] = c[3][4];
                t1 = c[5][4];
                c[5][4] = t;
                c[3][4] = c[4][3];
                c[4][3] = t1;
                break;
            default:
                break;

        }
    }

}
