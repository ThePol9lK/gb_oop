package Seminar5.model.service;


import Seminar5.model.student.Student;
import Seminar5.model.students_group.StudentGroup;

public class Service {
    private int GenStudentId;
    StudentGroup<Student> studentGroup;

    public Service() {
        studentGroup = new StudentGroup<>();
    }

    public void addStudent(String name, int age){
        Student student = new Student(GenStudentId++, name, age);
        studentGroup.addStudent(student);
    }

    public String studentGroupInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список студентов:\n");
        for(Student student: studentGroup){
            stringBuilder.append(student);
            stringBuilder.append("\n");
        }

//        Iterator<Student> iterator= StudentGroup.iterator();
//        while (iterator.hasNext()){
//            Student new_student = iterator.next();
//            stringBuilder.append(student);
//            stringBuilder.append("\n");
//        }

        return stringBuilder.toString();
    }


    public void sortByName(){
        studentGroup.sortByName();
    }

    public void sortByAge(){
        studentGroup.sortByAge();
    }
}
