package enums;

import static junit.framework.TestCase.assertTrue;

public class EnumsDemo {

    public static void main(String[] args) {

        // System.out.println(PizzaStatus.ORDERED.name());


        Pizza pizza = new Pizza();

        pizza.setPizzaStatus(Pizza.PizzaStatus.READY);

        assertTrue(pizza.isDeliverable());
    }
}
