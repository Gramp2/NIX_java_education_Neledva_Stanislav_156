package nix.education.java.coffeemachine;

interface IngredietCalculator {

    int calculateSomeMilk(int count);

    int calculateSomeWater(int count);

    int calculateSomeCoffeeBeans(int count);

}

class IngridietCalculatorImpl implements IngredietCalculator {

    protected final int someMilk = 50;
    protected final int someWater = 200;
    protected final int seedsCoffeeBeans = 15;

    @Override
    public int calculateSomeMilk(int count) {
        return count * someMilk;
    }

    @Override
    public int calculateSomeWater(int count) {
        return count * someWater;
    }

    @Override
    public int calculateSomeCoffeeBeans(int count) {
        return count * seedsCoffeeBeans;
    }
}
