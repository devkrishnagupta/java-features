# Flyweight Design Pattern
The Flyweight pattern is a structural design pattern that minimizes memory usage by sharing common objects as much as possible. It is particularly useful in scenarios where a large number of similar objects need to be created and managed. The pattern achieves this by separating an object’s intrinsic state (shared among multiple objects) from its extrinsic state (unique to each object).

##Components of the Flyweight Pattern
Flyweight Interface/Abstract Class: This defines the interface for concrete flyweights. Typically, it includes a method to accept and process the extrinsic state.
Concrete Flyweight: These are the actual flyweight objects that implement the Flyweight interface. They store intrinsic states that can be shared among multiple objects.
Flyweight Factory: This is responsible for creating and managing flyweight objects. It ensures that flyweights are shared and reused as much as possible.
Client: The client code uses flyweights to create and manipulate objects. It passes the extrinsic state to the flyweights when needed.