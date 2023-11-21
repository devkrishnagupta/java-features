package oppsConcepts;


class A {
    private int number;

    public A(int number) {
        this.number = number;
    }

    public A minus(B b) {
        return new A(this.number - b.getNumber());
    }

    public A plus(B b) {
        return new A(this.number + b.getNumber());
    }

    public A minus(int num) {
        return new A(this.number - num);
    }

    public int output() {
        return this.number;
    }

    public int getNumber() {
        return this.number;
    }
}

class B {
    private int number;

    public B(int number) {
        this.number = number;
    }

    public B minus(A a) {
        return new B(this.number - a.getNumber());
    }

    public B minus(int num) {
        return new B(this.number - num);
    }

    public int output() {
        return this.number;
    }

    public int getNumber() {
        return this.number;
    }
}

public class ArithmetaicOperationsUsingObjects {
    public static void main(String[] args) {
        A a = new A(10);
        B b = new B(20);

        System.out.println("A - B = -10 : " + a.minus(b).output());
        System.out.println("B - A = -20 : " + b.minus(a).output());
        System.out.println("A + B - 10 - 20 = 0 : " + a.plus(b).minus(10).minus(20).output());

        System.out.println("Final value of a: "+a.output());
        System.out.println("Final value of b: "+b.output());
    }
}
