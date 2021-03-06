package learntocode.patterns.nullobject;

/**
 * Some random actual implementation
 */
public class MyActualClass extends MyBaseClass {
    @Override
    public void printStuff() {
        System.out.println("I'm useful!");
    }

    @Override
    public int getRandomInteger() {
        // picked by fair and random dice roll
        return 4;
    }
}
