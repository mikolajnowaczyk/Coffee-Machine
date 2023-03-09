package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static final int waterPerCup = 200;
    private static final int milkPerCup = 50;
    private static final int coffeeBeansPerCup = 15;

    private static int waterAmount = 0;
    private static int milkAmount = 0;
    private static int coffeeBeansAmount = 0;
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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine CM = new CoffeeMachine();
        CM.getCoffeeMachineSupplies();
        System.out.println("Write how many cups of coffee you will need:");
        int coffeeDrinks = scanner.nextInt();
        CM.evaluateNumberOfServings(coffeeDrinks);

    }
}
