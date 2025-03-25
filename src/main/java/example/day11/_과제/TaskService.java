package example.day11._과제;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskMapper taskMapper;

    /** 매 30초마다 모든 제품의 재고가 3개씩 감소하는 스케줄 */
    @Scheduled(cron = "*/30 * * * * *")
    public void decline() {
        System.out.println("========== ↓ 제품 감소 ↓ ==========");
        int count = taskMapper.productCount();
        System.out.println("count = " + count);
        for(int index = 1; index <= count; index++) {
            taskMapper.decline(index);
            int result = taskMapper.stockCount(index);
            System.out.println("result = " + result);
        }
        System.out.println("========== ↑ 제품 감소 ↑ ==========");
    }

    /** 매 1분마다 모든 제품의 정보를 조회하여 console에 출력 */
    @Scheduled(cron = "0 */1 * * * *")
    public void checkProducts() {
        System.out.println("========== ↓ 제품 정보 조회 ↓ ==========");
        List<Map<Object, String>> result = taskMapper.checkProducts();
        for(int index = 0; index < result.size(); index++) {
            System.out.println(result.get(index));
        }
        System.out.println("========== ↑ 제품 정보 조회 ↑ ==========");
    }

    /** 매 5분마다 재고가 10개 이하인 상품의 재고를 20개 추가 */
    @Scheduled(cron = "0 */5 * * * *")
    public void addProduct() {
        System.out.println("========== ↓ 제품 추가 ↓ ==========");
        int count = taskMapper.productCount();
        System.out.println("count = " + count);
        for(int index = 1; index <= count; index++) {
            taskMapper.addProduct(index);
            int result = taskMapper.stockCount(index);
            System.out.println("result = " + result);
        }
        System.out.println("========== ↑ 제품 추가 ↑ ==========");
    }

}
