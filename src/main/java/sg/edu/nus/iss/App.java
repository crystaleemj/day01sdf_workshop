package sg.edu.nus.iss;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Welcome to your shopping cart");
        
        //collection object to store objects
        List<String> cartItems = new ArrayList<String>();

        //open console for input from user
        Console con = System.console();
        String input = "";

        while(!input.equals("quit")){
            input = con.readLine("Type 'help' to show list of commands >>");

             if (input.equals("help")){
                System.out.println("'list' to show a list of items in the shopping cart");
                System.out.println("'add <item name>, ...'");
                System.out.println("delete <item number>");
                System.out.println("'quit' to terminate the program");

            }

            if (input.startsWith("add")){
                //do something here
                input = input.replace(',', ' ');
                
                Scanner scan = new Scanner(input.substring(4));

                String content = "";
                while (scan.hasNext()){
                    content = scan.next();
                    cartItems.add(content);
                }
            }

            if (input.equals("list")){
                int i = 0;
                for(String item: cartItems){
                    i++;
                    System.out.println(i + ". " + item);

                }
                
            }

            if (input.startsWith("delete")){
                Scanner scan = new Scanner(input.substring(6));

                String content = "";
                while (scan.hasNext()){
                    content = scan.next();

                    //to convert string variable to integer/number value e.g. index
                    int listIndex = Integer.parseInt(content);

                    if (listIndex < cartItems.size()){
                        cartItems.remove(listIndex);
                    } else {
                        System.err.println("Incorrect item index");
                    }

                }
            }

            

        }

        System.out.println("Bye bye, I don't want to see you again...");

       // Scanner shoppingCart = new Scanner(System.in);
        //String list = shoppingCart.nextLine();
        //System.out.println("Your cart is empty");
       


    }
}
