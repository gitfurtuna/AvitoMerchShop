package demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import demo.Service.WorkerService;

@RestController
public class DashboardController {
    @Autowired
    private WorkerService workerService;
}

