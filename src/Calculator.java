import java.util.Locale;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        while (true) {
            double result = readNum(scanner, "Введите первое число: ");

            while (true) {
                System.out.print("Введите операцию: ");

                char oper = scanner.next().charAt(0);

                if (oper == 'C') {
                    System.out.println("Сброс!");
                    break;
                }
                if (oper == 'S') {
                    System.out.println("Завершение работы.");
                    return;
                }

                switch (oper) {
                    case '+', '-', '*', '/': {
                        double operand = readNum(scanner, "Введите второе число: ");
                        result = solve(result, operand, oper);
                        System.out.println(result);
                        break;
                    }
                    default: {
                        System.out.println("Ошибка: Не существует оператора");
                    }
                }
            }
        }
    }

    private static double solve(double cur, double operand, char oper) {
        return switch (oper) {
            case '+' -> add(cur, operand);
            case '-' -> subtract(cur, operand);
            case '*' -> multiple(cur, operand);
            case '/' -> divide(cur, operand);
            default -> 0.0;
        };
    }

    private static double readNum(Scanner scan, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!scan.hasNext()) {
                return Double.NaN;
            }

            if (scan.hasNextDouble()) {
                return scan.nextDouble();
            }

            String wrong = scan.next();
            System.out.println("Ошибка: " + wrong + " - не число, попробуйте снова.");
        }
    }

    private static double add(double a, double b) {
        return a + b;
    }

    private static double subtract(double a, double b) {
        return a - b;
    }

    private static double multiple(double a, double b) {
        return a * b;
    }

    private static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Ошибка, деление на ноль недопустимо");
            return a;
        }
        return a / b;
    }
}

