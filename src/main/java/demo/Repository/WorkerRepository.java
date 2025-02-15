package demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import demo.Model.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker,Long> {
}
