package example.day03.mvc2_3tire.controller;

import example.day03.mvc2_3tire.service.MvcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

// MVC패턴의 Controller임을 알리는 어노테이션
// * 스프링 컨테이너(메모리)에 등록함으로써 스프링이 (자동/알아서) 컨트롤러를 제어한다. [IOC]
@RestController
public class MvcController {

    // [1] 필드에 빈 주입
    // 필드에 스프링 컨테이너(메모리)에 등록된 빈(객체/인스턴스 생성)를 주입하는 어노테이션
    // @Autowired를 사용하는 이유 : 직접 인스턴스를 생성하지않고 스프링에게 시키기 위해서
    @Autowired
    MvcService mvcService;


}
