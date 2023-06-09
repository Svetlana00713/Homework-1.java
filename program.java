import java.util.Random;
import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        int max_val = 100;
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Введите натуральную степень k:");
            int k = input.nextInt();
// коэфф. при старшей степени не должен быть равен 0
            int[] koeff = new int[k+1];
            Random rand = new Random();
            for (int i = 0; i < k; i++) {
                koeff[i] = rand.nextInt(max_val);
                }
                koeff[k] = rand.nextInt(max_val) + 1;
                StringBuilder poly = new StringBuilder();
                for (int i = k; i >= 0; i--) {
                    if (koeff[i] != 0) {
                        if (i != k) {
                            poly.append("+");
                        }
                        if (i > 1) {
                            poly.append(koeff[i] + "x^" + i);
                        } else if (i == 1) {
                            poly.append(koeff[i] + "x");
                        } else {
                            poly.append(koeff[i] + "= 0");
                        }
                    }
                }
                String result = poly.toString();
                // Поиск и замены:
                result = result.replace("x^1+", "x+");
                result = result.replace("x^0", "");
                result += (result.charAt(result.length()-1) == '+') ? "1" : "";
                result = (result.endsWith("^1 = 0")) ? result.substring(0, result.length()-2) : result;
                System.out.println(result);
        }
        }
}

 

        