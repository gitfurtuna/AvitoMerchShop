package demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import demo.Model.Worker;
import demo.Repository.WorkerRepository;

@Service
public class WorkerService {
    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final String SECRET_KEY = "DDJ893YC77DHX:HXD732DX465TY38:HXC89XY237HX:X8947T28378YX4";

    private final long EXPIRATION_TIME = 86400000;

    public void register(Worker worker) {
        worker.setPassword(passwordEncoder.encode(worker.getPassword()));
        workerRepository.save(worker);
    }


}
