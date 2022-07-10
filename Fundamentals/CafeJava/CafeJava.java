public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready. ";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double cappuchinoPrice = 4.5;
        double dripCoffeePrice = 2.5;
        double lattePrice = 3.8;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

       // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = false;

       // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
        // customer1 if set 
        if(isReadyOrder1){
            System.out.println(customer1 + readyMessage + displayTotalMessage);
        }
        else{
            System.out.println(customer1 + pendingMessage);
        }
        // customer2 if set 
        if(isReadyOrder2){
            System.out.println(customer2 + readyMessage + displayTotalMessage + (lattePrice*2));
        }
        else{
            System.out.println(customer2 + pendingMessage);
        }
        // customer3 if set 
        if(isReadyOrder3){
            System.out.println(customer3 + readyMessage + displayTotalMessage + (Math.round((dripCoffeePrice - lattePrice) * 100.0) / 100.0));
        }
        else{
            System.out.println(customer3 + pendingMessage);
        }
        // customer4 if set 
        if(isReadyOrder4){
            System.out.println(customer4 + readyMessage + displayTotalMessage + cappuchinoPrice);
        }
        else{
            System.out.println(customer4 + pendingMessage);
        }

        // ** Your customer interaction print statements will go here ** //
    }
}