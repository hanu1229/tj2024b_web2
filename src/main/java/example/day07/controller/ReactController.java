package example.day07.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("day07/react")
// CORS 정책을 허용 --> 특정 url만 허용 가능하도록 함 --> 우리의 React서버를 허용("http://192.168.40.64:5173")
// @CrossOrigin("http://localhost:5173")
@CrossOrigin(origins = {"http://localhost:5173", "http://192.168.40.64:5173"})
public class ReactController {

    private List<Map<Object, String>> boards = new ArrayList<>();

    @PostMapping("")
    public boolean onPost(@RequestBody() Map<Object, String> map) {
        System.out.println("ReactController.onPost");
        System.out.println("map = " + map);
        boards.add(map);
        return true;
    }

    @GetMapping("")
    public List<Map<Object, String>> onFindAll() {
        System.out.println("ReactController.onFindAll");
        return boards;
    }

}
