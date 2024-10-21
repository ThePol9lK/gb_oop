package Seminar4.Additional_task;

import java.util.ArrayList;
import java.util.List;

public class Storage<T> {

    List<T> listElements;

    public Storage() {
        listElements = new ArrayList<>();
    }

    void add(T item){
        listElements.add(item);
    }

    T get(int index){
        return listElements.get(index);
    }

    void remove(int index){
        listElements.remove(index);
    }

    int size(){
        return listElements.size();
    }
}
