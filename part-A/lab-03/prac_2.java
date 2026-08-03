import java.util.Objects;

class Card {

    private String rank;
    private String suit;

    Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String toString() {
        return rank + " of " + suit;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Card)) {
            return false;
        }

        Card c = (Card) obj;

        return rank.equals(c.rank) && suit.equals(c.suit);
    }

    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}


public class prac_2 {

    public static void main(String[] args) {

        Card[] cards = new Card[5];

        int count = 0;

        Card c1 = new Card("Ace", "Spades");
        cards[count++] = c1;

        Card c2 = new Card("King", "Hearts");
        cards[count++] = c2;

        Card c3 = new Card("Queen", "Diamonds");
        cards[count++] = c3;

        Card c4 = new Card("Ace", "Spades");

        boolean duplicate = false;

        for (int i = 0; i < count; i++) {
            if (c4.equals(cards[i])) {
                duplicate = true;
                break;
            }
        }

        if (duplicate) {
            System.out.println("Duplicate found: " + c4);
        } else {
            cards[count++] = c4;
        }
    }
}