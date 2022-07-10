public class first_java_program{
    public static void main (String[] args){

        info("Sam Kniffin", 18, "Scipio Center, NY");
    }

    public static void info(String name, int age, String hometown){
        System.out.println("My name is " + name);
        System.out.println("I am " + age + " years old");
        System.out.println("My hometown is " + hometown);
    }
}