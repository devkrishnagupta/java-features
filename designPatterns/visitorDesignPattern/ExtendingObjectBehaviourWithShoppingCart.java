package designPatterns.visitorDesignPattern;

//Visitor
interface ShoppingCartVisitor {
    double visit(Item item);
    double visit(Book book);
    double visit(Fruit fruit);
}

//Concrete Visitors
class ShoppingCartVisitorImpl implements ShoppingCartVisitor {

    @Override
    public double visit(Item item) {
        return item.getPrice();
    }

    @Override
    public double visit(Book book) {
        double cost = book.getPrice();
        if (cost > 50) {
            cost-=5;//Apply discount for expesive book.
        }
        return cost;
    }

    @Override
    public double visit(Fruit fruit) {
        return fruit.getPricePerKg() * fruit.getWeight();
    }
}

//Element
interface ShoppingCartElement {
    double accept(ShoppingCartVisitor visitor);
}

//Concrete Element (Item)
class Item implements ShoppingCartElement{

    private String name;
    private double price;

    public Item(String name, double price){
        this.name=name;
        this.price=price;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    @Override
    public double accept(ShoppingCartVisitor visitor){
        return visitor.visit(this);
    }
}

//Concrete Element (Book)
class Book implements ShoppingCartElement {

    private String title;
    private double price;

    public Book(String title, double price){
        this.title=title;
        this.price=price;
    }

    public String getTitle(){
        return this.title;
    }

    public double getPrice(){
        return this.price;
    }

    @Override
    public double accept(ShoppingCartVisitor visitor){
        return visitor.visit(this);
    }
}

//Concrete Element (Fruit)
class Fruit implements ShoppingCartElement {

    private String name;
    private double pricePerKg;
    private double weight;

    public Fruit(String name, double pricePerKg, double weight){
        this.name=name;
        this.pricePerKg=pricePerKg;
        this.weight=weight;
    }

    public String getName(){
        return this.name;
    }

    public double getPricePerKg(){
        return this.pricePerKg;
    }

    public double getWeight(){
        return this.weight;
    }

    @Override
    public double accept(ShoppingCartVisitor visitor){
        return visitor.visit(this);
    }
}

public class ExtendingObjectBehaviourWithShoppingCart {
    public static void main(String[] args) {
        ShoppingCartElement[] items = new ShoppingCartElement[]{
            new Item("Pen", 2.5),
            new Book("Java Design Pattrens", 60.0),
            new Fruit("Apple", 1.5, 2.0)
        };
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        double totalCost = 0;
        for(ShoppingCartElement item: items){
            double currentCost=item.accept(visitor);
            totalCost+=currentCost;
            System.out.println("Cost of "+item+": "+currentCost);
        }
        System.out.println("Total cost after discounts: " + totalCost);
    }
}