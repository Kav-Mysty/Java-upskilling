// 26. Thread Creation
import java.lang.Thread;

class MyThread extends Thread {
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println(getName() + " is running: " + i);
        }
    }
}

public class ThreadCreation {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();
    }
}

// 27. Lambda Expressions
import java.util.*;

public class LambdaExpressions {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Raj", "Anita", "John", "Zara", "Mike");
        Collections.sort(names, (a, b) -> a.compareToIgnoreCase(b));
        System.out.println(names);
    }
}

// 28. Stream API
import java.util.*;
import java.util.stream.*;

public class StreamAPI {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30, 35);
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(n -> n % 2 == 0)
                                           .collect(Collectors.toList());
        System.out.println(evenNumbers);
    }
}

// 29. Records
import java.util.*;
import java.util.stream.*;

record Person(String name, int age) {}

public class RecordsExample {
    public static void main(String[] args) {
        Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Bob", 17);
        System.out.println(p1);
        System.out.println(p2);

        List<Person> people = List.of(p1, p2);
        List<Person> adults = people.stream()
                                    .filter(p -> p.age() >= 18)
                                    .toList();
        System.out.println(adults);
    }
}

// 30. Pattern Matching for switch (Java 21)
public class PatternMatchingSwitch {
    public static void checkType(Object obj) {
        switch (obj) {
            case Integer i -> System.out.println("Integer: " + i);
            case String s -> System.out.println("String: " + s);
            case Double d -> System.out.println("Double: " + d);
            default -> System.out.println("Unknown type");
        }
    }

    public static void main(String[] args) {
        checkType(123);
        checkType("Hello");
        checkType(45.67);
        checkType(true);
    }
}
