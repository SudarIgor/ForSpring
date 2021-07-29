package work;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Cart cart1 = context.getBean("cart", Cart.class);
        Cart cart2 = context.getBean("cart", Cart.class);
        cart1.remove(5);
        cart1.addProduct(1);
        cart1.addProduct(2);
        cart1.addProduct(2);
        cart2.addProduct(1);
        System.out.println(cart1);
        cart1.remove(2);
        System.out.println(cart1);
        System.out.println(cart2);

    }

}
