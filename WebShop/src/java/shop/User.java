package shop;

import java.util.ArrayList;
import logic.Order;

public class User {
    
    public Integer id;
    public String login;
    public String password;
        
    public User(){
        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

        
}
