package org.example.food;

public class Customer {

    public void order(String menuName, Menu menu, Cooking cooking) {
        FoodOrder order = new FoodOrder(this, menuName, menu);

        order.order();
    }
}
