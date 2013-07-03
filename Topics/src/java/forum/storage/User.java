package forum.storage;

import java.util.ArrayList;
import logic.Topics;

/**
 *
 * @author Julia
 */
public class User {
    
    private Integer id;
    private String login;
    private String password;
        
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
