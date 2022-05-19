package de.Entity.demo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Order {
    //Bestellattribute
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /*
        Beziehung zwischen Order und Item
        Viele zu viele Beziehung
        Ein Item kann in beliebig vielen Bestellungen enthalten sein,
        eine Bestellung kann viele Items enthalten.
     */
    @ManyToMany
    @JoinTable( name = "item_enrolled",
                joinColumns = @JoinColumn(name = "order_id"),
                inverseJoinColumns = @JoinColumn(name = "item_id")
              )
    private Set<Item> enrolledItems = new HashSet<>();
    /*
        Beziehung zwischen Order und Customer
        Viele Order können einen Customer enthalten
     */
    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;

    private String orderDate;

    //Getter und Setter
    public long getId() {
        return id;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    public Set<Item> getEnrolledItems() {
        return enrolledItems;
    }
    public Customer getCustomer() {
        return customer;
    }

    //Methode um ein Item hinzuzufügen
    public void enrollItem(Item item) {
        enrolledItems.add(item);
    }
    //Methode um einen Customer hinzuzufügen
    public void assignCustomer(Customer customer) {
        this.customer = customer;
    }
}
