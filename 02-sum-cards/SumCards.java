import java.util.Scanner;

public class SumCards {

    private static String CARD_PATTERN = "(\\d+|\\w)\\w";
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int result = 0;
        int intermediateValue = 0;
        int currentCardValue = 0;
        int cardStreak = 1;
        String[] cards = scan.nextLine().split("\\s+");
        for (String card : cards) {
            int newCardValue = getCardValue(card);
            int finalCardValue = newCardValue;
            if (newCardValue == currentCardValue) {
                cardStreak++;
                if (cardStreak > 2) {
                    finalCardValue *= 2;
                } else {
                    finalCardValue *= 3;
                }
            } else {
                cardStreak = 1;
            }

            result += finalCardValue;
            currentCardValue = newCardValue;
        }

        System.out.println(result);
    }

    public static int getCardValue(String card)
        throws IllegalArgumentException {
        String face = extractFaceFromCard(card);
        switch (face) {
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "J":
                return 12;
            case "Q":
                return 13;
            case "K":
                return 14;
            case "A":
                return 15;
            default:
                throw new IllegalArgumentException(
                    String.format("%s is not a valid card face", face)
                );
        }
    }

    public static String extractFaceFromCard(String card) {
        return card.replaceAll(CARD_PATTERN, "$1");
    }
}