package Seminar5.view.commands;

import Seminar5.view.ConsoleUi;

public class AddStudent extends Command{

    public AddStudent(ConsoleUi consoleUi){
        super(consoleUi);
        description = "Создать студента";
    }

    @Override
    public void execute() {
        consoleUi.addStudent();
    }
}
