import java.util.Scanner;


public class Calculator {

    // * @param args
    public static void main(String[] args) {

        int option = 0;

        // Scanner allows us to capture user's input
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("\n");
            System.out.println("******** Shitty Calculator v0.0.1 ********");
            System.out.println("proudly developed by Shark Developers");
            System.out.println("@AlexMolotov & @GeorgeOfTheJungle");
            System.out.println("1. Sum");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Rest");
            System.out.println("0. Exit");

            //We transform user's input to a Integer with "parseInt", because user input is a String
            // We store that value in option
            option = Integer.parseInt(sc.nextLine());

            //We check that option is between 1 and 5
            if(option < 0 || option > 5){
                System.out.println("Please enter a valid option");
            }
            else if(option != 0){
                System.out.println("\n"); //Line break: "salto de linea"

                float operand1, operand2;  //Initialize 2 variables; float data-type

                System.out.print("Enter first operand: ");
                operand1 = Float.parseFloat(sc.nextLine()); // We get user's input and parse it to a Float datatype
                System.out.print("Enter second operand: ");
                operand2 = Float.parseFloat(sc.nextLine()); // We get user's input and parse it to a Float datatype
                //Note that Float datatypen accepts both floating numbers (1,234) and integers (1050)
                //So we cover all cases here

                System.out.println("\n");

                switch (option){
                    case 1: //Sum
                        System.out.println("Sum result is " + (operand1 + operand2));
                        break;
                    case 2: //Subctract
                        System.out.println("Subctract is " + (operand1 - operand2));
                        break;
                    case 3: //Multiply
                        System.out.println("Multiply result is " + (operand1 * operand2));
                        break;
                    case 4: //Divide
                        System.out.println("Divide result is " + (operand1 / operand2));
                        break;
                    case 5: //Rest
                        System.out.println("Rest of " +operand1 + " and  " + operand2 + " is "+ (operand1 % operand2));
                        break;
                }


            }

        }while(option != 0);

        // If option equals 0, we break execurtion

        //Finish the scanner and stop listening to user input
        sc.close();
        System.out.println("Shitty Calculator v0.0.1 by Shark Developers");

    }

}