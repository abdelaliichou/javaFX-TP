package org.example.javafx.View;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.example.javafx.Controller.Controller;

public class HomePage implements Vue {
    private Stage stage;
    private Scene scene;
    private Controller controller;

    private BorderPane parent;
    private Button creeUser;
    private Button affichageUsers;


    public HomePage() {
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public static HomePage creeHomePage(Stage stage, Controller controller) {
        HomePage home = new HomePage();
        home.setStage(stage);
        home.setController(controller);
        home.initialiserComposant();
        return home;
    }

    private void initialiserComposant() {
        // initialisation
        this.creeUser = new Button("Creat new user");
        this.affichageUsers = new Button("Show all users");
        this.parent = new BorderPane();

        // on click buttons
        onclick();

        VBox linearLayout = new VBox();
        linearLayout.setAlignment(Pos.CENTER);
        linearLayout.setSpacing(20);

        // adding the 2 button to a vertical layout, one below hte other
        linearLayout.getChildren().addAll(this.creeUser, this.affichageUsers);
        // putting that vertical box in the center on the parent
        this.parent.setCenter(linearLayout);

        // adding a textview
        Label text = new Label("Menu");
        text.setFont(Font.font(32));
        // adding the textview to the parent
        this.parent.setTop(text);

        BorderPane.setAlignment(linearLayout, Pos.CENTER);
        BorderPane.setAlignment(text, Pos.CENTER);

        // setting the scene
        this.setScene(new Scene(this.parent, 600, 700));
    }

    private void onclick() {
        this.creeUser.setOnAction(e -> controller.gotoSecondPage());
        this.affichageUsers.setOnAction(e -> controller.gotoAllUsersPage());
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
}
