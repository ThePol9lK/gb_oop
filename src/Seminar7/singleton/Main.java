package Seminar7.singleton;

public class Main {
    public static void main(String[] args) {
//        Первое создание
        Singleton singleton = Singleton.getInstance();
        singleton.doSomething();

//        Второе создание
//        Singleton singleton_1 = new Singleton();
//        singleton_1.doSomething();

    }


}
