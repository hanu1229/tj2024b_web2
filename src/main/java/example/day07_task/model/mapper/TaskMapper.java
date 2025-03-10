package example.day07_task.model.mapper;

import example.day07_task.model.dto.TaskDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TaskMapper {

    @Insert("insert into task(name, phone) values (#{name}, #{phone})")
    boolean save(TaskDto taskDto);

    @Select("select * from task")
    List<TaskDto> findAll();

}
