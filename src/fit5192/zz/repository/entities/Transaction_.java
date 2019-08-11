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
import javax.persistence.ManyToOne;
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
@NamedQuery(name = "Transaction.SearchTransactionsByUserId", query = "SELECT t FROM Transaction_ t WHERE t.user.id =:id")
@XmlRootElement
public class Transaction_ implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @NotNull
    private int id;
    
    @Column(name = "DATE")
    @NotNull
    @Past
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @OneToMany(/*mappedBy = "TRANSACTION_ID", */cascade = CascadeType.ALL)
    @NotNull
    private List<Product> products;
    
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "USER_ID")
    @NotNull
    private User_ user;

    public Transaction_() {
        
    }

    public Transaction_(Date date, List<Product> products, User_ user) {
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
