package example.day04task.model.mapper;

import example.day04task.model.dto.BoardDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BoardMapper {

    /** 글쓰기 */
    @Insert("insert into board(title, content) values(#{title}, #{content})")
    boolean _write(BoardDto boardDto);
    /** 전체 글 조회 */
    @Select("select * from board")
    List<BoardDto> _findAll();
    /** 개별 글 조회 */
    @Select("select * from board where bno = #{bno}")
    BoardDto _find(int bno);
    /** 개별 글 수정 */
    @Update("update board set title = #{title}, content = #{content} where bno = #{bno}")
    boolean _update(BoardDto boardDto);
    /** 개별 글 삭제 */
    @Delete("delete from board where bno = #{bno}")
    boolean _delete(int bno);

}
