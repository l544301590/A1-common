/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.zz.repository.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dylanz
 */
@Entity
@Table(name = "RATING")
@NamedQuery(name = "Rating.searchRatingByProduct", query = "select r FROM Rating r WHERE  r.product=:product")
@XmlRootElement
public class Rating implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @NotNull
    private int id;
    
    @Column(name = "VALUE", precision = 1)
    @Max(5)
    @Min(1)
    private int value;
    
    @Column(name = "COMMENT", length = 511)
    private String comment;
    
    @ManyToOne()
    @JoinColumn(name = "PRODUCT_ID",nullable = false)
    private Product product;
    
    @ManyToOne()
    @JoinColumn(name = "USER_ID",nullable = false)
    private User_ user;

    public Rating() {
        
    }

    public Rating(int value, Product product, User_ user) {
        this.value = value;
        this.product = product;
        this.user = user;
    }
    

    public Rating(int id, int value, String comment, Product product, User_ user) {
        this.id = id;
        this.value = value;
        this.comment = comment;
        this.product = product;
        this.user = user;
    }
    
    
    public User_ getUser() {
        return user;
    }

    public void setUser(User_ user) {
        this.user = user;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
        if (!(object instanceof Rating)) {
            return false;
        }
        Rating other = (Rating) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit5192.zz.repository.entities.Rating[ id=" + id + " ]";
    }
    
}
