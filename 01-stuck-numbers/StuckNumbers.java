import java.util.Scanner;

public class StuckNumbers {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String[] numbers = new String[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scan.next();
        }

        boolean hasSolution = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                String pair = numbers[i] + numbers[j];

                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) {
                        continue;
                    }

                    for (int l = 0; l < n; l++) {
                        if (l == i || l == j || l == k) {
                            continue;
                        }

                        String newPair = numbers[k] + numbers[l];
                        if (pair.equals(newPair)) {
                            System.out.printf(
                                "%s|%s==%s|%s\n",
                                numbers[i],
                                numbers[j],
                                numbers[k],
                                numbers[l]
                            );
                            hasSolution = true;
                        }
                    }
                }
            }
        }

        if (!hasSolution) {
            System.out.println("No");
        }
    }
}