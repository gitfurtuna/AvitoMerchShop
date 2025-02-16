package demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import demo.Service.WorkerService;

@RestController
@RequestMapping("/api")
public class DashboardController {
    @Autowired
    private WorkerService workerService;
//
//    @GetMapping("/info")
//    public ResponseEntity<String> getInfo() {
//        // Логика получения информации о монетах, инвентаре и истории транзакций
//        String info = "Информация о монетах, инвентаре и истории транзакций";
//        return ResponseEntity.ok(info);
//    }
//
//    @PostMapping("/sendCoin")
//    public ResponseEntity<String> sendCoin(@RequestBody SendCoinRequest request) {
//        // Логика для отправки монет другому пользователю
//        return ResponseEntity.ok("Монеты успешно отправлены пользователю: " + request.getRecipientEmail());
//    }
//
//    @PostMapping("/buy/{item}")
//    public ResponseEntity<String> buyItem(@PathVariable String item) {
//        // Логика для покупки предмета
//        return ResponseEntity.ok("Предмет " + item + " успешно куплен");
//    }


}

