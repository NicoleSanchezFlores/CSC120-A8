import java.util.HashMap;
import java.util.Map;

/**
 * represents a character in the stardew valley!! i lvoe stardew valley
 * implements the contract interface for interacting with items and performing actions.
 */
public class StardewCharacter implements Contract {

    private Map<String, Integer> inventory; // map to store items and their quantities
    private int energy; // energy level of the character

    public StardewCharacter() {
        this.inventory = new HashMap<>();
        this.energy = 100; // starting energy level
    }

    /**
     * picks up an item and adds it to the inventory.
     * @param item the item to grab
     */
    @Override
    public void grab(String item) {
        inventory.put(item, inventory.getOrDefault(item, 0) + 1);
        System.out.println("you found " + item + " and added it to your inventory.");
    }

    /**
     * drops an item from the inventory.
     * @param item the item to drop
     * @return a message indicating the action
     */
    @Override
    public String drop(String item) {
        if (inventory.containsKey(item)) {
            int count = inventory.get(item);
            if (count > 1) {
                inventory.put(item, count - 1);
            } else {
                inventory.remove(item);
            }
            return "you dropped " + item + " from your inventory.";
        } else {
            return "you don't have " + item + " in your inventory to drop.";
        }
    }

    /**
     * examines an item.
     * @param item the item to examine
     */
    @Override
    public void examine(String item) {
        System.out.println("you examine " + item + ". it looks interesting!");
    }

    /**
     * uses an item.
     * @param item the item to use
     */
    @Override
    public void use(String item) {
        System.out.println("you use " + item + ". it has no effect right now.");
    }

    /**
     * walks in a direction.
     * @param direction the direction to walk
     * @return always returns true, because characters can walk anywhere in stardew valley
     */
    @Override
    public boolean walk(String direction) {
        System.out.println("you walk " + direction + ".");
        return true;
    }

    /**
     * flies to specified coordinates. (stardew valley doesn't have flying mechanics, so this method does nothing.)
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @return always returns false, because flying is not possible in stardew valley
     */
    @Override
    public boolean fly(int x, int y) {
        System.out.println("you can't fly in stardew valley!");
        return false;
    }

    /**
     * decreases the energy level of the character.
     * @return the new energy level of the character
     */
    @Override
    public Number shrink() {
        energy -= 10; // decrease energy level
        System.out.println("you feel tired.");
        return energy;
    }

    /**
     * increases the energy level of the character.
     * @return the new energy level of the character
     */
    @Override
    public Number grow() {
        energy += 20; // increase energy level
        System.out.println("you feel refreshed.");
        return energy;
    }

    /**
     * allows the character to rest and regain energy.
     */
    @Override
    public void rest() {
        energy = 100; // restore energy to maximum
        System.out.println("you take a rest and regain your energy.");
    }

    /**
     * undoes the last action. (not implemented in this context.)
     */
    @Override
    public void undo() {
        System.out.println("undoing the last action is not supported in stardew valley.");
    }
}
