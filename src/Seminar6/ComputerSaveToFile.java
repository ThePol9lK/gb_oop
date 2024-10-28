package Seminar6;

public class ComputerSaveToFile implements Save {

    @Override
    public void load(){
        System.out.println("Данные считаны из файла");
    }

    @Override
    public void save() {
        System.out.println("Данные записаны в файл");
    }
}
