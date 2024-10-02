package org.example.javafx.View;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.example.javafx.Controller.Controller;
import org.example.javafx.Controller.Observateur;
import org.example.javafx.Model.User;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;

public class AllUsersPage implements Vue, Observateur {
    private Stage stage;
    private Scene scene;

    @FXML
    private ListView<User> list;
    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public AllUsersPage() {
    }

    public static AllUsersPage creeAllUsersPage(Stage stage, Controller controller) {
        URL location = AllUsersPage.class.getResource("/org/example/javafx/allUsers.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        // here with the load() function, we are returning always the parent of the fxml view
        try {
            BorderPane parent = fxmlLoader.load();
            AllUsersPage vue = fxmlLoader.getController();
            vue.setScene(new Scene(parent, 600,700));
            vue.setStage(stage);
            vue.setController(controller);
            controller.AjouterObservateur(vue);
            return vue;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void MAJ() {
        Collection<User> users = this.controller.getAllUsers();
        this.list.setItems(FXCollections.observableArrayList(users));
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void show() {
        // just pour afficher notre page qu'on cree
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void goBack(ActionEvent actionEvent) {
        this.controller.run();
    }
}
