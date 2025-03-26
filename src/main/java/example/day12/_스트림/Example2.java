package example.day12._스트림;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example2 {
    public static void main(String[] args) {

        // 임의의 리스트
        List<Integer> numbers= List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // < > 제네릭 타입 : 클래스 또는 인터페이스 타입에 전달하는 타입(기본타입 안됨)
        // int(기본타입) VS Integer(참조타입/래퍼클래스) : 기본타입 8개를 클래스로 사용할 때
        // List(인터페이스 / 추상) VS ArrayList/Vector/LinkedList(클래스 / 구현체)

        // 컬렉션 프레임워크는 스트림을 제공
        System.out.println("==================== ↓ 컬렉션 프레임워크는 스트림을 제공 ↓ ====================");

        // ↓ .stream().forEach()
        System.out.println("========== ↓ .stream().forEach() ↓ ==========");
        numbers.stream().forEach(x -> System.out.println(x));
        System.out.println("========== ↑ .stream().forEach() ↑ ==========\n");

        // ↓ .stream().map().collect(Collectors.to컬렉션명())
        System.out.println("========== ↓ .stream().map().collect(Collectors.to컬렉션명()) ↓ ==========");
        List<Integer> result2 = numbers.stream().map(x -> x * 2).collect(Collectors.toList());
        // List<Integer> result2 = numbers.stream().map(x -> x * 2).toList();
        System.out.println("result2 = " + result2);
        System.out.println("========== ↑ .stream().map().collect(Collectors.to컬렉션명()) ↑ ==========\n");

        // ↓ .stream().map().forEach()
        System.out.println("========== ↓ .stream().map().forEach() ↓ ==========");
        numbers.stream().map(x -> x * 2).forEach(x -> System.out.println(x));
        // numbers에 데이터가 하나씩 이동하는 데이터 통로(stream)생성. 데이터 통로를 이동하면서 데이터를 중간 연산. 데이터 통로의 끝에 데이터 결과를 출력
        System.out.println("========== ↑ .stream().map().forEach() ↑ ==========\n");

        // ↓ .stream().filter().forEach()
        System.out.println("========== ↓ .stream().filter().forEach() ↓ ==========");
        numbers.stream().filter(x -> x % 2 == 0).forEach(x -> System.out.println(x));
        System.out.println("========== ↑ .stream().filter().forEach() ↑ ==========\n");

        // ↓ .stream().sorted().forEach() , sorted(Comparator.reverseOrder()) : 내림차순, sorted() : 오름차순
        System.out.println("========== ↓ .stream().sorted().forEach() ↓ ==========");
        numbers.stream().sorted().forEach(x -> System.out.println(x));
        System.out.println("========== ↑ .stream().sorted().forEach() ↑ ==========\n");

        // System.out.println(numbers.stream().sorted().collect(Collectors.toList()).toString());

        System.out.println("==================== ↑ 컬렉션 프레임워크는 스트림을 제공 ↑ ====================");

    }
}
