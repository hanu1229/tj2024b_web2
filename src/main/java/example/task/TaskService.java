package example.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
//    private static TaskService instance = new TaskService();
//    private TaskService() {}
//    public static TaskService getInstance() {return instance;}
    public TaskService() {}

    static void method1() {}
    void method2() {
        System.out.println("부모 호출");
    }

}
