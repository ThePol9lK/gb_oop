package Seminar7.decorator;

public class JuniorDeveloper implements Developer{
    @Override
    public void makeJob() {
        writeCode();
    }

    private void writeCode(){
        System.out.println("Пишем код");
    }
}
