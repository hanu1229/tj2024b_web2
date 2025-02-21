package example.day03.mvc2_mybatis.model.mapper;

import example.day03.mvc2_mybatis.model.dto.MyDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyMapper {

    // [1] 등록 SQL을 처리하는 XML 매퍼 추상 메소드
    int save(MyDto myDto);

    // [2] 전체 조회 SQL을 처리하는 XML 매퍼 추상 메소드
    List<MyDto> findAll();

    // [3] 개별 조회 SQL을 처리하는 XML 매퍼 추상 메소드
    MyDto find(int id);

    // [4] 개별 수정 SQL을 처리하는 XML 매퍼 추상 메소드
    int update(MyDto myDto);

    // [5] 개별 삭제 SQL을 처리하는 XML 매퍼 추상 메소드
    int delete(int id);
}
