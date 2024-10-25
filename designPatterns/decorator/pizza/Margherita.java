package designPatterns.decorator;

public class Margherita implements Pizza {

    @Override
    public String getDescription() {
        return "This is margherita pizza";
    }

    @Override
    public double getPrice() {
        return 400.00;
    }

    
}