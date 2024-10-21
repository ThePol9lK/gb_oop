package Seminar4;


import Seminar4.service.Service;
import Seminar4.student.Student;
import Seminar4.students_group.StudentGroup;

public class Main {
    public static void main(String[] args) {

//        Student student_1 = new Student(1, "Паша", 18);
//        Student student_2 = new Student(2, "Даша", 19);
//
//        StudentGroup studentGroup = new StudentGroup();
//        studentGroup.addStudent(student_1);
//        studentGroup.addStudent(student_2);
//
//        Student student_3 = new Student(2, "Витя", 20);


        Service service = new Service();
        service.addStudent("Паша", 19);
        service.addStudent("Даша", 18);
        service.addStudent("Витя", 19);
        service.addStudent("Юля", 20);
        System.out.println(service.studentGroupInfo());

        service.sortByName();
        System.out.println(service.studentGroupInfo());

        service.sortByAge();
        System.out.println(service.studentGroupInfo());

        StudentGroup<Student> studentGroup = new StudentGroup<>();

    }
}