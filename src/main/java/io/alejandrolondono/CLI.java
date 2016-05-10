package io.alejandrolondono;

import java.util.Scanner;

/**
 * Created by alejandrolondono on 5/7/16.
 */
public class CLI {
    public static ATM atm = new ATM();



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nWelcome to your local ZipCode Wilmington ATM \n PRESS ENTER to continue");
        scanner.nextLine();
        System.out.println("Let's add a new user and account");
        System.out.println("PRESS ENTER to continue");
        scanner.nextLine();
        System.out.println("enter userID and Pin to continue");
//        scanner.nextLine();
        System.out.printf("Last name:   ");
        String last = scanner.next().toString();
        System.out.printf("First :  ");
        String first = scanner.next().toString();
        System.out.printf("please select a 4 digit pin: ");
        int pin = Integer.parseInt(scanner.next().toString());
        System.out.printf("would you like to open a SAVINGS account? [y/n]  ");
        String savingsPref = scanner.next().toString();
        System.out.printf("would you like to open a CHECKING account? [y/n]  ");
        String checkingPref = scanner.next().toString();
        String overdraftPref="";
        if(checkingPref.equalsIgnoreCase("y")){
            System.out.printf("would you like to enable OVERDRAFT on checking? [y/n]  ");
            overdraftPref = scanner.next();
        }
        System.out.printf("would you like to open a INVESTMENT account? [y/n]  ");
        String InvestmentPref = scanner.next().toString();

        Savings savings = null;
        Checking checking = null;
        Investment investment = null;
        if(savingsPref.equalsIgnoreCase("y")){
            System.out.println("ok! and how much would you like to deposit in SAVINGS");
            double amountS = scanner.nextInt();
            savings = new Savings(0.7, amountS);
        }
        if(checkingPref.equalsIgnoreCase("y")){
            System.out.println("ok! and how much would you like to deposit in CHECKING");
            double amountC = scanner.nextInt();
            if(overdraftPref.equalsIgnoreCase("y")){
                checking = new Checking(savings, amountC);
            }
        }

        if(InvestmentPref.equalsIgnoreCase("y")){
            System.out.println("ok! and how much would you like to deposit in INVESTENT");
            double amountI = scanner.nextInt();
            investment = new Investment(amountI);
        }
        System.out.println("OK! Lets get you set up!");
        User newUser=null;
        try {
            Thread.sleep(1000);
            System.out.println("Loading...");
            Thread.sleep(2000);
            System.out.println("registering User");

            Thread.sleep(2000);
            System.out.println("this may take a few minutes");
            Thread.sleep(800);
            System.out.println("we appreciate your patience");
            Thread.sleep(5000);
            System.out.println("adding accounts to user account "+first+" "+last);



            Thread.sleep(2000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        newUser = new User(first, last, pin);
        atm.addUser(newUser);
        if(savings != null) newUser.addAccount((Account)savings);
        if(checking != null) newUser.addAccount((Account)checking);
        if(investment != null) newUser.addAccount((Account)investment);
        System.out.println("\n\nokay! your account is all set \n\n your userID is: "+newUser.getUserID()+"\n And your user pin is: "+newUser.getPin());
        boolean exit = false;
        do{
            System.out.println("\n ============================== \n LOGIN\n ==============================");
            System.out.printf("userid: ");
            String loginID = scanner.next().toString().toLowerCase();
            System.out.println(loginID);
            System.out.printf("pin: ");
            int thePin = Integer.parseInt(scanner.next().toString());
            String output = atm.login(loginID.toLowerCase(), thePin);
            System.out.println(output);
            exit = !exit;
        }while(!exit);

    }
}
