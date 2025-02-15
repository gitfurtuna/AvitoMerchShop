package demo.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "merch")
public class Merch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "price")
    private Long price;

    @ManyToMany(mappedBy = "merch")
    private List<Worker> workers;

    public Merch(String name, Long price) {
        this.name = name;
        this.price = price;
    }

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

