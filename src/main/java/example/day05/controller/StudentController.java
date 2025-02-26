package example.day05.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    /** [1] 등록 */
    @PostMapping("")
    public int save(@RequestBody() HashMap<String, Object> map) {
        System.out.println(">> StudentController.save start");
        System.out.println(">> map = " + map);
        System.out.println(">> StudentController.save end\n");
        return 1;
    }

    /** [2] 전체조회 */
    @GetMapping("")
    public Map<String, Object> findAll() {
        System.out.println(">> StudentController.findAll start");
        System.out.println(">> StudentController.findAll end\n");
        return null;
    }

    /** [3] 수정 */
    @PutMapping("")
    public int update(@RequestBody() Map<String, Object> map) {
        System.out.println(">> StudentController.update start");
        System.out.println(">> map = " + map);
        System.out.println(">> StudentController.update end\n");
        return 1;
    }

    /** [4] 삭제 */
    @DeleteMapping("")
    public boolean delete(@RequestParam(name="sno") int sno) {
        System.out.println(">> StudentController.delete start");
        System.out.println(">> sno = " + sno);
        System.out.println(">> StudentController.delete end\n");
        return true;
    }

}
