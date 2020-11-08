package enums;

public enum  PizzaDeliverySystemConfiguration {

    INSTANCE;

    PizzaDeliverySystemConfiguration() {
    }

    private PizzaDeliveryStrategy deliveryStrategy = PizzaDeliveryStrategy.NORMAL;

    public static PizzaDeliverySystemConfiguration getInstance(){
        return INSTANCE;
    }

    public PizzaDeliveryStrategy getDeliveryStrategy() {
        return deliveryStrategy;
    }
}
