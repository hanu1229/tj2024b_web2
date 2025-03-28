package example.day13;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TranMapper {

    @Insert("insert into day13users(name) values (#{name})")
    boolean tran(String name);

    /** 출금(빼기) */
    @Update("update day13users set money = money - #{money} where name = #{name}")
    boolean withdraw(String name, int money);

    /** 입금(더하기) */
    @Update("update day13users set money = money + #{money} where name = #{name}")
    boolean deposit(String name, int money);

    /** 모든 회원 목록 조회 */
    @Select("select name from day13users")
    List<String> findAll();

    /** 모두에게 입금 */
    @Update("update day13users set money = money + #{money}")
    boolean deposit2(String name, int money);

}
