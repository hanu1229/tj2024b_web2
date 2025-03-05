package example.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/*
    조과제
        1. TaskController에서 TaskService의 'method1'메소드를 호출하는 방법
        2. 최소 6개 이상 방법 찾기
*/

@RestController
// public class TaskController
public class TaskController extends TaskService {

    public TaskController() {}

    /* 멤버변수에 주입 */
    @Autowired
    private TaskService taskService1;

    /* 생성자에 주입 */
//    final TaskService taskService2;
//    @Autowired
//    public TaskController(TaskService taskService2) {
//        this.taskService2 = taskService2;
//    }

    /* Setter를 이용한 주입 */
    private TaskService taskService3;
    @Autowired
    public void setTaskService3(TaskService taskService3) {this.taskService3 = taskService3;}

    /* 그냥 호출 */
    private TaskService taskService4 = new TaskService();
    @Override
    public void method2() {
        super.method2();
        System.out.println("자식호출");
    }

    public void temp() {
        /* 멤버변수에 주입 */
//        taskService1.method1();
        /* 생성자에 주입 */
//        taskService2.method1();
        /* Setter를 이용한 주입 */
//        taskService3.method1();
        /* 그냥 호출 */
//        taskService4.method1();
        /* 싱글톤 호출 */
//        TaskService.getInstance().method1();
        /* 상속 */
//        method1();
        /* method1함수에 스태틱 */
//        TaskService.method1();
        method2();
    }

}
