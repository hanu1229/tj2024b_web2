package example.day02._3과제;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/day02/task1")
public class BoardController {

    // 데이터베이스 대신 사용하는 멤버변수
    private final List<BoardDto> list = new ArrayList<>();
    // bno를 위한 멤버변수
    private int no = 1;

    /** 글쓰기 */
    @PostMapping("/board")
    public boolean write(@RequestBody() BoardDto boardDto) {
        System.out.println("BoardController.write");
        System.out.println(">> boardDto = " + boardDto);
        boardDto.setBno(no);
        no++;
        list.add(boardDto);
        return true;
    }

    /** 전체 글 조회 */
    @GetMapping("/board")
    public List<BoardDto> findAll() {
        System.out.println("BoardController.findAll");
        System.out.println("list = " + list);
        return list;
    }

    /** 개별 글 조회 */
    @GetMapping("/board/view")
    public BoardDto find(@RequestParam(name = "bno") int bno) {
        System.out.println("BoardController.find");
        System.out.println("bno = " + bno);
        for(int index = 0; index < list.size(); index++) {
            BoardDto boardDto = list.get(index);
            if(boardDto.getBno() == bno) {
                return boardDto;
            }
        }
        return null;
    }

    /** 개별 글 수정 */
    @PutMapping("/board")
    public boolean update(@RequestBody() BoardDto boardDto) {
        System.out.println("BoardController.update");
        System.out.println("boardDto = " + boardDto);
        for(int index = 0; index < list.size(); index++) {
            BoardDto dto = list.get(index);
            if(dto.getBno() == boardDto.getBno()) {
                list.set(index, boardDto);
            }
        }
        return true;
    }

    /** 개별 글 삭제 */
    @DeleteMapping("/board")
    public boolean delete(@RequestParam(name = "bno") int bno) {
        System.out.println("BoardController.delete");
        System.out.println("bno = " + bno);
        for(int index = 0; index < list.size(); index++) {
            BoardDto boardDto = list.get(index);
            if(boardDto.getBno() == bno) {
                list.remove(index);
                return true;
            }
        }
        return false;
    }

}
