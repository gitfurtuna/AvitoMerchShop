package demo.Controller;

import demo.DTO.AuthRequest;
import demo.DTO.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import demo.Service.WorkerService;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private WorkerService workerService;

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody AuthRequest authRequest) throws AuthenticationException {
        String token = workerService.login(authRequest);
        return ResponseEntity.ok(new AuthResponse(token));
    }

}
