package example.day03._과제.model.mapper;

import example.day03._과제.model.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    /** 글쓰기 */
    public boolean _write(BoardDto boardDto);

    /** 전체 글 조회 */
    public List<BoardDto> _findAll();

    /** 개별 글 조회 */
    public BoardDto _find(int bno);

    /** 개별 글 수정 */
    public boolean _update(BoardDto boardDto);

    /** 개별 글 삭제 */
    public boolean _delete(int bno);

}
