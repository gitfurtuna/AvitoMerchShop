package demo.Service;

import demo.DTO.AuthRequest;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import demo.Model.Worker;
import demo.Repository.WorkerRepository;
import io.jsonwebtoken.Jwts;
import javax.naming.AuthenticationException;
import java.util.Date;

@Service
public class WorkerService {
    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final String SECRET_KEY = "DDJ893YC77DHX:HXD732DX465TY38:HXC89XY237HX:X8947T28378YX4";

    private final long EXPIRATION_TIME = 86400000;

    public void register(Worker worker) {
        Worker existingWorker = workerRepository.findByEmail(worker.getEmail());
        if (existingWorker != null) {
            throw new IllegalArgumentException("Worker with this email already exists: " + worker.getEmail());
        }
        worker.setPassword(passwordEncoder.encode(worker.getPassword()));
        workerRepository.save(worker);
    }

    public String login(AuthRequest authRequest) throws AuthenticationException{
        Worker existingWorker = workerRepository.findByEmail(authRequest.getEmail());
        if (existingWorker == null) {
            throw new AuthenticationException("Worker with this email is not found: " + authRequest.getEmail());
        }
       if (!passwordEncoder.matches(authRequest.getPassword(), existingWorker.getPassword())) {
             throw new AuthenticationException("Invalid password for worker with email: " + authRequest.getEmail());
        }
        return generateToken(existingWorker);
    }

    private String generateToken(Worker worker) {
        long nowMillis = System.currentTimeMillis();
        long expMillis = nowMillis + EXPIRATION_TIME;
        Date exp = new Date(expMillis);

        return Jwts.builder()
                .setSubject(worker.getEmail())
                .setIssuedAt(new Date(nowMillis))
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();

    }
}
