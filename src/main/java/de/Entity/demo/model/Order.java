package de.Entity.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Set;

@Entity
public class Order {
    //Bestellattribute
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date orderDate;

    //Getter und Setter
}
