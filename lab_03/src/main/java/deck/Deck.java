package deck;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import card.base.Card;


public class Deck {
	private String name;
    private int deckSize;
    private Card[] deckList;

	public Deck(String name, Card[] deckList) {
        this.setName(name);
        this.setDeckSize(deckList.length);
        this.setDeckList(deckList);
	}

    public int insertCard(Card card) throws InsertCardFailedException {
        int count = 0;
        for (Card c : deckList) {
            if (c.equals(card)) count++;
        }

        if (count >= 4) {
            throw new InsertCardFailedException("You can only put 4 of the same cards into the deck");
        }

        deckSize++;
        Card[] newDeckList = Arrays.copyOf(deckList, deckSize);
        newDeckList[deckSize - 1] = card;
        setDeckList(newDeckList);

        return deckSize;
    }

    public Card removeCard(int slotNumber) throws RemoveCardFailedException {
        if (this.deckList.length <= slotNumber) {
            throw new RemoveCardFailedException("Number you insert exceed deck size");
        }
        if (this.deckList[slotNumber] == null) {
            throw new RemoveCardFailedException("There is no card in that slot");
        }

        Card[] newDeckList = Arrays.copyOf(deckList, deckSize - 1);
        Card removedCard = this.deckList[slotNumber];
        int count = 0;
        for (int i = 0; i < deckSize; i++) {
            if (i != slotNumber) {
                newDeckList[count] = this.deckList[i];
                count++;
            }
        }
        setDeckSize(this.getDeckSize() - 1);
        setDeckList(newDeckList);

        return removedCard;
    }

	@Override
	public String toString() {
		return new StringBuilder()
				.append("{").append(this.getName()).append("}")
				.append("(").append(this.getDeckSize()).append(" deck size)")
				.toString();
	}

	/* GETTERS & SETTERS */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeckSize() {
        return deckSize;
    }

    public void setDeckSize(int deckSize) {
        this.deckSize = deckSize;
    }

    public Card[] getDeckList() {
        return deckList;
    }

    public void setDeckList(Card[] deckList) {
        this.deckList = deckList;
    }
}
