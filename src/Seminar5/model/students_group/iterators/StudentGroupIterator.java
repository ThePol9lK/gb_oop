package Seminar5.model.students_group.iterators;

import Seminar5.model.students_group.StudyElement;

import java.util.Iterator;
import java.util.List;

public class StudentGroupIterator<T extends StudyElement> implements Iterator<T> {

    private int index;
    private List<T> list;

    public StudentGroupIterator(List<T> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public T next() {
        return list.get(index++);
    }
}

