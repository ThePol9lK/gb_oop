package Seminar4.Additional_task;

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
        productStorage.add(new Product("Laptop", 999));
        productStorage.add(new Product("Phone", 499));
        System.out.println("Product storage: " + productStorage.get(1));

        // Удаление элемента
        productStorage.remove(0);
        System.out.println("Product storage size after removal: " + productStorage.size());
    }
}