package Seminar6;

public class Computer implements Comp{
    String name;
    public int memory_size;

    public Computer(String name, int memory_size) {
        this.name = name;
        this.memory_size = memory_size;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {

    }

    //    void save(){
//        System.out.println("Данные записаны в файл");
//        System.out.println("Данные записаны в БД");
//    }
//
//    void load(){
//        System.out.println("Данные считаны из файла");
//        System.out.println("Данные считаны из БД");
//    }
}
