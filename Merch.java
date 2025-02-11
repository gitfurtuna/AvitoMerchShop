package ru._21school.ru.student.rossartb.avitoshop.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "merch")
public class Merch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Long price;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }
}
