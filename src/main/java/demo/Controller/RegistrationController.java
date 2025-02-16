package demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import demo.Model.Worker;
import demo.Service.WorkerService;

@RestController
@RequestMapping("/api/auth")
public class RegistrationController {

    @Autowired
    private WorkerService workerService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Worker worker) {
        workerService.register(worker);
        return ResponseEntity.status(HttpStatus.OK).body("Worker registered successfully");

    }

}
