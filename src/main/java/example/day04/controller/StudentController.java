package example.day04.controller;

import example.day04.model.dto.StudentDto;
import example.day04.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/day04")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /** 학생 점수 등록 */
    @PostMapping("/student")
    public int _write(@RequestBody() StudentDto studentDto) {
        System.out.println(">> StudentController._write start");
        System.out.println(">> studentDto = " + studentDto);
        int result = studentService._write(studentDto);
        System.out.println(">> StudentController._write end\n");
        return result;
    }

    /** 학생 전체 조회 */
    @GetMapping("/student")
    public List<StudentDto> _findAll() {
        System.out.println(">> StudentController._findAll start");
        List<StudentDto> result = studentService._findAll();
        System.out.println(">> StudentController._findAll end\n");
        return result;
    }

    /** 학생 개별 수정 */
    @PutMapping("/student")
    public boolean _update(@RequestBody() StudentDto studentDto) {
        System.out.println(">> StudentController._update start");
        System.out.println(">> studentDto = " + studentDto);
        boolean result = studentService._update(studentDto);
        System.out.println(">> StudentController._update end\n");
        return result;
    }

    /** 학생 개별 삭제 */
    @DeleteMapping("/student")
    public boolean _delete(@RequestParam(name="sno") int sno) {
        System.out.println(">> StudentController._delete start");
        System.out.println(">> sno = " + sno);
        boolean result = studentService._delete(sno);
        System.out.println(">> StudentController._delete end\n");
        return result;
    }

}
