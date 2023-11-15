package designPatterns.decorator;

public class Toopings implements PizzaDecorator {

    private Pizza pizza;

    public Toopings(Pizza pizza){
        this.pizza=pizza;
    }

    @Override
    public String getDescription() {
        return this.pizza.getDescription() + " with extra toopings";
    }

    @Override
    public double getPrice() {
        return this.pizza.getPrice() + 50.00;
    }
    
}
