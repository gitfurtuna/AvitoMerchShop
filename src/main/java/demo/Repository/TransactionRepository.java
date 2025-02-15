package demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import demo.Model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
