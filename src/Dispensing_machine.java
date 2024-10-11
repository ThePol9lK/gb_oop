import java.util.ArrayList;
import java.util.Objects;

public class Dispensing_machine {

    private ArrayList<Product> products;

    public Dispensing_machine(ArrayList<Product> products) {
        this.products = products;
    }

    public void add_product(Product product){
        this.products.add(product);
    }

    public void printList(){
        for (Product itVar : products)
        {
            System.out.println(itVar);
        }

    }

    private int findIndex(String product) {
        int count = 0;

        for (Product itVar : products) {
            if (Objects.equals(itVar.getName(), product)) {
                return count;
            }
            count += 1;
        }
        return -1;
    }


    public void delete_product(String product_name){
        int count = findIndex(product_name);
        this.products.remove(count);
    }



//
//    Методы
//            Add_product()
//                delete_product()
//            sort
}
