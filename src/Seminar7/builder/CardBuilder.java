package Seminar7.builder;

public abstract class CardBuilder {
    private Card card;

    public abstract void createName();
    public abstract void createPrice();
    public abstract void createSize();

    public CardBuilder(){
        card = new Card();
    }

    public Card getCard(){
        return card;
    }

    public void createCard(){
        card = new Card();
    }

    public CardBuilder setColorFront(String color){
        card.setColorFront(color);
        return this;
    }

    public CardBuilder setColorBack(String color){
        card.setColorBack(color);
        return this;
    }

    public Card build(){
        createName();
        createPrice();
        createSize();
        return card;
    }
}
