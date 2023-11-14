package functionalProgrammingInJava;

public class Test {
    public static void main(String[] args) {
        try{
            System.out.println(10/0);
        }catch(ArithmeticException | NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
}
