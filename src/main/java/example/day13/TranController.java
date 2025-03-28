package example.day13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/day13/users")
public class TranController {

    private final TranService tranService;
    @Autowired
    public TranController(TranService tranService) { this.tranService = tranService; }

    @PostMapping("")
    public boolean tran() {
        tranService.tran();
        return true;
    }

    // 이체 관련
    @PostMapping("/transfer")
    public boolean transfer(@RequestBody() Map<String, String> params) {
        // {"money" : "100000", "fromName" : "서장훈", "toName" : "신동엽"}
        System.out.println("TranController.treansfer");
        System.out.println("params = " + params);
        try {
            tranService.transfer(params);
            // 예외가 발생하지 않았다면 이체 완료
            return true;
        } catch(Exception e) {
            // 예외가 발생했다면 이체 실패
            System.out.println(e);
            return false;
        }
    }



}
