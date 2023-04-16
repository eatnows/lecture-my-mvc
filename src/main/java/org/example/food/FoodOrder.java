package org.example.food;

public class FoodOrder {

    private final Customer customer;
    private final String menuName;
    private final Menu menu;

    public FoodOrder(Customer customer, String menuName, Menu menu) {
        this.customer = customer;
        this.menuName = menuName;
        this.menu = menu;
    }

    public void order() {
        Cooking cooking = new Cooking();
        MenuItem menuItem = menu.choose(menuName);
        Cook cook = cooking.makeCook(menuItem);
    }
}
