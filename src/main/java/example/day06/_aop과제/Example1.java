package example.day06._aop과제;

import example.day05.model.mapper.StudentMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// AOP
@Aspect
@Component
class StudentAOP {
    @Before("execution(* example.day06._aop과제.StudentService.findAll(..))")
    public void beforeGet() {
        System.out.println("메소드 실행 전(before) : 전체 조회");
    }
    @Before("execution(* example.day06._aop과제.StudentService.save(..)) && args(map)")
    public void beforePost(HashMap<String, Object> map) {
        System.out.println("메소드 실행 전(before) : " + map + "값 출력");
    }
    @AfterReturning(value = "execution(* example.day06._aop과제.StudentService.*(..))", returning = "result")
    public void afterReturning(Object result) {
        System.out.println("메소드 실행 후(afterReturning) : " + result + " 이/가 리턴됨\n");
    }
    @Around("execution(* example.day06._aop과제.StudentService.*(..))")
    public Object aroundTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println("메소드가 실행된 시간 : " + time + "초 입니다.");
        return result;
    }
}

// 서비스
@Service
class StudentService {

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

// 컨트롤러
@RestController
class StudentController {

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

@MapperScan("example.day05.model.mapper")
@SpringBootApplication
public class Example1 {
    public static void main(String[] args) {
        SpringApplication.run(Example1.class);
    }
}
