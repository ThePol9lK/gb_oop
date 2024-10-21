package Seminar4.student.comparators;

import Seminar4.students_group.StudyElement;

import java.util.Comparator;

public class CompareStudentByName<E extends StudyElement> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
