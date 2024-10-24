package Seminar5.model.students_group;

import Seminar5.model.student.comparators.CompareStudentByAge;
import Seminar5.model.student.comparators.CompareStudentByName;
import Seminar5.model.students_group.iterators.StudentGroupIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentGroup<T extends StudyElement> implements Iterable<T> {
    private List<T> list;


    public StudentGroup() {
        list = new ArrayList<>();
    }


    public void addStudent(T student){
        list.add(student);
    }


    @Override
    public Iterator<T> iterator() {
        return new StudentGroupIterator<>(list);
//        return list.listIterator()
    }

    public void sortByName(){
        list.sort(new CompareStudentByName<>());
    }

    public void sortByAge(){
        list.sort(new CompareStudentByAge<>());
    }

}
