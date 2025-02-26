package example.day05.controller;

import example.day05.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/day05/student")
public class StudentController {

    // 빈 주입
    @Autowired
    private StudentService studentService;

    /** [1] 등록 */
    @PostMapping("")
    public int save(@RequestBody() HashMap<String, Object> map) {
        System.out.println(">> StudentController.save start");
        System.out.println(">> map = " + map);
        System.out.println(">> StudentController.save end\n");
        return studentService.save(map);
    }

    /** [2] 전체조회 */
    @GetMapping("")
    public List<Map<String, Object>> findAll() {
        System.out.println(">> StudentController.findAll start");
        System.out.println(">> StudentController.findAll end\n");
        return studentService.findAll();
    }

    /** [*] 특정 점수 이상 학생 조회 */
    @GetMapping("/find/score")
    public List<Map<String, Object>> findStudentScore(@RequestParam() int minKor, @RequestParam() int minMath) {
        return studentService.findStudentScore(minKor, minMath);
    }

    /** [3] 수정 */
    @PutMapping("")
    public int update(@RequestBody() Map<String, Object> map) {
        System.out.println(">> StudentController.update start");
        System.out.println(">> map = " + map);
        System.out.println(">> StudentController.update end\n");
        return studentService.update(map);
    }

    /** [4] 삭제 */
    @DeleteMapping("")
    public boolean delete(@RequestParam(name="sno") int sno) {
        System.out.println(">> StudentController.delete start");
        System.out.println(">> sno = " + sno);
        System.out.println(">> StudentController.delete end\n");
        return studentService.delete(sno);
    }

}
