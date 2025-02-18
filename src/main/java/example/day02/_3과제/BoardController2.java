package example.day02._3과제;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/day02/task2")
public class BoardController2 {
    @Autowired
    private final BoardDao boardDao;
    public BoardController2(BoardDao boardDao) {this.boardDao = boardDao; }


    /** 글쓰기 */
    @PostMapping("/board")
    public boolean write(@RequestBody() BoardDto boardDto) {
        System.out.println(">> BoardController2.write");
        System.out.println(">> boardDto = " + boardDto);
        boolean result = boardDao.write(boardDto);
        System.out.println(">> result = " + result);
        return result;
    }

    /** 전체 글 조회 */
    @GetMapping("/board")
    public List<BoardDto> findAll() {
        System.out.println(">> BoardController.findAll");
        List<BoardDto> result = boardDao.findAll();
        System.out.println(">> result = " + result);
        return result;
    }

    /** 개별 글 조회 */
    @GetMapping("/board/view")
    public BoardDto find(@RequestParam(name = "bno") int bno) {
        System.out.println(">> BoardController.find");
        System.out.println(">> bno = " + bno);
        BoardDto result = boardDao.find(bno);
        System.out.println(">> result = " + result);
        return result;
    }

    /** 개별 글 수정 */
    @PutMapping("/board")
    public boolean update(@RequestBody() BoardDto boardDto) {
        System.out.println(">> BoardController.update");
        System.out.println(">> boardDto = " + boardDto);
        boolean result = boardDao.update(boardDto);
        System.out.println(">> result = " + result);
        return true;
    }

    /** 개별 글 삭제 */
    @DeleteMapping("/board")
    public boolean delete(@RequestParam(name = "bno") int bno) {
        System.out.println(">> BoardController.delete");
        System.out.println(">> bno = " + bno);
        boolean result = boardDao.delete(bno);
        System.out.println(">> result = " + result);
        return result;
    }

}
