package Seminar7.decorator;

public abstract class DeveloperDecorator implements Developer{
    private Developer developer;

    public DeveloperDecorator(Developer developer){
        this.developer = developer;
    }

    @Override
    public void makeJob() {
        System.out.println("Я начал работу:");
        developer.makeJob();
        System.out.println("Я закончил работу");
    }
}
