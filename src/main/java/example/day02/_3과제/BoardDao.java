package example.day02._3과제;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardDao {

    private final List<BoardDto> list = new ArrayList<>();
    // bno를 위한 멤버변수
    private int no = 1;


    /** 글쓰기 관련 */
    public boolean write(BoardDto boardDto) {
        System.out.println(">> BoardDao.write");
        System.out.println(">> list = " + list);
        if(boardDto != null) {
            boardDto.setBno(no);
            list.add(boardDto);
            no++;
            System.out.println(">> list = " + list);
            return true;
        }
        return false;
    }

    /** 게시글 전체 조회 관련 */
    public List<BoardDto> findAll() {
        System.out.println(">> BoardDao.findAll");
        System.out.println(">> list = " + list);
        return list;
    }

    /** 개별 글 조회 관련 */
    public BoardDto find(int bno) {
        System.out.println(">> BoardDao.find");
        System.out.println(">> bno = " + bno);
        for(int index = 0; index < list.size(); index++) {
            BoardDto boardDto = list.get(index);
            if(boardDto.getBno() == bno) { return boardDto; }
        }
        return null;
    }

    /** 개별 글 수정 관련 */
    public boolean update(BoardDto boardDto) {
        System.out.println(">> BoardDao.update");
        System.out.println(">> boardDto = " + boardDto);
        for(int index = 0; index < list.size(); index++) {
            BoardDto dto = list.get(index);
            if(dto.getBno() == boardDto.getBno()) {
                list.set(index, boardDto);
                return true;
            }
        }
        return false;
    }

    /** 개별 글 삭제 관련 */
    public boolean delete(int bno) {
        System.out.println(">> BoardDao.delete");
        System.out.println(">> bno = " + bno);
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

