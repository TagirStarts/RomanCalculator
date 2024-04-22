//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static final Map<String, Integer> romanNumbers = new HashMap<>();
    public static final Map<Integer, String> arabicNumbers = new HashMap<>();
    public static boolean needToConvertToRoman = false;

    public static void main(String[] args) {
        romanNumbers.put("I", 1);
        romanNumbers.put("II", 2);
        romanNumbers.put("III", 3);
        romanNumbers.put("IV", 4);
        romanNumbers.put("V", 5);
        romanNumbers.put("VI", 6);
        romanNumbers.put("VII", 7);
        romanNumbers.put("VIII", 8);
        romanNumbers.put("IX", 9);
        romanNumbers.put("X", 10);
        arabicNumbers.put(1, "I");
        arabicNumbers.put(2, "II");
        arabicNumbers.put(3, "III");
        arabicNumbers.put(4, "IV");
        arabicNumbers.put(5, "V");
        arabicNumbers.put(6, "VI");
        arabicNumbers.put(7, "VII");
        arabicNumbers.put(8, "VIII");
        arabicNumbers.put(9, "IX");
        arabicNumbers.put(10, "X");
        arabicNumbers.put(11, "XI");
        arabicNumbers.put( 12,"XII");
        arabicNumbers.put( 13,"XIII");
        arabicNumbers.put( 14,"XIV");
        arabicNumbers.put( 15,"XV");
        arabicNumbers.put(16,"XVI");
        arabicNumbers.put( 17,"XVII");
        arabicNumbers.put( 18,"XVIII");
        arabicNumbers.put( 19,"XIX");
        arabicNumbers.put( 20,"XX");
        arabicNumbers.put( 21,"XXI");
        arabicNumbers.put( 24,"XXIV");
        arabicNumbers.put( 25,"XXV");
        arabicNumbers.put( 27,"XXVII");
        arabicNumbers.put( 28,"XXVIII");
        arabicNumbers.put( 30,"XXX");
        arabicNumbers.put( 32,"XXXII");
        arabicNumbers.put( 35,"XXXV");
        arabicNumbers.put(36,"XXXVI");
        arabicNumbers.put(40,"XL");
        arabicNumbers.put(42,"XVII");
        arabicNumbers.put( 45,"XLV");
        arabicNumbers.put( 48,"XLVIII");
        arabicNumbers.put(49,"IL");
        arabicNumbers.put( 50,"L");
        arabicNumbers.put(54,"LIV");
        arabicNumbers.put(56,"LVI");
        arabicNumbers.put( 60,"LX");
        arabicNumbers.put( 63,"LXIII");
        arabicNumbers.put(64,"LXIV");
        arabicNumbers.put(70,"LXX");
        arabicNumbers.put(72,"LXXII");
        arabicNumbers.put(80,"LXXX");
        arabicNumbers.put(81,"LXXXI");
        arabicNumbers.put(90,"XC");
        arabicNumbers.put(100,"C");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String calcResult = calc(userInput);
        System.out.println(calcResult);
    }

    public static String calc(String userInput) {
        String[] expression = userInput.split(" ");
        if (expression.length != 3)
            throw new IllegalArgumentException("Неверное количество аргументов!");
        if ((arabicNumbers.containsKey(expression[0]) && !arabicNumbers.containsKey(expression[2]))
                || (!arabicNumbers.containsKey(expression[0]) && arabicNumbers.containsKey(expression[2]))
                || (!romanNumbers.containsKey(expression[0]) && romanNumbers.containsKey(expression[2]))
                || (romanNumbers.containsKey(expression[0]) && !romanNumbers.containsKey(expression[2])))
            throw new IllegalArgumentException("Аргументы должны быть одного типа!");
        int num1 = convertUserInputIntoNumber(expression[0]), num2 = convertUserInputIntoNumber(expression[2]), result;

        switch (expression[1]) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Неподдерживаемый оператор!");
        }

        return convertResult(result);
    }

    public static int convertUserInputIntoNumber(String userInput) {
        int res;
        if (romanNumbers.containsKey(userInput)) {
            res = romanNumbers.get(userInput);
            needToConvertToRoman = true;
        } else {
            res = Integer.parseInt(userInput);
        }
        if (res < 1 || res > 10)
            throw new IllegalArgumentException("Аргументы должны быть от 1 до 10!");
        return res;
    }

    public static String convertResult(Integer result) {
        if (needToConvertToRoman) {
            if (arabicNumbers.containsKey(result))
                return arabicNumbers.get(result);
            else
                throw new RuntimeException("Результатом работы с римскими числами могут быть только положительные числа!");
        } else {
            return result.toString();
        }
    }
}