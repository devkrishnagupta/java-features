package designPatterns.decorator;

public class Cheese implements PizzaDecorator {

    private Pizza pizza;

    public Cheese(Pizza pizza){
        this.pizza=pizza;
    }

    @Override
    public String getDescription() {
        return this.pizza.getDescription() + " with extra cheese";
    }

    @Override
    public double getPrice() {
        return this.pizza.getPrice() + 10.00;
    }
    
}
