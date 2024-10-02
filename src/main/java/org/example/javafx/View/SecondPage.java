package org.example.javafx.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.example.javafx.Controller.Controller;
import org.example.javafx.Model.User;

import java.io.IOException;
import java.net.URL;

public class SecondPage implements Vue {
    private Stage stage;
    private Scene scene;
    private Controller controller;

    @FXML
    private TextField Nom;
    @FXML
    private TextField Prenom;
    @FXML
    private TextField Pseudo;
    @FXML
    private PasswordField Password;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public SecondPage() {
    }

    public static SecondPage creeSecondPage(Stage stage, Controller controller) {
        URL location = SecondPage.class.getResource("/org/example/javafx/SecondPage.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        // here with the load() function, we are returning always the parent of the fxml view
        try {
            BorderPane parent = fxmlLoader.load();
            SecondPage vue = fxmlLoader.getController();
            vue.setScene(new Scene(parent, 600, 700));
            vue.setStage(stage);
            vue.setController(controller);
            return vue;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setNom(String nom) {
        this.Nom.setText(nom);
    }

    public void setPrenom(String prenom) {
        this.Prenom.setText(prenom);
    }

    public void setPseudo(String pseudo) {
        this.Pseudo.setText(pseudo);
    }

    public void setPassword(String password) {
        this.Password.setText(password);
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
        System.out.println("Going back ");
        this.controller.run();
    }

    public void saveUser(ActionEvent actionEvent) throws Exception {
        String nom = this.Nom.getText();
        String prenom = this.Prenom.getText();
        String pseudo = this.Pseudo.getText();
        String password = this.Password.getText();
        // doing all types of verifications
        if (!nom.isEmpty() && !prenom.isEmpty() && !pseudo.isEmpty() && !password.isEmpty()){
            User user = this.controller.saveUser(nom, prenom, pseudo, password);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "The user "+user.getNom()+" has been created !", ButtonType.OK);
            alert.showAndWait();
        }
        System.out.println("Saving user ");
    }

    public void clearAll(ActionEvent actionEvent) {
        this.setNom("");
        this.setPrenom("");
        this.setPseudo("");
        this.setPassword("");
        System.out.println("Clearing all ");
    }
}
