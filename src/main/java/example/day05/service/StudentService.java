package example.day05.service;

import example.day05.model.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 빈 등록
@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    /** [1] 등록 */
    public int save(HashMap<String, Object> map) {
        System.out.println(">> StudentService.save start");
        System.out.println(">> map = " + map);
        System.out.println("======== SQL 처리 전 ========");
        int result = studentMapper.save(map);
        System.out.println(">> result = " + result);
        System.out.println("======== SQL 처리 후 ========");
        System.out.println("map = " + map);
        System.out.println(">> StudentService.save end\n");
        // map = {sno=4, name=유재석, kor=100, math=90}
        // sql을 처리하기 전 sno는 없었지만 sql이 처리된 후 sno가 존재한다.
        return result;
    }

    /** [2] 전체조회 */
    public List<Map<String, Object>> findAll() {
        System.out.println(">> StudentService.findAll start");
        System.out.println(">> StudentService.findAll end\n");
        return studentMapper.findAll();
    }

    /** [*] 특정 점수 이상 학생 조회 */
    public List<Map<String, Object>> findStudentScore(int minKor, int minMath) {
        return studentMapper.findStudentScore(minKor, minMath);
    }

    /** [3] 수정 */
    public int update(Map<String, Object> map) {
        System.out.println(">> StudentService.update start");
        System.out.println(">> map = " + map);
        System.out.println(">> StudentService.update end\n");
        return studentMapper.update(map);
    }

    /** [4] 삭제 */
    public boolean delete(int sno) {
        System.out.println(">> StudentService.delete start");
        System.out.println(">> sno = " + sno);
        System.out.println(">> StudentService.delete end\n");
        return studentMapper.delete(sno);
    }

    /** [5] 여러명 등록 */
    public boolean saveAll(List<Map<String, Object>> list) {
        System.out.println(">> StudentService.saveAll start");
        System.out.println(">> list = " + list);
        System.out.println(">> StudentService.saveAll end\n");
        return studentMapper.saveAll(list);
    }

}
