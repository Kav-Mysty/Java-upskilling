// 31. Text Blocks (Java 15+)
public class TextBlocksExample {
    public static void main(String[] args) {
        String json = """
                      {
                          "name": "Kaviya",
                          "age": 20,
                          "city": "Chennai"
                      }
                      """;
        System.out.println(json);
    }
}

// 32. Sealed Classes (Java 17+)
sealed interface Vehicle permits Car, Bike {}

final class Car implements Vehicle {
    public void drive() {
        System.out.println("Driving a car");
    }
}

final class Bike implements Vehicle {
    public void ride() {
        System.out.println("Riding a bike");
    }
}

public class SealedClassDemo {
    public static void main(String[] args) {
        Vehicle v1 = new Car();
        Vehicle v2 = new Bike();

        if (v1 instanceof Car car) {
            car.drive();
        }
        if (v2 instanceof Bike bike) {
            bike.ride();
        }
    }
}

// 33. Switch Expressions (Java 14+)
public class SwitchExpressionExample {
    public static void main(String[] args) {
        String day = "Monday";
        int numLetters = switch(day) {
            case "Monday", "Friday", "Sunday" -> 6;
            case "Tuesday" -> 7;
            case "Wednesday" -> 9;
            case "Thursday" -> 8;
            case "Saturday" -> 8;
            default -> throw new IllegalStateException("Invalid day: " + day);
        };
        System.out.println(day + " has " + numLetters + " letters.");
    }
}

// 34. Records with Compact Constructors
record Employee(String name, int id) {
    public Employee {
        if (id <= 0) {
            throw new IllegalArgumentException("Id must be positive");
        }
    }
}

public class RecordCompactConstructor {
    public static void main(String[] args) {
        Employee emp = new Employee("Kaviya", 101);
        System.out.println(emp);
        // Employee emp2 = new Employee("Raj", -5); // This will throw IllegalArgumentException
    }
}

// 35. instanceof Pattern Matching (Java 16+)
public class InstanceofPattern {
    public static void printLength(Object obj) {
        if (obj instanceof String s) {
            System.out.println("Length: " + s.length());
        } else {
            System.out.println("Not a string");
        }
    }

    public static void main(String[] args) {
        printLength("Kaviya");
        printLength(123);
    }
}
