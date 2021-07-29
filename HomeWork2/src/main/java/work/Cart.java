package work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

import java.util.List;


@Component
@Scope (value = "prototype")
public class Cart {

    private ProductRepository productRepository;
    private List<Product> productCast;

    @PostConstruct
    private void createCast(){
    productCast = new ArrayList<>();
    }

    public void addProduct(long id){
        productCast.add( productRepository.findById(id));
        System.out.println((productRepository.findById(id).getTitle() + " added to the cart"));
    }

    public void remove(long id){
        if (productCast.size()>1){
            productCast.remove(productRepository.findById(id));
            System.out.println("Product " + productRepository.findById(id).getTitle()+ " removed");
        }   else System.out.println("the cart is empty");
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "productCast=" + productCast +
                '}';
    }
}
