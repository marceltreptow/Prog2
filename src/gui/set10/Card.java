package gui.set10;

import static gui.set10.Status.*;

public class Card {
    private Status status;
    private int pos;
    private Card equals;
    private String pic;

    public Card(int pos){
        this.pos = pos;
        setStatus(Unused);

    }

    public void setEquals(Card equals) {
        this.equals = equals;
    }

    public Card getEquals() {
        return equals;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getPos() {
        return pos;
    }

    public String getPic(){
        return pic;

    }

    public void setPic(String pic){
        this.pic = pic;

    }

}
