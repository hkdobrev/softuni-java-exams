import java.util.Scanner;

import java.math.BigDecimal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleExpression {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(\\d+(?:\\.\\d+)?|\\+|\\-)");
        Matcher matcher = pattern.matcher(scan.nextLine());
        BigDecimal result = BigDecimal.ZERO;
        boolean sumNext = true;
        while (matcher.find()) {
            String literal = matcher.group();
            if (literal.equals("+")) {
                sumNext = true;
            } else if (literal.equals("-")) {
                sumNext = false;
            } else {
                BigDecimal current = new BigDecimal(literal);
                if (sumNext) {
                    result = result.add(current);
                } else {
                    result = result.subtract(current);
                }
            }
        }

        System.out.println(result.toString());
    }
}