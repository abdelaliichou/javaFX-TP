package org.example.javafx.Model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FacadeImp implements Facade{

    private Map<Long, User> users;

    public FacadeImp() {
        this.users = new HashMap<>();
    }

    @Override
    public long creatUser(String nom, String prenom, String login, String password) {
        User user = User.creatUser(nom,prenom,prenom,password);
        this.users.put(user.getId(), user);
        return user.getId();
    }

    @Override
    public User getUser(long id) throws Exception {
        if (this.users.containsKey(id)){
            return this.users.get(id);
        } else {
            throw new Exception();
        }
    }

    @Override
    public Collection<User> getAllUsers() {
        return this.users.values();
    }
}
