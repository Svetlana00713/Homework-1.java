import java.io.*;

public class task_2 {
    public static void main(String[] args) {
        String firstFile = "firstpolynomial.txt";
        String secondFile = "secondpolynomial.txt";
        String resultFile = "resultpolynomial.txt";

        try {
            BufferedReader reader1 = new BufferedReader(new FileReader(firstFile));
            BufferedReader reader2 = new BufferedReader(new FileReader(secondFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile));

            String line1 = reader1.readLine();
            String line2 = reader2.readLine();

            while (line1 != null || line2 != null) {
                int[] coefficients1 = new int[101];
                int[] coefficients2 = new int[101];

                if (line1 != null) {
                    String[] parts = line1.trim().split("\\s+");
                    for (int i = 0; i < parts.length; i += 2) {
                        int exponent = Integer.parseInt(parts[i]);
                        int coefficient = Integer.parseInt(parts[i+1]);
                        coefficients1[exponent] = coefficient;
                    }
                }

                if (line2 != null) {
                    String[] parts = line2.trim().split("\\s+");
                    for (int i = 0; i < parts.length; i += 2) {
                        int exponent = Integer.parseInt(parts[i]);
                        int coefficient = Integer.parseInt(parts[i+1]);
                        coefficients2[exponent] = coefficient;
                    }
                }

                int[] resultCoefficients = new int[101];
                for (int i = 0; i < resultCoefficients.length; i++) {
                    resultCoefficients[i] = coefficients1[i] + coefficients2[i];
                }

                StringBuilder builder = new StringBuilder();
                for (int i = resultCoefficients.length - 1; i >= 0; i--) {
                    if (resultCoefficients[i] != 0) {
                        builder.append(i).append(" ").append(resultCoefficients[i]).append(" ");
                    }
                }
                if (builder.length() > 0) {
                    builder.deleteCharAt(builder.length() - 1);
                }

                writer.write(builder.toString());
                writer.newLine();

                line1 = reader1.readLine();
                line2 = reader2.readLine();
            }

            reader1.close();
            reader2.close();
            writer.close();

            System.out.println("Result written to " + resultFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    
    

