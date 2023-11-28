package designPatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

//Step 1 //FlyWeight interface
interface GameObject {
    void render(String player);
}

//Step 2 //Concrete Flyweight
class Tree implements GameObject {

    private String type;
    
    public Tree(String type){
        this.type=type;
    }

    @Override
    public void render(String player) {
        System.out.println("Rendering a "+ type + " for player "+player);
    }
}

//Step 3 //Flyweight Factory
class GameObjectFactory {
    
    private final Map<String, GameObject> gameObjects = new HashMap<>();

    public GameObject getGameObject(String type){
        return gameObjects.computeIfAbsent(type, Tree::new);
    }
}

//Step 4 //Client(Game)
public class Game {
    public static void main(String[] args) {
        GameObjectFactory gameObjectFactory = new GameObjectFactory();
        
        //Simulate rendering game object for multiple players
        String[] players = {"player1", "player2", "player3", "player4"};
        for (String player : players) {
            GameObject tree = gameObjectFactory.getGameObject("Tree");
            tree.render(player+" HashCode is: "+tree.hashCode());
        }
    }
}