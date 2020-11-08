package enums;

public class Pizza {

    private PizzaStatus pizzaStatus;

    public enum PizzaStatus {
        ORDERED(5) {
            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        READY(2) {
            @Override
            public boolean isRead() {
                return true;
            }
        },
        DELIVERED(0) {
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        PizzaStatus(int i) {
            this.timeToDelivery = i;
        }

        public boolean isOrdered() {
            return false;
        }

        public boolean isRead() {
            return false;
        }

        public boolean isDelivered() {
            return false;
        }

        private int timeToDelivery;

        public int getTimeToDelivery() {
            return timeToDelivery;
        }

        public void setTimeToDelivery(int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }
    }

    public boolean isDeliverable() {

        return this.pizzaStatus.isRead();
    }

    public PizzaStatus getPizzaStatus() {
        return pizzaStatus;
    }

    public void setPizzaStatus(PizzaStatus pizzaStatus) {
        this.pizzaStatus = pizzaStatus;
    }
}
