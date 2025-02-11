package ru._21school.ru.student.rossartb.avitoshop.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "workers")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "balance/coins")
    private Long balance;

    @ManyToOne
    @JoinColumn(name = "merch", referencedColumnName = "id")
    private List<Merch> merch;

    @OneToMany(mappedBy = "sender")
    private List<Transaction> sent;

    @OneToMany(mappedBy = "recipient")
    private List<Transaction> received;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Long getBalance() {
        return balance;
    }

    public Merch getMerch() {
        return merch;
    }

    public void updateBalance(Long coins) {
        if (this.balance + coins < 0) {
            throw new IllegalArgumentException("Insufficient coins for this transaction");
        }
        this.balance += coins;
    }

}
