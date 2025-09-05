package logic;
import java.util.ArrayList;
import java.util.Objects;

public class UnitDeck {
    private ArrayList<CardCounter> cardsInDeck;
    private String deckName;

    public UnitDeck(String deckName) {
        this.cardsInDeck = new ArrayList<CardCounter>();
        setDeckName(deckName);
    }

    public ArrayList<CardCounter> getCardsInDeck() {
        return cardsInDeck;
    }

    public void setCardsInDeck(ArrayList<CardCounter> cardsInDeck) {
        this.cardsInDeck = cardsInDeck;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        if (deckName.trim().isEmpty()) {
            this.deckName = "Untitled Deck";
        }
        else {
            this.deckName = deckName;
        }
    }

    public void addCard(UnitCard newCard, int count) {
        if (newCard == null || count <= 0) {
            return;
        }

        for (CardCounter card : cardsInDeck) {
            if (card.getCard().equals(newCard)) {
                card.setCount(card.getCount() + count);
                return;
            }
        }

        cardsInDeck.add(new CardCounter(newCard, count));
    }

    public void removeCard(UnitCard toRemove, int count) {
        if (toRemove == null || count <= 0) {
            return;
        }

        for (CardCounter card : cardsInDeck) {
            if (card.getCard().equals(toRemove)) {
                int remaining = card.getCount() - count;
                if (remaining > 0) {
                    card.setCount(remaining);
                }
                else {
                    cardsInDeck.remove(card);
                }
                return;
            }
        }
    }

    public int cardCount() {
        int count = 0;
        for (CardCounter card : cardsInDeck) {
            count += card.getCount();
        }
        return count;
    }

    public boolean existsInDeck(UnitCard card) {
        for (CardCounter cardInDeck : cardsInDeck) {
            if (cardInDeck.getCard().equals(card)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UnitDeck unitDeck = (UnitDeck) o;
        return Objects.equals(cardsInDeck, unitDeck.cardsInDeck) && Objects.equals(deckName, unitDeck.deckName);
    }


}
