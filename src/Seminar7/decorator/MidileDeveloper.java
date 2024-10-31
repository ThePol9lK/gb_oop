package Seminar7.decorator;

public class MidileDeveloper extends DeveloperDecorator{
    public MidileDeveloper(Developer developer) {
        super(developer);
    }

    public void makeJob(){
        codeRewiew();
        super.makeJob();
    }

    void codeRewiew(){
        System.out.println("Делаю код ревью");
    }
}
