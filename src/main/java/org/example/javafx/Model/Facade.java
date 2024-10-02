package org.example.javafx.Model;

import java.util.Collection;

public interface Facade {
    long creatUser(String nom, String prenom, String login, String password);
    User getUser(long id) throws Exception;
    Collection<User> getAllUsers();

}
