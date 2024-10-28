package Seminar6;

public class ComputerSaveToBD implements Save{
    @Override
    public void load() {
        System.out.println("Сохранили данные в БД");
    }

    @Override
    public void save() {
        System.out.println("Загрузили данные из БД");
    }
}
