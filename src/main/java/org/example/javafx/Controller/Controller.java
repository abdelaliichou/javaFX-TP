package org.example.javafx.Controller;

import javafx.stage.Stage;
import org.example.javafx.Model.Facade;
import org.example.javafx.Model.FacadeImp;
import org.example.javafx.Model.User;
import org.example.javafx.View.AllUsersPage;
import org.example.javafx.View.HomePage;
import org.example.javafx.View.SecondPage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Controller implements Sujet {
    private Facade facade;
    private HomePage homePage;
    private static SecondPage secondPage;
    private static AllUsersPage allUsersPage;


    private Collection<Observateur> observateurs;

    public Controller(Stage stage) {
        this.facade = new FacadeImp();
        this.observateurs = new ArrayList<>();
        initialiseView(stage);
    }

    private void initialiseView(Stage stage){
        this.homePage = HomePage.creeHomePage(stage, this);
        this.secondPage = SecondPage.creeSecondPage(stage, this);
        this.allUsersPage = AllUsersPage.creeAllUsersPage(stage, this);
    }

    public static void gotoSecondPage(){
        secondPage.show();
    }

    public static void gotoAllUsersPage(){
        allUsersPage.show();
    }

    @Override
    public void AjouterObservateur(Observateur o) {
        this.observateurs.add(o);
    }

    @Override
    public void MajAll() {
        this.observateurs.stream().forEach(e-> e.MAJ());
    }

    public void run(){
        homePage.show();
    }

    public Collection<User> getAllUsers(){
        return this.facade.getAllUsers();
    }

    public User saveUser(String nom, String prenom, String pseudo, String password) throws Exception {
        long id = this.facade.creatUser(nom, prenom, pseudo, password);
        this.MajAll();
        User user = facade.getUser(id);
        return user ;
    }


}
