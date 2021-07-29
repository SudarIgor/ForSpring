package work;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> productList;

    @PostConstruct
    private void init(){
        productList = new ArrayList<>(Arrays.asList(
                new Product(1, "Milk", 50),
                new Product(2, "Ice cream", 38),
                new Product(3, "Cake", 38),
                new Product(4, "Banana", 38),
                new Product(5, "apple", 38)
        ));
    }

    public List<Product> findAll(){
        return productList;
    }

    public Product findById(long id){
//        почему-то equals(id) выделилось ка ошибка и не прогрузилось idea
        return productList.stream().filter(i -> i.getId()==id).findFirst().get();
    }
}
