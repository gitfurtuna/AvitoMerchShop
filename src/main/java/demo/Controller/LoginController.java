package demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import demo.Service.WorkerService;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private WorkerService workerService;

}
