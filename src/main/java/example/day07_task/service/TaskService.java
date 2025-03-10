package example.day07_task.service;

import example.day07_task.model.dto.TaskDto;
import example.day07_task.model.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskMapper taskMapper;
    @Autowired
    public TaskService(TaskMapper taskMapper) {this.taskMapper = taskMapper;}

    public boolean save(TaskDto taskDto) {
        System.out.println("TaskService.save");
        System.out.println("taskDto = " + taskDto);
        boolean result = taskMapper.save(taskDto);
        return result;
    }

    public List<TaskDto> findAll() {
        System.out.println("TaskService.findAll");
        List<TaskDto> result = taskMapper.findAll();
        return result;
    }

}
