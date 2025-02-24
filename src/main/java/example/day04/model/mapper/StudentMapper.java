package example.day04.model.mapper;

import example.day04.model.dto.StudentDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentMapper {
    
    /** 학생 점수 등록 */
    @Insert("insert into students(name, kor, math) values(#{name}, #{kor}, #{math})")
    int _write(StudentDto studentDto);
    
    /** 학생 전체 조회 */
    @Select("select * from students")
    List<StudentDto> _findAll();
    
    /** 학생 개별 수정 */
    @Update("update students set name = #{name}, kor = #{kor}, math = #{math} where sno = #{sno}")
    boolean _update(StudentDto studentDto);

    /** 학생 개별 삭제 */
    @Delete("delete from students where sno = #{sno}")
    boolean _delete(int sno);

}
