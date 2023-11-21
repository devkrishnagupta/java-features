import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        try{
            System.out.println(10/0);
        }catch(ArithmeticException | ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }


        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a number: ");
            int number = scanner.nextInt();

            if (number == 0) {
                throw new Exception("then number will come");
            } else {
                System.out.println("Entered number is: " + number);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

class TestException extends RuntimeException {
    private static ArithmeticException e;
    public static void main(String[] args) {
  
        //throw new TestException();
     
    }
}
