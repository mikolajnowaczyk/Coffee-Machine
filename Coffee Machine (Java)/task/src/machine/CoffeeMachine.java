package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static final int waterPerCup = 200;
    private static final int milkPerCup = 50;
    private static final int coffeeBeansPerCup = 15;

    private static int waterAmount = 0;
    private static int milkAmount = 0;
    private static int coffeeBeansAmount = 0;
    private static int cupsNumber = 0;
    private static int moneyAmount = 0;
    private static int waterAmountInCups = 0;
    private static int milkAmountInCups = 0;
    private static int coffeeBeansAmountInCups = 0;



    private void displayActions(){
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }

    private void evaluateNumberOfServings(int requiredCupsNumber){
        int maxAvailableCups = Math.min(waterAmountInCups,Math.min(milkAmountInCups, coffeeBeansAmountInCups));
        if (maxAvailableCups < requiredCupsNumber){
            System.out.println("No, I can make only " + maxAvailableCups + " cup(s) of coffee");
        } else if (maxAvailableCups == requiredCupsNumber) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            System.out.println("Yes, I can make that amount of coffee (and even " + (maxAvailableCups - requiredCupsNumber) + " more than that)");
        }
    }
    private void getCoffeeMachineSupplies(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        waterAmount = scanner.nextInt();
        waterAmountInCups = waterAmount / waterPerCup;
        System.out.println("Write how many ml of milk the coffee machine has:");
        milkAmount = scanner.nextInt();
        milkAmountInCups = milkAmount / milkPerCup;
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        coffeeBeansAmount = scanner.nextInt();
        coffeeBeansAmountInCups = coffeeBeansAmount / coffeeBeansPerCup;
    }

    private void setCoffeeMachineSupplies(int water, int milk, int beans, int cups, int money){
        waterAmount = water;
        milkAmount = milk;
        coffeeBeansAmount = beans;
        cupsNumber = cups;
        moneyAmount = money;
        waterAmountInCups = waterAmount / waterPerCup;
        milkAmountInCups = milkAmount / milkPerCup;
        coffeeBeansAmountInCups = coffeeBeansAmount / coffeeBeansPerCup;
    }
    private void displayCoffeeMachineSupplies(){
        System.out.println("The coffee machine has:");
        System.out.println(waterAmount + " ml of water");
        System.out.println(milkAmount + " ml of milk");
        System.out.println(coffeeBeansAmount + " g of coffee beans");
        System.out.println(cupsNumber + " disposable cups");
        System.out.println("$" + moneyAmount + " of money");
    }

    private void takeMoney(){
        System.out.println("I gave you $" + moneyAmount);
        moneyAmount = 0;
    }
    private void fillSupplies(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add: ");
        waterAmount += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milkAmount += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeansAmount += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        cupsNumber += scanner.nextInt();
    }

    private void buyCoffee(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int option = scanner.nextInt();
        switch (option){
            case 1:
                waterAmount -= 250;
                coffeeBeansAmount -= 16;
                moneyAmount += 4;
                break;
            case 2:
                waterAmount -= 350;
                milkAmount -= 75;
                coffeeBeansAmount -= 20;
                moneyAmount += 7;
                break;
            case 3:
                waterAmount -= 200;
                milkAmount -= 100;
                coffeeBeansAmount -= 12;
                moneyAmount += 6;
                break;
        }
        cupsNumber--;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine CM = new CoffeeMachine();
        CM.setCoffeeMachineSupplies(400, 540, 120, 9, 550);
        CM.displayCoffeeMachineSupplies();
        System.out.println("Write action (buy, fill, take):");
        String option = scanner.nextLine();
        switch (option){
            case "take":
                CM.takeMoney();
                break;
            case "fill":
                CM.fillSupplies();
                break;
            case"buy":
                CM.buyCoffee();
                break;
        }
        CM.displayCoffeeMachineSupplies();

//        CM.evaluateNumberOfServings(coffeeDrinks);

    }
}
