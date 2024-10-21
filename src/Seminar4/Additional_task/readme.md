# Задача: Реализация универсального хранилища товаров

### Условие:
Разработайте универсальный класс Storage<T>, который может хранить объекты любого типа. Он должен поддерживать добавление, удаление и получение элементов, а также определять количество хранимых объектов. Используйте обобщения, чтобы хранилище было универсальным и могло работать с любыми типами данных.

#### Требования:

* Класс Storage<T> должен иметь следующие методы:
* void add(T item) — добавляет элемент в хранилище.
* T get(int index) — возвращает элемент по индексу.
* void remove(int index) — удаляет элемент по индексу.
* int size() — возвращает текущее количество элементов.

#### Продемонстрируйте использование класса Storage с несколькими типами данных:

* Хранение строк (String)
* Хранение чисел (Integer)
* Хранение объектов пользовательского класса (например, Product с полями name и price).





# Пример реализации:
##### Пример пользовательского класса:
```java
class Product {
private String name;
private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + "}";
    }
}
```

##### Реализация класса Storage<T>:
```java
import java.util.ArrayList;
import java.util.List;

public class Storage<T> {
    private List<T> items;

    public Storage() {
        items = new ArrayList<>();
    }

    public void add(T item) {
        items.add(item);
    }

    public T get(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        throw new IndexOutOfBoundsException("Invalid index: " + index);
    }

    public void remove(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    public int size() {
        return items.size();
    }
}
```

##### Пример использования класса Storage<T>:
```java
public class Main {
public static void main(String[] args) {
// Хранилище для строк
    Storage<String> stringStorage = new Storage<>();
    stringStorage.add("Hello");
    stringStorage.add("World");
    System.out.println("String storage: " + stringStorage.get(0));

    // Хранилище для чисел
    Storage<Integer> integerStorage = new Storage<>();
    integerStorage.add(10);
    integerStorage.add(20);
    System.out.println("Integer storage size: " + integerStorage.size());

    // Хранилище для объектов Product
    Storage<Product> productStorage = new Storage<>();
    productStorage.add(new Product("Laptop", 999.99));
    productStorage.add(new Product("Phone", 499.49));
    System.out.println("Product storage: " + productStorage.get(1));

    // Удаление элемента
    productStorage.remove(0);
    System.out.println("Product storage size after removal: " + productStorage.size());
    }
}
```
