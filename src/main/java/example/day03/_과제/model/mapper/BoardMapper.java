package example.day03._과제.model.mapper;

import example.day03._과제.model.dto.BoardDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {
    
    // SQL 매핑하는 방법
    // 1. .XML파일에 작성된 SQL을 매핑
    // 2. @SQL어노테이션으로 매핑

    /** 글쓰기 */
    // @Insert("insert into day03board(title, content) values(#{title}, #{content})")
    public boolean _write(BoardDto boardDto);

    /** 전체 글 조회 */
    // @Select("select * from day03board")
    public List<BoardDto> _findAll();

    /** 개별 글 조회 */
    // @Select("select * from day03board where bno = #{bno}")
    public BoardDto _find(int bno);

    /** 개별 글 수정 */
    // @Update("update day03board set title = #{title}, content = #{content} where bno = #{bno}")
    public boolean _update(BoardDto boardDto);

    /** 개별 글 삭제 */
    // @Delete("delete from day03board where bno = #{bno}")
    public boolean _delete(int bno);

}
