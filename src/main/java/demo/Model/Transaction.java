package demo.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

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

//    @Column(name = "category")
//    private String category;

    @Column(name = "coins")
    private Long coins;

    @Column(name = "date/time")
    private LocalDateTime date;

    public Transaction(Worker sender, Worker recipient, Long coins) {
        if (coins <= 0) {
            throw new IllegalArgumentException("Transaction amount cannot be negative");
        }
        this.transactionId = UUID.randomUUID().toString();
        this.sender = sender;
        this.recipient = recipient;
        this.coins = coins;
        this.date = LocalDateTime.now();

        sender.updateBalance(-coins);
        recipient.updateBalance(coins);
    }

}

