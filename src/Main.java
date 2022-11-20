import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите перво число: ");
        int firstNumber = new Scanner(System.in).nextInt();
        System.out.println("Введите второе число: ");
        int secondNumber = new Scanner(System.in).nextInt();
        System.out.println("Сумма равна: " + (firstNumber + secondNumber));
        System.out.println("Разность равна: " + (firstNumber - secondNumber));
        System.out.println("Произведение равно: " + (firstNumber * secondNumber));
        System.out.println("Частное равно: " + ((double)firstNumber / secondNumber));
    }
}