package Seminar5.view;

import Seminar5.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUi implements View {

    private Scanner scanner;
    private Presenter presenter;

    public ConsoleUi() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
    }



    @Override
    public void start() {
        while (true) {
            System.out.println("1. Создать студента");
            System.out.println("2. Получить список студентов");
            System.out.println("3. Отсортировать по имени");
            System.out.println("4. Отсортировать по возрасту");
            System.out.println("5. Выход из программы");

            String choice = scanner.nextLine();
            // System.out.println(choice); // Уберите эту строку, если не хотите выводить выбор

            switch (choice) {
                case "1":
                    addNewStudent();
                    break;
                case "2":
                    presenter.showAllStudents();
                    break;
                case "3":
                    presenter.showAllStudentsByName();
                    break;
                case "4":
                    presenter.showAllStudentsByAge();
                    break;
                case "5":
                    System.out.println("Всего доброго!");
                    return; // Выход из цикла
                default:
                    break;
            }
        }
    }

    private void addNewStudent() {
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите возраст");
        int age = scanner.nextInt();
        scanner.nextLine();  // Важно: сбрасываем оставшийся символ новой строки
        presenter.addStudent(name, age);
        System.out.println("Новый студент добавлен в список!");
    }


    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
