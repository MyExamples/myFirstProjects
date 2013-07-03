package logic;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity//says that the object will be processed hibernate
@Table(name = "Category")//name table
public class Category implements Serializable{
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)//automatically generates id
    private Long id;//PK

    @Column(name= "categoryName", length=64)//name column and its size
    private String categoryName;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "idCategory")
    private List<Product> products;//orders of this user

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    
}
