package example.day04task.service;

import example.day04task.model.dto.BoardDto;
import example.day04task.model.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    /** 글쓰기 */
    public boolean _write(BoardDto boardDto) {
        System.out.println("BoardService._write");
        System.out.println("boardDto = " + boardDto);
        boolean result = boardMapper._write(boardDto);
        System.out.println("BoardService._write");
        return result;
    }

    /** 전체 글 조회 */
    public List<BoardDto> _findAll() {
        System.out.println("BoardService._findAll");
        List<BoardDto> result = boardMapper._findAll();
        System.out.println("BoardService._findAll");
        return result;
    }

    /** 개별 글 조회 */
    public BoardDto _find(int bno) {
        System.out.println("BoardService._find");
        System.out.println("bno = " + bno);
        BoardDto result = boardMapper._find(bno);
        System.out.println("BoardService._find");
        return result;
    }

    /** 개별 글 수정 */
    public boolean _update(BoardDto boardDto) {
        System.out.println("BoardService._update");
        System.out.println("boardDto = " + boardDto);
        boolean result = boardMapper._update(boardDto);
        System.out.println("BoardService._update");
        return result;
    }

    /** 개별 글 삭제 */
    public boolean _delete(int bno) {
        System.out.println("BoardService._delete");
        System.out.println("bno = " + bno);
        boolean result = boardMapper._delete(bno);
        System.out.println("BoardService._delete");
        return result;
    }

}
