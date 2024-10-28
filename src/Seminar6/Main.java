package Seminar6;


public class Main {
    public static void main(String[] args) {

        Computer comp = new Computer("IBM", 5000);
        ComputerV2 comp2 = new ComputerV2("IBM 2000", 4000);
        comp2.setName("IBM");

        boolean b = comp2.memory_size - comp.memory_size == 0;
        if (b == true) {
            System.out.println("test ok");

        }
    }
}