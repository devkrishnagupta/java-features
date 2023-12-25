package designPatterns.commandPattern.sketchBoard;

class DrawShape {

    public String shape;

    public DrawShape(String shape){
        this.shape=shape;
    }

    public void drawCircle(){
        System.out.println("Drawing circle..."+shape);
    }

    public void drawSquare(){
        System.out.println("Drawing square..."+shape);
    }

    public void drawRectangle(){
        System.out.println("Drawing rectangle..."+shape);
    }

    public void eraseShape(String shape){
        System.out.println("Erasing "+shape);
    }
}

interface Command {
    void execute();
    void undo(String shape);
}

class DrawCircleConcreteCommand implements Command {

    private DrawShape draw;

    public DrawCircleConcreteCommand(DrawShape draw){
        this.draw=draw;
    }

    @Override
    public void execute() {
        this.draw.drawCircle();
    }

    @Override
    public void undo(String shape) {
        this.draw.eraseShape(shape);
    }

}

class DrawSquareConcreteCommand implements Command {

    private DrawShape draw;

    public DrawSquareConcreteCommand(DrawShape draw){
        this.draw=draw;
    }

    @Override
    public void execute() {
        this.draw.drawSquare();
    }

    @Override
    public void undo(String shape) {
        this.draw.eraseShape(shape);
    }
    
}

class DrawRectangleConcreteCommand implements Command {


    private DrawShape draw;

    public DrawRectangleConcreteCommand(DrawShape draw){
        this.draw=draw;
    }

    @Override
    public void execute() {
        this.draw.drawRectangle();
    }

    @Override
    public void undo(String shape) {
        this.draw.eraseShape(shape);
    }
    
}

class SketchBoard {
    
    Command command;

    public void setCommand(Command command){
        this.command=command;
    }

    public void drawTheShape(){
        this.command.execute();
    }

    public void eraseTheShape(String shape){
        command.undo(shape);
    }
}

public class Main {
    
    public static void main(String[] args) {
        SketchBoard sketchBoard = new SketchBoard();

        System.out.println("-------------------------");
        
        DrawShape drawShape = new DrawShape("My Circle...");
        Command drawCircle = new DrawCircleConcreteCommand(drawShape);
        sketchBoard.setCommand(drawCircle);
        sketchBoard.drawTheShape();
        sketchBoard.eraseTheShape(drawShape.shape);

        System.out.println("-------------------------");

        drawShape = new DrawShape("My Square...");
        Command drawSquare = new DrawSquareConcreteCommand(drawShape);
        sketchBoard.setCommand(drawSquare);
        sketchBoard.drawTheShape();

        System.out.println("-------------------------");

        drawShape = new DrawShape("My Rectangle...");
        Command drawRectangle = new DrawRectangleConcreteCommand(drawShape);
        sketchBoard.setCommand(drawRectangle);
        sketchBoard.drawTheShape();
        sketchBoard.eraseTheShape(drawShape.shape);
    }
}