package example.day06._aop과제.controller;

import example.day06._aop과제.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    /** [1] 등록 */
    @PostMapping("/day06/_aop")
    public int save(@RequestBody() HashMap<String, Object> map) {
        return studentService.save(map);
    }

    /** [2] 전체조회 */
    @GetMapping("/day06/_aop")
    public List<Map<String, Object>> findAll() {
        return studentService.findAll();
    }
}
