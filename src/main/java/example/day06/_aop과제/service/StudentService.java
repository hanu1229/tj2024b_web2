package example.day06._aop과제.service;

import example.day06._aop과제.model.Mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    /** [1] 등록 */
    public int save(HashMap<String, Object> map) {
        int result = studentMapper.save(map);
        return result;
    }

    /** [2] 전체조회 */
    public List<Map<String, Object>> findAll() {
        return studentMapper.findAll();
    }
}
