package nix.education.java.coffeemachine;

import java.util.Scanner;

class MakeCoffee {

    private final Scanner scanner = new Scanner(System.in);

    protected int water = 400;
    protected int milk = 540;
    protected int coffeebeans = 120;
    protected int cache = 550;
    protected int disposablecups = 9;

    //Espresso
    protected final int WATERFORESPRESSO = 250;
    protected final int COFFEEFORESPRESSO = 16;
    protected final int CACHEFORESPRESSO = 4;

    //latte
    protected final int WATERFORLATTE = 350;
    protected final int MILKFORLATTE = 75;
    protected final int COFFEELATTE = 20;
    protected final int CACHELATTE = 7;

    //cappuccino
    protected final int WATERFORCAPPUCCINO = 200;
    protected final int MILKFORCAPPUCCINO0 = 100;
    protected final int COFFEECAPPUCCINO = 12;
    protected final int CACHECAPPUCCINO = 6;

    protected int getWater() {
        return water;
    }

    protected int getMilk() {
        return milk;
    }

    protected int getCoffeebeans() {
        return coffeebeans;
    }

    protected int getCache() {
        return cache;
    }

    protected int getDisposablecups() {
        return disposablecups;
    }

    protected void take(int takeCache) {
        System.out.println("I gave you " + cache);
        cache -= takeCache;
    }

    protected void fill(int fillWater, int fillMilk, int fillCoffee, int cups) {
        water += fillWater;
        milk += fillMilk;
        coffeebeans += fillCoffee;
        disposablecups += cups;
    }

    protected void makeEspresso() {
        water -= WATERFORESPRESSO;
        coffeebeans -= COFFEEFORESPRESSO;
        disposablecups -= 1;
        cache += CACHEFORESPRESSO;
    }

    protected void makeLatte() {
        water -= WATERFORLATTE;
        milk -= MILKFORLATTE;
        coffeebeans -= COFFEELATTE;
        disposablecups -= 1;
        cache += CACHELATTE;
    }

    protected void makeCappuccino() {
        water -= WATERFORCAPPUCCINO;
        milk -= MILKFORCAPPUCCINO0;
        coffeebeans -= COFFEECAPPUCCINO;
        disposablecups -= 1;
        cache += CACHECAPPUCCINO;
    }

    protected void choiceCoffee() {

        while (true) {

            System.out.print("Write action (buy, fill, take, remaining, exit):\n>");
            String str = scanner.nextLine();
            Action action = Action.valueOf(str);

            switch (action) {
                case BUY:
                    caseBuy();
                    break;
                case FILL:
                    caseFill();
                    break;
                case TAKE:
                    take(cache);
                    System.out.println();
                    break;
                case REMAINING:
                    display();
                    break;
                case EXIT:
                    scanner.close();
                    return;
            }

        }
    }

    protected void display() {
        System.out.println("The coffee machine has:");
        System.out.println(getWater() + " of water\n" + getMilk() + " of milk\n"
                + getCoffeebeans() + " of coffee beans\n"
                + getDisposablecups() + " of disposable cups\n"
                + getCache() + " of money");
        System.out.println();
    }

    protected void caseFill() {
        System.out.print("Write how many ml of water you want to add:\n>");
        int fillWater = scanner.nextInt();
        System.out.print("Write how many ml of milk you want to add:\n>");
        int fillMilk = scanner.nextInt();
        System.out.print("Write how many grams of coffee beans you want to add:\n>");
        int fillCoffeeBeans = scanner.nextInt();
        System.out.print("Write how many disposable coffee cups you want to add:\n>");
        int fillCups = scanner.nextInt();
        fill(fillWater, fillMilk, fillCoffeeBeans, fillCups);
        System.out.println();
    }

    protected void caseBuy() {
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu\n>");
        String str1 = scanner.nextLine();
        TypeOfCoffee type = TypeOfCoffee.valueOf(str1);
        switch (type) {
            case ESPRESSO:
                caseEspresso();
                break;
            case LATTE:
                caseLatte();
                break;
            case CAPPUCCINO:
                caseCappuccino();
                break;
            case BACK:
                break;
        }
        System.out.println();
    }

    protected void caseEspresso(){
        if (water > WATERFORESPRESSO && coffeebeans > COFFEEFORESPRESSO && disposablecups != 0) {
            System.out.println("I have enough resources, making you a coffee!");
            makeEspresso();
        } else {
            System.out.println("Sorry, not enough resources");
        }
    }

    protected void caseLatte(){
        if (water > WATERFORLATTE && coffeebeans > COFFEELATTE
                && milk > MILKFORLATTE && disposablecups != 0) {
            System.out.println("I have enough resources, making you a coffee!");
            makeLatte();
        } else {
            System.out.println("Sorry, not enough resources");
        }
    }

    protected void caseCappuccino(){
        if (water > WATERFORCAPPUCCINO && coffeebeans > COFFEECAPPUCCINO
                && milk > MILKFORCAPPUCCINO0 && disposablecups != 0) {
            System.out.println("I have enough resources, making you a coffee!");
            makeCappuccino();
        } else {
            System.out.println("Sorry, not enough resources");
        }
    }

}
