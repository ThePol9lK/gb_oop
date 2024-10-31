package Seminar7.decorator;

import Seminar7.singleton.Singleton;

public class Main {
    public static void main(String[] args) {
    Developer developer1 = new JuniorDeveloper();
    developer1.makeJob();
    Developer developer2 = new MidileDeveloper(developer1);

    developer2.makeJob();
    }


}
