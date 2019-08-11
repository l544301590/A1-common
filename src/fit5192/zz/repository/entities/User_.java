/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.zz.repository.entities;

import fit5192.zz.utils.EmailValidation;
import fit5192.zz.utils.PasswordValidation;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dylanz
 * bean validation：@author Zheng Ru
 */
@Entity
@Table(name = "USER_")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User_.findAll", query = "SELECT u FROM User_ u"),
    @NamedQuery(name = "User_.searchUserByEmail", query = "SELECT u FROM User_ u WHERE u.email=:email")
})
public class User_ implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String emailFormat="^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$"; 
    private static final String phoneFormat="(^[9][0-9]{8}$|^[0][0-9]{9}$)"; //the first digit of the phone number must be a 9 and the number must be 8 digits long
    private static final String passwordFormat="^(?=.*[a-zA-Z])(?=.*[1-9])(?=.*[\\W]).{8,20}$"; 
    private static final String nameFormat="^[a-zA-Z]+$";// only have letter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "ID")
    private int id;
    
    // TODO Bean Validation DISTINCT
    @Column(name = "EMAIL", length = 63)
    @NotNull
    @Pattern(regexp = emailFormat)
    private String email;
    
    @Column(name = "NICKNAME", length = 31)
    @NotNull
    private String nickname;
    
    @Column(name = "PASSWORD", length = 31)
    @NotNull
    @Pattern(regexp = passwordFormat)
    private String password;
    
    //there are 4 levels
    @Column(name = "LEVEL", precision = 1)
    @NotNull
    @Min(1)
    @Max(4)
    private int level;
    
    @Column(name = "LASTNAME", length = 15)
    @Pattern(regexp =nameFormat)
    private String lastName;
    
    @Column(name = "FIRSTNAME", length = 15)
    @Pattern(regexp =nameFormat )
    private String firstName;
    
    @Column(name = "ADDRESS", length = 63)
    private String address;
    
    @Column(name = "PHONE", length = 15)
    @Pattern(regexp =phoneFormat)
    private String phone;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Transaction_> transactions;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)  // mappedBy写的是Rating里的对象变量名
    private List<Rating> ratings;

    public User_() {
        
    }

    public User_(String email, String password) {
        this.email = email;
        this.nickname = email;
        this.password = password;
        this.level = 1;
    }

    public User_(int id, String email, String nickname, String password, int level, String lastName, String firstName, String address, String phone, List<Transaction_> transactions, List<Rating> ratings) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.level = level;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phone = phone;
        this.transactions = transactions;
        this.ratings = ratings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Transaction_> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction_> transactions) {
        this.transactions = transactions;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
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
        if (!(object instanceof User_)) {
            return false;
        }
        User_ other = (User_) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit5192.zz.repository.entities.User[ id=" + id + " ]";
    }
    
}
