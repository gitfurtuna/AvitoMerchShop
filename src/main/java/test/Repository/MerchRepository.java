package test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.AvitoMerchShop.Merch;

public interface MerchRepository extends JpaRepository<Merch, Long> {

}
