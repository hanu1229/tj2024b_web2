package example.day04task.controller;

import example.day04task.model.dto.BoardDto;
import example.day04task.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardController {
    
    @Autowired
    private BoardService boardService;
    
    /** 글쓰기 */
    @PostMapping("/day04/task/board")
    public boolean _write(@RequestBody() BoardDto boardDto) {
        System.out.println("BoardController._write");
        System.out.println("boardDto = " + boardDto);
        boolean result = boardService._write(boardDto);
        System.out.println("BoardController._write");
        return result;
    }

    /** 전체 글 조회 */
    @GetMapping("day04/task/board")
    public List<BoardDto> _findAll() {
        System.out.println("BoardController._findAll");
        List<BoardDto> result = boardService._findAll();
        System.out.println("BoardController._findAll");
        return result;
    }

    /** 개별 글 조회 */
    @GetMapping("/day04/task/board/view")
    public BoardDto _find(@RequestParam(name="bno") int bno) {
        System.out.println("BoardController._find");
        System.out.println("bno = " + bno);
        BoardDto result = boardService._find(bno);
        System.out.println("BoardController._find");
        return result;
    }

    /** 개별 글 수정 */
    @PutMapping("/day04/task/board")
    public boolean _update(@RequestBody() BoardDto boardDto) {
        System.out.println("BoardController._update");
        System.out.println("boardDto = " + boardDto);
        boolean result = boardService._update(boardDto);
        System.out.println("BoardController._update");
        return result;
    }
    
    /** 개별 글 삭제 */
    @DeleteMapping("/day04/task/board")
    public boolean _delete(@RequestParam(name="bno") int bno) {
        System.out.println("BoardController._delete");
        System.out.println("bno = " + bno);
        boolean result = boardService._delete(bno);
        System.out.println("BoardController._delete");
        return result;
    }
    
}
