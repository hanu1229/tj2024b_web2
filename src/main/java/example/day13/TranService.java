package example.day13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class TranService {

    private final TranMapper tranMapper;
    @Autowired
    public TranService(TranMapper tranMapper) { this.tranMapper = tranMapper; }

    // ↓ 해당 메소드에 트랜잭션을 적용한다는 뜻을 가진 어노테이션, 기본 발동 조건 : 'RuntimeException' 예외
    @Transactional
    public boolean tran() {
        // 해당 메소드에서 치리하는 모든 SQL은 'RuntimeException'이 발생되면 rollback(롤백)되서 모든 SQL이 취소됨
        // 1st insert
        tranMapper.tran("유재석");

        // 학습용으로 여기에 고의적으로 문제(예외)를 발생시켜서 아래 insert 못하게 함
        if(true) {
            throw new RuntimeException("강제로 실행예외 발생시킴");
        }
        // 예외가 발생하면 아래 코드가 실행되지 않는다.

        // 2nd insert
        tranMapper.tran("강호동");

        return true;
    }

    // ↓ 모든 예외 클래스에 대한 롤백이 적용
    @Transactional(rollbackFor = Exception.class)
    public boolean transfer(Map<String, String> params) throws Exception {
        System.out.println("TranService.treansfer");
        System.out.println("params = " + params);
        String fromName = params.get("fromName");
        int money = Integer.parseInt(params.get("money"));
        
        // 유효성 검사 : 보내는 사람/ 받는 사람 존재 여부, 이체할 금액 확인
        // 유효성 검사 실패 시 false가 아닌 강제 예외발생 시킴
        
        /// 보내는 사람의 금액을 차감(출금)
        boolean result1 = tranMapper.withdraw(fromName, money);

        // if(true) { throw new RuntimeException("강제 이체오류"); }

        /// 받는 사람의 금액을 추가(입금)
        String toName = params.get("toName");
        boolean result2 = tranMapper.deposit(toName, money);
        return true;
    }

    // 매일9시(스케줄링)에 모든 회원들에게 100원씩 입금, +트랜잭션, +스트림, +메소드레퍼런스
    // 1. 매일9시 스케줄링, @Scheduled(cron = "초 분 시 일 월 요일"), AppStart에서 @EnableScheduling
    @Scheduled(cron = "0 */1 * * * *")
    // 2. 해당하는 메소드에서 예외가 발생하면 모든 SQL은 취소/롤백
    @Transactional(rollbackFor = Exception.class)
    public void Task() throws Exception {
        // 모든 회원 목록 조회
        // 모든 회원들에게 100원씩 입금
        tranMapper.findAll().stream().forEach(this::eventDeposit); // ← 스트림의 각 데이터(이름)으로 입금 처리
        // tranMapper.deposit2("임시", 100);
        System.out.println(">> 모든 회원들에게 이벤트 100원 입금 처리 완료");

    }

    public void eventDeposit(String name) {
        tranMapper.deposit(name, 100);
    }

}
