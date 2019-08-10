/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.zz.repository.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dylanz
 */
@Entity
@Table(name = "PRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.searchProductByAnyAttribute", query = "SELECT p FROM Product p WHERE p.id=:id,"
                                                + "ORDER BY select AVG(r.value) FROM Rating r WHERE  r.product=:product DESC")//我有强烈的感觉 这个语句会出错 r.value真的需要？
})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    //reference to https://blog.csdn.net/zgljl2012/article/details/51052322
    private static final String priceFormat = "(^[1-9]\\d*(\\.\\d{1,2})?$)|(^0(\\.\\d{1,2})?$)";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //self increasing
    @Column(name = "ID", nullable = false)
    @NotNull
    private int id;
    
    @Column(name = "NAME")
    @NotNull
    private String name;  // full name, including category name
    
    @Column(name = "IMG_PATH")
    private String imgPath;
    
    @Column(name = "CATEGORY")
    private int category;
    
    @Column(name = "AREA")
    private String area;
    
    @Column(name = "PRICE")
    @NotNull
    //Can the reg validate the float? yes
    @Pattern(regexp = priceFormat)
    private float price;  // unit price
    
    //if the inventory is 0, mean the goods are sold out today
    @Column(name = "INVENTORY")
    @Min(0)
    private int inventory;
    
    @Column(name = "DESCRIPTION")
    private String description;
    
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rating> ratings;

    public Product() {
    }
    public Product(int id, String name, String imgPath, int category, String area, float price, int inventory, String description, List<Rating> ratings) {
        this.id = id;
        this.name = name;
        this.imgPath = imgPath;
        this.category = category;
        this.area = area;
        this.price = price;
        this.inventory = inventory;
        this.description = description;
        this.ratings = ratings;
    }


    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit5192.zz.repository.entities.Fruit[ id=" + id + " ]";
    }
    
}
