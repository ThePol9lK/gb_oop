package Seminar5.presenter;

import Seminar3.service.Service;
import Seminar5.view.ConsoleUi;
import Seminar5.view.View;

public class Presenter {
    private final View view;
    private final Service service;

    public Presenter(View consoleView) {
        service = new Service();
        view = consoleView;
    }

    public void addStudent(String name, int age) {
        service.addStudent(name, age);
        view.printAnswer("Студент добавлен с список!");
    }

    public void printStudentInfo() {
        String studentsInfo = service.studentGroupInfo();
        view.printAnswer(studentsInfo);
    }

    public void sortByName() {
        service.sortByName();
        printStudentInfo();
    }


    public void sortByAge() {
        service.sortByAge();
        printStudentInfo();
    }
}
