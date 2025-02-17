package example.day01._2REST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// 해당 클래스는 Controller임을 알림(어노테이션 기능 주입)
/*
    1. 해당 클래스는 Spring컨테이너(메모리)에 bean(객체)를 등록한다. (IOC (IOController))
    2. Spring Controller는 기본적으로 HTTP 서블릿을 지원한다. 별도로 상속을 받지 않는다.
*/
@Controller
public class RestController1 {

    // [1] @RequestMapping(value = "http주소정의", method = RequestMethod.사용할 HTTP 메소드)
    // - value속성에 매핑할 HTTP 주소를 정의한다. *http://localhost:8080/(http주소정의)
    // - value = "/day01/doget" ===> http://localhost:8080/day01/doget
    // - method = RequestMethod.POST/GET/PUT/DELETE를 선택해서 사용한다.
    @RequestMapping(value = "/day01/doget", method = RequestMethod.GET)
    public void doGet() {
        System.out.println("day01 doGet executed");
    }

    @RequestMapping(value = "/day01/dopost", method = RequestMethod.POST)
    public void doPost() {
        System.out.println("day01 doPost executed");
    }

    @RequestMapping(value = "/day01/doput", method = RequestMethod.PUT)
    public void doPut() {
        System.out.println("day01 doPut executed");
    }

    @RequestMapping(value = "/day01/dodelete", method = RequestMethod.DELETE)
    public void doDelete() {
        System.out.println("day01 doDelete executed");
    }

    // @RequestMapping축소하는 기능
    @GetMapping("/day01/doget2")
    public void doGet2() {
        System.out.println("day01 doGet2 executed");
    }

    @PostMapping("/day01/dopost2")
    public void doPost2() {
        System.out.println("day01 doPost2 executed");
    }

    @PutMapping("/day01/doput2")
    public void doPut2() {
        System.out.println("day01 doPut2 executed");
    }

    @DeleteMapping("/day01/dodelete2")
    public void doDelete2() {
        System.out.println("day01 doDelete2 executed");
    }

    @RequestMapping(value = "/day01/detail", method = RequestMethod.GET)
    public void doGet3() {
        System.out.println("day01 doGet executed");
    }
    @RequestMapping(value = "/day01/detail", method = RequestMethod.POST)
    public void doPost3() {
        System.out.println("day01 doPost2 executed");
    }
    @RequestMapping(value = "/day01/detail", method = RequestMethod.PUT)
    public void doPut3() {
        System.out.println("day01 doPut2 executed");
    }
    @RequestMapping(value = "/day01/detail", method = RequestMethod.DELETE)
    public void doDelete3() {
        System.out.println("day01 doDelete2 executed");
    }

}
