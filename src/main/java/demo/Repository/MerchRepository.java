package demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import demo.Model.Merch;
@Repository
public interface MerchRepository extends JpaRepository<Merch, Long> {

}
