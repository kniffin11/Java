package CafeBusinessLogic;

import java.util.ArrayList;
import java.util.Arrays;

public class CafeUtil {

    public CafeUtil(){}
    
    public int getStreakGoal(){
        int sum = 0;
        for(int i = 0; i <= 10; i++){
            sum += i;
        }
        return sum;
    }

    public int getStreakGoal(int numWeeks){
        int sum = 0;
        for(int i = 0; i < numWeeks; i++){
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices){
        double total = 0.0;
        for(double price : prices){
            total += price;
        }
        return (Math.round(total * 100.0)/100.0);
    }

    public void displayMenu(ArrayList<String> menuItems){
        for(String item : menuItems){
            System.out.println(item);
        }
    }

    public void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name: ");
        String userName = System.console().readLine();
        System.out.printf("There are %s people in front of you \n", customers.size());
        customers.add(userName);
        for(String customer : customers){
            System.out.println(customer);
        }
    }
}
