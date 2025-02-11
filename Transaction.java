package ru._21school.ru.student.rossartb.avitoshop.domain.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @Column(name = "id")
    private String transactionId;

    @ManyToOne
    @JoinColumn(name = "sender", referencedColumnName = "id")
    private Worker sender;

    @ManyToOne
    @JoinColumn(name = "recipient", referencedColumnName = "id")
    private Worker recipient;

    @Column(name = "category")
    private String category;

    @Column(name = "coins")
    private Long coins;

    @Column(name = "date/time")
    private LocalDateTime date;
}
