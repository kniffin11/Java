public class OrderTest {
    public static void main(String[] args){
        Order guest1 = new Order();
        Order guest2 = new Order();
        Order Janet = new Order("Janet");
        Order Oliver = new Order("Oliver");
        Order Max = new Order("Max");

        guest1.addItem("Cappuchino", 6.70);
        guest1.addItem("Latte", 4.57);
        guest2.addItem("Bagel", 2.31);
        guest2.addItem("Coffee", 3.52);
        Janet.addItem("Drip Coffee", 3.51);
        Janet.addItem("Latte", 4.57);
        Oliver.addItem("Bagel", 2.31);
        Oliver.addItem("Juice", 5.22);
        Max.addItem("Cappuchino", 6.70);
        Max.addItem("Coffee", 3.52);

        guest1.setReady(false);
        guest2.setReady(true);
        Janet.setReady(true);
        Oliver.setReady(false);
        Max.setReady(true);
        System.out.print(guest1.getStatusMessage());
        System.out.print(guest2.getStatusMessage());
        System.out.print(Janet.getStatusMessage());
        System.out.print(Oliver.getStatusMessage());
        System.out.print(Max.getStatusMessage());

        System.out.println(Janet.getOrderTotal());

        guest1.display();
        guest2.display();
        Janet.display();
        Oliver.display();
        Max.display();
    }
}
