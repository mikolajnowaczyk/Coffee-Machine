package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static final int waterPerCup = 200;
    static final int milkPerCup = 50;
    static final int coffeeBeansPerCup = 15;
    private void displayActions(){
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int coffeeDrinks = scanner.nextInt();
        System.out.println("For "+coffeeDrinks+" cups of caffee you will need:");
        System.out.println(coffeeDrinks * waterPerCup + " ml of water");
        System.out.println(coffeeDrinks * milkPerCup+ " ml of milk");
        System.out.println(coffeeDrinks * coffeeBeansPerCup + " g of coffee beans");

    }
}
