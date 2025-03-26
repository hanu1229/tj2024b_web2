package example.day12._람다식;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface Calculator {
    int plus(int x, int y);
}

public class Example1 {

    public static int plus(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {

        // ↓ 일반 메소드 호출
        int result1 = plus(3, 5);
        System.out.println("result1 = " + result1);
        
        // ↓ 추상 메소드 호출(구현이 필요) - 익명객체로 구현 중
        // (1) implements, (2) 익명객체로 구현가능
        Calculator calc = new Calculator() {
            @Override
            public int plus(int x, int y) {
                return x + y;
            }
        };
        int result2 = calc.plus(3, 5);
        System.out.println("result2 = " + result2);

        // ↓ (인터페이스) 추상 메소드를 람다 표현식으로 호출
        Calculator calc2 = (x, y) -> x + y;
        int result3 = calc2.plus(3, 5);
        System.out.println("result3 = " + result3);

        // ↓ 람다표현식을 제공하는 타입
        System.out.println("==================== ↓ 람다식을 제공하는 타입 ↓ ====================");
        // ↓ Function<매개변수타입, 리턴값타입> , .apply(인자값)
        Function<Integer, Integer> function = x -> x * 2;
        System.out.println("Function.apply(인자값) : " + function.apply(3));
        System.out.println("Function.apply(인자값) : " + function.apply(7));

        // ↓ Predicate<매개변수타입>, 실행결과 true 또는 false를 반환
        Predicate<Integer> predicate = x -> x % 2 == 0;
        System.out.println("predicate.test(인자값) : " + predicate.test(3));
        System.out.println("predicate.test(인자값) : " + predicate.test(4));

        // ↓ Supplier<리턴값타입> , .get()
        Supplier<Double> supplier = () -> Math.random();
        System.out.println("supplier.get(없음) : " + supplier.get());

        // ↓ Consumer<매개변수타입>, .accept(인자값)
        Consumer<String> consumer = str -> System.out.println(str);
        System.out.print("consummer.accept(인자값) : ");
        consumer.accept("안녕하세요");
        System.out.println("==================== ↑ 람다식을 제공하는 타입 ↑ ====================");

        // ↓ 주로 컬렉션 프레임워크와 같이 사용
        List<String> fruits = new ArrayList<>();
        fruits.add("사과"); fruits.add("바나나"); fruits.add("수박");
        // 리스트명.forEach((매개변수) -> {실행코드});
        fruits.forEach((fruit) -> { System.out.println("과일명 : " + fruit); });

    }
}

