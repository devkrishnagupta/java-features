package designPatterns.decorator;

public class FarmHouse implements Pizza {

    @Override
    public String getDescription() {
        return "This is a Farm House Pizza";
    }

    @Override
    public double getPrice() {
        return 500.00;
    }
    
}
