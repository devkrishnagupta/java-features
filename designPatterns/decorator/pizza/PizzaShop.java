package designPatterns.decorator;

public class PizzaShop {
    public static void main(String[] args) {

        Pizza margherita = new Margherita();
        margherita = new Cheese(margherita);
        margherita = new Toopings(margherita);
        System.out.println(margherita.getDescription());
        System.out.println(margherita.getPrice());

        System.out.println("------------------------");

        Pizza farmHouse = new FarmHouse();
        farmHouse=new Toopings(farmHouse);
        System.out.println(farmHouse.getDescription());
        System.out.println(farmHouse.getPrice());
    }
}
