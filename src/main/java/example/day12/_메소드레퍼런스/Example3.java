package example.day12._메소드레퍼런스;

import java.util.List;
import java.util.function.Supplier;

class Person {
    String name;

    public Person() {}
    public Person(String name) { this.name = name; }

    public void onMessage1(String message) {
        System.out.println(message);
    }

    public static void onMessage2(String message) {
        System.out.println(message);
    }
}

public class Example3 {
    public static void main(String[] args) {

        // 임의의 컬렉션
        List<String> names = List.of("유재석", "강호동", "신동엽");

        System.out.println("========== ↓ static 메소드 참조 (일반적인 방법) ↓ ==========");
        // static 메소드 참조 (일반적인 방법)
        names.forEach((name) -> { Person.onMessage2(name); });
        System.out.println("========== ↑ static 메소드 참조 (일반적인 방법) ↑ ==========\n");

        System.out.println("========== ↓ static 메소드 참조 (메소드 레퍼런스 방법) ↓ ==========");
        // static 메소드 참조 (메소드 레퍼런스 방법), 클래스명::static메소드명, forEach의 매개변수와 static메소드의 매개변수가 일치
        names.forEach(Person::onMessage2);
        System.out.println("========== ↑ static 메소드 참조 (메소드 레퍼런스 방법) ↑ ==========\n");


        System.out.println("========== ↓ 생성자 참조 (일반적인 방법) ↓ ==========");
        // 생성자 참조 (일반적인 방법)
        names.forEach((name) -> { new Person(name); });
        System.out.println("========== ↑ 생성자 참조 (일반적인 방법) ↑ ==========\n");

        System.out.println("========== ↓ 생성자 참조 (메소드 레퍼런스 방법) ↓ ==========");
        // 생성자 참조 (메소드 레퍼런스 방법)
        names.forEach(Person::new);
        System.out.println("========== ↑ 생성자 참조 (메소드 레퍼런스 방법) ↑ ==========\n");

        System.out.println("========== ↓ 일반 메소드 참조 (메소드 레퍼런스 방법) ↓ ==========");
        // 일반 메소드 참조
        Person person1 = new Person();
        names.forEach(person1::onMessage1);
        System.out.println("========== ↑ 일반 메소드 참조 (메소드 레퍼런스 방법) ↑ ==========\n");

        System.out.println("========== ↓ 일반 메소드 참조 (메소드 레퍼런스 방법) ↓ ==========");
        // 주의할점 : ::메소드 레퍼언스는 람다 표현식을 간결하게 사용하기 위해 사용
        // Person person2 = Person::new;
        Supplier<Person> ref = Person::new;
        Person person = ref.get();
        Supplier<Person> ref2 = () -> new Person();
        Person person2 = ref2.get();
        System.out.println("========== ↑ 일반 메소드 참조 (메소드 레퍼런스 방법) ↑ ==========\n");

    }
}
