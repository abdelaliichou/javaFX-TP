package org.example.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.javafx.Controller.Controller;
import org.example.javafx.View.AllUsersPage;
import org.example.javafx.View.HomePage;
import org.example.javafx.View.SecondPage;
import org.example.javafx.View.Vue;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Controller controller = new Controller(stage);
        controller.run();
    }

    public static void main(String[] args) {
        launch();
    }
}