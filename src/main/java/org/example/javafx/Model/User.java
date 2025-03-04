package org.example.javafx.Model;

public class User {
    private String nom;
    private String prenom;
    private String pseudo;
    private String password;
    private long id;

    private static long IDS = 0;

    private User(String nom, String prenom, String pseudo, String password) {
        this.id = IDS++;
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.password = password;
    }

    public static User creatUser(String nom, String prenom, String pseudo, String password){
        return new User(nom, prenom, pseudo, password);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }
}
