import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PuzzleJava {

    PuzzleJava() {};

    public int[] getTenRolls(){
        Random num = new Random();
        int[] arr = new int[10];
        for(int i = 0; i < 10; i++){
            arr[i] = num.nextInt(19) + 1; 
        }
        return arr;
    }

    public char getRandomLetter(){
        Random num = new Random();
        int temp;
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y'};
        temp = num.nextInt(alphabet.length);
        return alphabet[temp];
    }

    public String generatePassword(){
        Random num = new Random();
        String password = "";
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y'};
        for(int i = 0; i < 8; i++){
            int temp = num.nextInt(25) + 1;
            password += alphabet[temp];
        }
        return password;
    }

    public String[] getNewPasswordSet(int size){
        PuzzleJava puzzle = new PuzzleJava();
        String[] passwords = new String[size];
        for(int i = 0; i < size; i++){
            passwords[i] = puzzle.generatePassword();
        }
        return passwords;
    }
}
