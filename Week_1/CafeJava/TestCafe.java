package CafeBusinessLogic;

import java.util.ArrayList;

public class TestCafe {
    public static void main(String[] args) {
        CafeUtil appTest = new CafeUtil();
        double[] prices = {5.9, 7.39, 2.44};
        ArrayList<String> menuItems = new ArrayList<String>();
        menuItems.add("drip cofee");
        menuItems.add("cappuccino");
        menuItems.add("latte");
        menuItems.add("mocha");  
        ArrayList<String> customers = new ArrayList<String>();
        customers.add("Natalie");
        customers.add("Sam");
        customers.add("Deon");

        /* ============ App Test Cases ============= */

        System.out.println("\n----- Streak Goal Test -----");
        System.out.printf("Purchases needed by week 10: %s \n\n", appTest.getStreakGoal());
        System.out.println(appTest.getStreakGoal());
        System.out.println(appTest.getStreakGoal(13));
        System.out.println(appTest.getOrderTotal(prices));
        appTest.displayMenu(menuItems);
        appTest.addCustomer(customers);


        // System.out.println("----- Order Total Test-----");
        // double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        // System.out.printf("Order total: %s \n\n",appTest.getOrderTotal(lineItems));

        // System.out.println("----- Display Menu Test-----");

        // ArrayList<String> menu = new ArrayList<String>();
        // menu.add("drip coffee");
        // menu.add("cappuccino");
        // menu.add("latte");
        // menu.add("mocha");
        // appTest.displayMenu(menu);

        // System.out.println("\n----- Add Customer Test-----");
        // ArrayList<String> customers = new ArrayList<String>();
        // // --- Test 4 times ---
        // for (int i = 0; i < 4; i++) {
        // appTest.addCustomer(customers);
        // System.out.println("\n");
        // }
    }
}
