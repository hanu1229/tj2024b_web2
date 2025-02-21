package example.day03._과제.controller;

import example.day03._과제.model.dto.BoardDto;
import example.day03._과제.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;
    
    /** 글쓰기 */
    @PostMapping("/day03/task/board")
    public boolean _write(@RequestBody() BoardDto boardDto) {
        System.out.println(">> BoardController.write");
        System.out.println(">> boardDto = " + boardDto);
        boolean result = boardService._write(boardDto);
        return result;
    }

    /** 전체 글 조회 */
    @GetMapping("/day03/task/board")
    public List<BoardDto> _findAll() {
        System.out.println(">> BoardController.findAll");
        List<BoardDto> result = boardService._findAll();
        return result;
    }

    /** 개별 글 조회 */
    @GetMapping("/day03/task/board/view")
    public BoardDto _find(@RequestParam(name = "bno") int bno) {
        System.out.println(">> BoardController.find");
        System.out.println(">> bno = " + bno);
        BoardDto result = boardService._find(bno);
        return result;
    }

    /** 개별 글 수정 */
    @PutMapping("/day03/task/board")
    public boolean _update(@RequestBody() BoardDto boardDto) {
        System.out.println(">> BoardController.update");
        System.out.println(">> boardDto = " + boardDto);
        boolean result = boardService._update(boardDto);
        return result;
    }

    /** 개별 글 삭제 */
    @DeleteMapping("/day03/task/board")
    public boolean _delete(@RequestParam(name = "bno") int bno) {
        System.out.println(">> BoardController.delete");
        System.out.println(">> bno = " + bno);
        boolean result = boardService._delete(bno);
        return result;
    }


}
