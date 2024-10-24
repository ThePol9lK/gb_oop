package Seminar5.view;

import Seminar5.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUi implements View {
    private final Scanner scanner;
    private final Presenter presenter;
    private boolean exit;
    private final Menu menu;

    public ConsoleUi() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        exit = true;
        menu = new Menu(this);
    }

    @Override
    public void start() {
        while (exit) {
            hello("Добрый день! Выберите одно из действий:");
            printMenu();
            execute();
        }
    }

    private static void hello(String x) {
        System.out.println(x);
    }

    private void printMenu() {
        printAnswer(menu.menu());
    }

    private void execute() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)) {
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkCommand(int numCommand) {
        if (numCommand <= menu.getSize()) {
            return true;
        } else {

            return false;
        }
    }

    private boolean checkTextForInt(String text) {
        return text.matches("[0-9]+");
    }


    public void showError(String x) {
        System.out.println(x);
    }

    public void finish() {
        exit = false;
        System.out.println("Всего доброго!");
    }

    public void SortByAge() {
        presenter.sortByAge();
    }

    public void getSortByName() {
        presenter.sortByName();
    }

    public void printStudentGroup() {
        presenter.printStudentInfo();
    }

    public void addStudent() {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();

        hello("Введите возраст:");
        int age = scanner.nextInt();
        scanner.nextLine();

        presenter.addStudent(name, age);
    }

    @Override
    public void printAnswer(String answer) {
        hello(answer);
    }
}
