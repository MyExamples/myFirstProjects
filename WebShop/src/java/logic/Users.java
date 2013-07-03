package logic;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity//says that the object will be processed hibernate
@Table(name = "Users")//name table
public class Users implements Serializable{
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)//automatically generates id
    private Long id;//PK

    @Column(name= "login", length=64)//name column and its size
    private String login;
    
    @Column(name= "password", length=64)
    private String password;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "idUser")
    private List<Order> orders;//orders of this user

    public Users() {
    }

    public Users(long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
