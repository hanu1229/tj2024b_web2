package example.day03.mvc2_3tire.service;

import example.day03.mvc2_3tire.model.repository.MvcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// MVC패턴의 Service임을 알리는 어노테이션
// * 스프링 컨테이너(메모리)에 등록함으로써 스프링이 (자동/알아서) 서비스를 제어한다. [IOC]
@Service
public class MvcService {

    /*
        ※ 순환 참조 주의!
        순환 참조가 걸려서 사용하면 안된다
        @Autowired
        MvcController mvcController;
     */
    // Controller --> Service --> repository 순으로 참조
    // [2] (디폴트)생성자에 빈을 주입
    final MvcRepository mvcRepository;
    @Autowired
    public MvcService(MvcRepository mvcRepository) {
        this.mvcRepository = mvcRepository;
    }

}
