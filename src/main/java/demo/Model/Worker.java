package demo.Model;

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
    private Long balance = Long.valueOf(1000);

    @ManyToMany
    @JoinTable(
            name = "worker_merch",
            joinColumns = @JoinColumn(name = "worker_id"),
            inverseJoinColumns = @JoinColumn(name = "merch_id")
    )
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

    public List<Merch> getMerch() { return merch; }

    public List<Transaction> getSent() {
        return sent;
    }

    public List<Transaction> getReceived() {
        return received;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void updateBalance(Long coins) {
        if (this.balance + coins < 0) {
            throw new IllegalArgumentException("Insufficient coins for this transaction");
        }
        this.balance += coins;
    }

}
