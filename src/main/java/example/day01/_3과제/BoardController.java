package example.day01._3과제;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/day01/task")
public class BoardController {

    private List<Map<String, String>> list = new ArrayList<>();

    /** 글쓰기 */
    @PostMapping("/board")
    public boolean writeBoard() {
        Map<String, String> result1 = new HashMap<>();
        result1.put("bno", "1");
        result1.put("btitle", "제목1");
        list.add(result1);
        Map<String, String> result2 = new HashMap<>();
        result2.put("bno", "2");
        result2.put("btitle", "제목2");
        list.add(result2);
        return true;
    }

    /** 전체 글 조회 */
    @GetMapping("/board")
    public List<Map<String, String>> findAll() {
        return list;
    }

    /** 개별 글 조회 */
    @GetMapping("/board/view")
    public Map<String, String> find() {
        Map<String, String> result = new HashMap<>();
        result.put("bno", "1");
        result.put("btitle", "내용1");
        return result;
    }

    /** 개별 글 수정 */
    @PutMapping("/board")
    public boolean update() {
        return true;
    }

    /** 개별 글 삭제 */
    @DeleteMapping("/board")
    public int delete() {
        return 3;
    }

}
