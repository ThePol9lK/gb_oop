package Seminar1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product product = new Product("Бутылка", 110.5);
        Product product_1 = new Product("Бутылка_1", 200);
        Product bottle = new Bottle("Молоко", 200, 10);



        List<Product> products = new ArrayList<Product>();

        Dispensing_machine machine = new Dispensing_machine(products);
        machine.add_product(product);
        machine.add_product(product_1);
        machine.add_product(bottle);


        machine.printList();
        machine.delete_product("Бутылка");
        machine.printList();


    }
}