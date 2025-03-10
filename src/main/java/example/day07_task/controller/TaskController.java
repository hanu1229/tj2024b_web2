package example.day07_task.controller;

import example.day07_task.model.dto.TaskDto;
import example.day07_task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/day07/task")
@CrossOrigin("http://192.168.40.64:5173/")
public class TaskController {

    private final TaskService taskService;
    @Autowired
    public TaskController(TaskService taskService) {this.taskService = taskService;}

    @PostMapping("")
    public boolean save(@RequestBody() TaskDto taskDto) {
        System.out.println("TaskController.save");
        System.out.println("taskDto = " + taskDto);
        boolean result = taskService.save(taskDto);
        return result;
    }

    @GetMapping("")
    public List<TaskDto> findAll() {
        System.out.println("TaskController.findAll");
        List<TaskDto> result = taskService.findAll();
        return result;
    }

}
