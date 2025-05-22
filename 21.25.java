// 21. Find GCD of Two Numbers
import java.util.Scanner;
class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        System.out.println("GCD is " + a);
    }
}

// 22. Find LCM of Two Numbers
import java.util.Scanner;
class LCM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        int gcd = a, lcm;
        int x = a, y = b;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        gcd = a;
        lcm = (x * y) / gcd;
        System.out.println("LCM is " + lcm);
    }
}

// 23. Check Palindrome Number
import java.util.Scanner;
class PalindromeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        int original = num, rev = 0;
        while (num != 0) {
            int digit = num % 10;
            rev = rev * 10 + digit;
            num /= 10;
        }
        if (original == rev) System.out.println(original + " is a palindrome");
        else System.out.println(original + " is not a palindrome");
    }
}

// 24. Find Largest of Three Numbers
import java.util.Scanner;
class LargestOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int largest = a;
        if (b > largest) largest = b;
        if (c > largest) largest = c;
        System.out.println("Largest number is " + largest);
    }
}

// 25. Convert Celsius to Fahrenheit
import java.util.Scanner;
class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature in Celsius: ");
        double c = sc.nextDouble();
        double f = (c * 9/5) + 32;
        System.out.println(c + " Celsius = " + f + " Fahrenheit");
    }
}
