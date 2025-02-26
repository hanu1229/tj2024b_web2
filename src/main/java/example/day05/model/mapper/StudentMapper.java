package example.day05.model.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    
    // 인터페이스 : 공통된 메소드를 추상화해서 각 사용할 클래스에서 구체화(재정의)한다.
    // 추상메소드 : 메소드의 {} 구현부를 빼고 선언부만 작성하는 메소드
    /** [1] 등록 */
    @Insert("insert into student(name, kor, math) values(#{name}, #{kor}, #{math})")
    @Options(useGeneratedKeys = true, keyProperty = "sno")
    int save(HashMap<String, Object> map);

    /** [2] 전체조회 */
    // @Select("select * from student") : native 쿼리 : 순수한 SQL문 작성
    // @Select("<script></script>") : 동적 쿼리를 제공 : 순수한 SQL문이 아닌 mybatis가 추가적으로 제공하는 쿼리
    @Select("<script> select * from student </script>")
    List<Map<String, Object>> findAll();

    // [*] 특정한 점수 이상의 학생 조회 (동적 쿼리로 표현 : <script></script>, <if></if>, <foreach></foreach>)
    // @Select("select * from student where kor >= 80 and math >= 80") --> native 쿼리
    @Select(
            """
            <script>
                select * from student
                where 1 = 1
                <if test = 'minKor != null'>
                    and kor >= #{minKor}
                </if>
                <if test = 'minMath' != null'>
                    and math >= #{minMath}
                </if>
            </script>
            """
            // java15부터 가능 --> """ """ 템플릿을 지원 : 문자열을 입력할때 다음줄로 이어지는 방법
            // SQL에서 1=1은 true를 뜻함(강제로 true가 필요할때 쓰는 방법) : 주로 다음 조건을 동적으로 처리할때 사용
            // minKor null일때 실제 sql 표현 : select * from student where 1=1
            // minKor 80일때 실제 sql 표현 : select * from student where 1=1 and minKor >= 80
            // minKor 80이고 minMath 90일때  실제 sql 표현 : select * from student where 1=1 and minKor >= 80 and minMath >= 90
            // minKor null이고 minMath 70일때 실제 sql 표현 : select * from student where 1=1 and minMath >= 70
    )
    List<Map<String, Object>> findStudentScore(int minKor, int minMath);

    /** [3] 수정 */
    @Update("update student set kor = #{kor}, math = #{math} where sno = #{sno}")
    int update(Map<String, Object> map);

    /** [4] 삭제 */
    @Delete("delete from student where sno = #{sno}")
    boolean delete(int sno);
    
}
