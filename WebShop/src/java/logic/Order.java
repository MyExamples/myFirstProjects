package logic;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Orders")
public class Order implements Serializable{
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)//automatically generates id
    private Long id;//PK

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "idUser")//name column
    private Users idUser;//FK idUser
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "idOrder")
    private List<OrderItems> orderItems;//orders of this user
    
    
    //this table can contain a lot of data, Therefore exists one more table OrderItems

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
    }

    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }

    
    
}