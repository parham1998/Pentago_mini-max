package pentago;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class main extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 500, 500);

        scene.setOnMousePressed((MouseEvent event) -> {
            primaryStage.close();
            board K = new board();
            K.start(primaryStage);
        });

        ImageView im = new ImageView(getClass().getResource("p.png").toExternalForm());
        root.getChildren().add(im);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
