// 36. HTTP Client API (Java 11+)
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientExample {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI("https://api.github.com"))
            .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status code: " + response.statusCode());
        System.out.println("Response body: " + response.body());
    }
}

// 37. Using javap to Inspect Bytecode
public class BytecodeExample {
    public void sayHello() {
        System.out.println("Hello Bytecode!");
    }
    public static void main(String[] args) {
        new BytecodeExample().sayHello();
    }
}

// 38. Decompile a Class File
public class DecompileExample {
    public int add(int a, int b) {
        return a + b;
    }
    public static void main(String[] args) {
        System.out.println(new DecompileExample().add(5, 3));
    }
}

// 39. Reflection in Java
import java.lang.reflect.Method;

public class ReflectionExample {
    public void greet(String name) {
        System.out.println("Hello, " + name);
    }
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("ReflectionExample");
        Object obj = cls.getDeclaredConstructor().newInstance();
        Method method = cls.getDeclaredMethod("greet", String.class);
        method.invoke(obj, "World");
        for (Method m : cls.getDeclaredMethods()) {
            System.out.println("Method: " + m.getName());
        }
    }
}

// 40. Virtual Threads (Java 21+)
public class VirtualThreadsExample {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread.startVirtualThread(() -> {
                System.out.println("Hello from virtual thread " + Thread.currentThread());
            });
        }
        Thread.sleep(1000);
    }
}

// 41. Executor Service and Callable
import java.util.concurrent.*;

public class ExecutorCallableExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Callable<String> task1 = () -> "Result from Task 1";
        Callable<String> task2 = () -> "Result from Task 2";
        Future<String> future1 = executor.submit(task1);
        Future<String> future2 = executor.submit(task2);
        System.out.println(future1.get());
        System.out.println(future2.get());
        executor.shutdown();
    }
}
