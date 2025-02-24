package example.day04.service;

import example.day04.model.dto.StudentDto;
import example.day04.model.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    /** 학생 점수 등록 */
    public int _write(StudentDto studentDto) {
        System.out.println(">> StudentService._write start");
        System.out.println(">> studentDto = " + studentDto);
        int result = studentMapper._write(studentDto);
        System.out.println(">> StudentService._write end\n");
        return result;
    }

    /** 학생 전체 조회 */
    public List<StudentDto> _findAll() {
        System.out.println(">> StudentService._findAll start");
        List<StudentDto> result = studentMapper._findAll();
        System.out.println(">> StudentService._findAll end\n");
        return result;
    }

    /** 학생 개별 수정 */
    public boolean _update(StudentDto studentDto) {
        System.out.println(">> StudentService._update start");
        System.out.println(">> studentDto = " + studentDto);
        boolean result = studentMapper._update(studentDto);
        System.out.println(">> StudentService._update end\n");
        return result;
    }

    /** 학생 개별 삭제 */
    public boolean _delete(int sno) {
        System.out.println(">> StudentService._delete start");
        System.out.println(">> sno = " + sno);
        boolean result = studentMapper._delete(sno);
        System.out.println(">> StudentService._delete end\n");
        return result;
    }

}
