import java.util.ArrayList;
    
public class Order{
    
    private String name; 
    private boolean ready = false; // by default
    private ArrayList<Item> items = new ArrayList<Item>(); 

    // CONSTRUCTORS
    public Order(){
        this.name = "Guest";
        items.clear();
    }
    public Order(String name){
        this.name = name;
        items.clear();
    }
    
    // ORDER METHODS
    public void addItem(String name, double price){
        Item newItem = new Item(name, price);
        items.add(newItem);
    }

    public String getStatusMessage(){
        if(ready){
            return "Your order is ready.\n";
        }
        else{
            return "Thank you for waiting. Your order will be ready soon.\n";
        }
    }

    public double getOrderTotal(){
        double total = 0.0;
        for(int i = 0; i < items.size(); i++){
            total += items.get(i).getPrice();
        }
        total = Math.round((total * 100.0)) / 100.0; // keep getting long decimals 
        return total;
    }

    public void display(){
        System.out.printf("Customer Name: %s \n", name);
        for(int i = 0; i < items.size(); i++){
            System.out.printf("%s - %s \n", items.get(i).getName(), items.get(i).getPrice());
        }
        System.out.printf("Total: %s \n", getOrderTotal());
    }

    // GETTERS & SETTERS
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isReady() {
        return ready;
    }
    public void setReady(boolean ready) {
        this.ready = ready;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public void setItems(ArrayList<Item> item) {
        for(int i = 0; i < item.size(); i++){
            items.add(item.get(i));
        }
    }
}

