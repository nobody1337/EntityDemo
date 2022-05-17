package de.Entity.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item {
    //Artikelattribute
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /*
        Beziehung zwischen Item und Order
        Viele zu viele Beziehung
        Ein Item kann in beliebig vielen Bestellungen enthalten sein,
        eine Bestellung kann viele Items enthalten.
     */
    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledItems")
    private Set<Order>orders = new HashSet<>();
    private String itemName;
    private double itemPrice;

    //Getter und Setter
    public long getId() {
        return id;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public double getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    public Set<Order> getOrders() {
        return orders;
    }
}
