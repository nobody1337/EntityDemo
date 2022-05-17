package de.Entity.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {
    //Kundenattribute
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /*
        Beziehung zwischen Customer und Order
        Ein Customer kann viele Order enthalten
    */
    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Order> orders = new HashSet<>();

    private String firstName;
    private String lastName;
    private String eMail;

    //Getter und Setter
    public long getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String geteMail() {
        return eMail;
    }
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    public Set<Order> getOrders() {
        return orders;
    }
}
