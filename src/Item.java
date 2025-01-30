import java.util.ArrayList;

public class Item {

    // Initialize the private variables of the class
    private String itemName;
    private double itemPrice;

    // Default constructor
    public Item() {
        this.itemName = "UNKNOWN";
        this.itemPrice = 0;
    }

    // Constructor assigning the name and price of an Item
    public Item(String name, double price) {
        this.itemName = name;
        this.itemPrice = price;
    }

    // Assign a specific name to the calling Item (Setter)
    public void setItemName(String name) {
        this.itemName = name;
    }

    // Assign a specific price to the calling Item (Setter)
    public void setItemPrice(Double price) {
        this.itemPrice = 0;
    }

    // Returns the private price of the item (Getter)
    public double getItemPrice() {
        return this.itemPrice;
    }

    // Returns the private name of the Item (Getter)
    public String getItemName() {
        return this.itemName;
    }
}


class Lab1 {
    //Create the setupStore method with array of items aligned with the example
    public static Item[] setupStore() {
        Item[] store = new Item[5];
        store[0] = new Item("Bananas", 1.5);
        store[1] = new Item("Apple", 0.5);
        store[2] = new Item("Bread", 2.0);
        store[3] = new Item("Milk", 3.0);
        store[4] = new Item("Eggs", 2.5);
        return store; //now the store array contains all the item objects
    }

    //Create the createCart method
    public static ArrayList<Item> createCart(String[] args, Item[] store) {
        ArrayList<Item> cart = new ArrayList<>(); // passing in custom object: Item

        for (String arg : args) {
            try {
                int index = Integer.parseInt(arg); // Convert input to integer
                if (index >= 0 && index < store.length) {
                    cart.add(store[index]); // Add item to cart if index is valid
                } else {
                    System.out.println("The store does not have an item of index " + index + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("\"" + arg + "\" is not a valid integer.");
            }
        }

        if (cart.isEmpty()) {
            System.out.println("No valid input to cart.");
        }

        return cart;
    }

    //Create the printReceiptInOrder method
    public static void printReceiptInOrder(ArrayList<Item> cart) {
        double subtotal = 0.0;

        System.out.println("Receipt");
        System.out.println("=========================");
        System.out.println("Item\tPrice");

        for (Item item : cart) {
            System.out.println(item.getItemName() + "\t" + item.getItemPrice());
            subtotal += item.getItemPrice();
        }

        System.out.println("=========================");
        System.out.println("(a) Subtotal: " + subtotal);

        double salesTax = subtotal * 0.05; // 5% sales tax
        System.out.println("(b) Sales Tax: 5%");

        double total = subtotal + salesTax;
        System.out.println("(c) Total: " + total);
    }

    //Create the emptyCartReverseOrder method
    public static void emptyCartReverseOrder(ArrayList<Item> cart) {
        System.out.println("Removing all items from the cart in \"Last In First Out\" order...");

        while (!cart.isEmpty()) {
            Item lastItem = cart.remove(cart.size() - 1); // Remove the last item
            System.out.println("Removing: " + lastItem.getItemName());
        }

        System.out.println("Cart has been emptied.");
    }

    //Main method
    public static void main(String[] args) {
        //setting up the store in the main
        Item[] store = setupStore();

        //Create the cart according to commandline input
        ArrayList<Item> cart = createCart(args, store);

        //Print the receipt if the cart is not empty
        if (!cart.isEmpty()) {
            printReceiptInOrder(cart);
        }

        //Empty the cart in reverse order
        emptyCartReverseOrder(cart);
    }
}
