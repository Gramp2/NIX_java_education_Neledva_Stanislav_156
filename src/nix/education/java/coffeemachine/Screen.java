package nix.education.java.coffeemachine;

import java.util.Scanner;

class Screen {

    private Scanner scanner = new Scanner(System.in);
    protected void display() {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
        System.out.println();
    }

    protected void displayCalculation() {
        System.out.print("Write how many cups of coffee you will need:\n>");
        int count = scanner.nextInt();
        System.out.println("For " + count + " cups of coffee you will need:");
        IngridietCalculatorImpl ing = new IngridietCalculatorImpl();
        System.out.println(ing.calculateSomeWater(count) + " ml of water");
        System.out.println(ing.calculateSomeMilk(count) + " ml of milk");
        System.out.println(ing.calculateSomeCoffeeBeans(count) + " g of coffee beans");
        System.out.println();
    }

    protected void check() {
        IngridietCalculatorImpl variable = new IngridietCalculatorImpl();
        System.out.print("Write how many ml of water the coffee machine has:\n>");
        int water = scanner.nextInt();
        System.out.print("Write how many ml of milk the coffee machine has:\n>");
        int milk = scanner.nextInt();
        System.out.print("Write how many grams of coffee beans the coffee machine has:\n>");
        int coffee = scanner.nextInt();
        System.out.print("Write how many cups of coffee you will need:\n>");
        int countOfCups = scanner.nextInt();
        int possibleCups;
        if (countOfCups != -1) {
            int divWater = water / variable.someWater,
                    divMilk = milk / variable.someMilk,
                    divCoffee = coffee / variable.seedsCoffeeBeans;
            possibleCups = Math.min(divWater, Math.min(divMilk, divCoffee));
            if (countOfCups > possibleCups) {
                System.out.println("No, I can make only " + possibleCups + " cups of coffee");
            } else if ((possibleCups - countOfCups) != 0) {
                System.out.println("Yes, I can make that amount of coffee (and even " + (possibleCups - countOfCups) + " more than that)");
            } else System.out.println("Yes, I can make that amount of coffee.");
        }
    }

}
