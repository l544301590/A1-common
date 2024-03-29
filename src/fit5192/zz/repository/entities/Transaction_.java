/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.zz.repository.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dylanz
 */
@Entity
@Table(name = "TRANSACTION_")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaction_.findAll", query = "SELECT t FROM Transaction_ t"),
    @NamedQuery(name = "Transaction_.SearchTransactionsByUserId", query = "SELECT t FROM Transaction_ t WHERE t.user.id = :userId")
})
public class Transaction_ implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @NotNull
    private int id;

    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "transaction__product",
            joinColumns = @JoinColumn(name = "transaction__id"),
            inverseJoinColumns = @JoinColumn(name = "products_id")
    )
    private List<Product> products;

    @ManyToOne(fetch = FetchType.EAGER)//这里改了
    @JoinColumn(name = "USER_ID", nullable = false)
    private User_ user;

    public Transaction_() {

    }

    public Transaction_(Date date, List<Product> products, User_ user) {
        this.date = date;
        this.products = products;
        this.user = user;
    }

    public Transaction_(int id, Date date, List<Product> products, User_ user) {
        this.id = id;
        this.date = date;
        this.products = products;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public User_ getUser() {
        return user;
    }

    public void setUser(User_ user) {
        this.user = user;
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
        if (!(object instanceof Transaction_)) {
            return false;
        }
        Transaction_ other = (Transaction_) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit5192.zz.repository.entities.Transaction[ id=" + id + " ]";
    }

}
