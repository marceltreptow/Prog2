package gui.set10;

import java.util.*;

import static gui.set10.Status.*;

public class MemoryGame  {
    private List<Card> cards = new ArrayList<>();
    private int cardsmaxsize = 12;
    private Player turn = Player.Red;
    private Scanner scanner = new Scanner(System.in);
    private Card[] choosencard = new Card[2];

    public MemoryGame(){
        mixCards();
        //start();

    }

    public void mixCards(){
        String[] pics = {"pic1.jpg","pic2.jpg","pic3.jpg","pic4.jpg","pic5.jpg","pic6.jpg"};

        Random r = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < cardsmaxsize; i++)
            list.add(i);

        //Collections.shuffle(list);
        for (int i = 0; i < cardsmaxsize/2; i++) {
            int pos1 = r.nextInt(list.size());
            Card card1 = new Card(list.get(pos1));
            card1.setPic(pics[i]);
            cards.add(card1);
            list.remove(pos1);

            int pos2 = r.nextInt(list.size());
            Card card2 = new Card(list.get(pos2));
            card2.setPic(pics[i]);
            cards.add(card2);
            list.remove(pos2);

            setCardsEqual(card1,card2);
        }

        cards.sort(Comparator.comparingInt(Card::getPos));
        cards.stream().map(Card::getEquals).map(Card::getPos).forEach(System.out::println);

    }

    public boolean chooseCard(int cardnr){
        if(twoCardsChoosen())
            choosencard = new Card[2];
        if (cards.get(cardnr).getStatus() == Unused) {
            cards.get(cardnr).setStatus(turn == Player.Red ? Red : Blue);
            if (choosencard[0] == null)
                choosencard[0] = cards.get(cardnr);
            else
                choosencard[1] = cards.get(cardnr);
            return true;
        }
        System.out.println("Schon benutzt");
        return false;

    }

    public boolean checkcards(){
        System.out.println(turn);
        if (choosencard[1] == null || choosencard == null) {
            return false;
        } else {
            if (choosencard[0].getEquals() == choosencard[1]) {
                return true;
            }else {
                turn = turn == Player.Red ? Player.Blue : Player.Red;
                choosencard[0].setStatus(Unused);
                choosencard[1].setStatus(Unused);
                return false;
            }
        }
    }

    public void setCardsEqual(Card card1, Card card2){
        card1.setEquals(card2);
        card2.setEquals(card1);

    }

    public enum Player{Red,Blue}

    public Player getTurn() {
        return turn;

    }

    public Card getCard(int i){
        return cards.get(i);

    }

    public boolean twoCardsChoosen(){
        return choosencard[0] != null && choosencard[1] != null;

    }

    public int getFirstChoosencard(){
        return choosencard[0].getPos();

    }

    public int getSecondChoosencard(){
        return choosencard[1].getPos();

    }

    public boolean checkCardResult(){
        return choosencard[0].getEquals() == choosencard[1];

    }
}



