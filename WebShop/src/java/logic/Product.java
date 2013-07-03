package logic;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity//says that the object will be processed hibernate
@Table(name = "Product")//name table
public class Product implements Serializable{
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)//automatically generates id
    private Long id;//PK

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private OrderItems orderItems;//FK
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "idCategory")//name column
    private Category idCategory;//FK
    
    @Column(name= "productName", length=64)//name column and its size
    private String productName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderItems getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(OrderItems orderItems) {
        this.orderItems = orderItems;
    }

    public Category getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    
}
