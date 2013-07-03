package logic;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity//says that the object will be processed hibernate
@Table(name = "OrderItems")//name table
public class OrderItems implements Serializable{
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)//automatically generates id
    private Long id;//PK

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "idOrder")//name column
    private Order idOrder;//FK
    
    //-------------------
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "orderItems", cascade = CascadeType.ALL)
    private Product idProduct;//FK
    
    
    //-------------------
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Order idOrder) {
        this.idOrder = idOrder;
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }
    
    
}
