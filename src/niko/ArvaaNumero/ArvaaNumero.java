package niko.ArvaaNumero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ArvaaNumero extends Application {

    private Parent root;
    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        controller = new Controller(primaryStage);
//        root = FXMLLoader.load(getClass().getResource("gui.fxml"));
        loader.setController(controller);
        root = loader.load();
        controller.BindEvents();
        primaryStage.setTitle("Arvaa oikea numero");
        primaryStage.setMinWidth(600);
        primaryStage.setMinHeight(250);
        primaryStage.setScene(new Scene(root, 600, 250));
        primaryStage.show();
        primaryStage.setOnCloseRequest((event)-> System.exit(0));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
