package Question1;

/**
 * import java.text.DecimalFormat to make sure the output of double variable
 * reserved two decimals import java.util.Scanner package that let user could
 * input something in output layout
 *
 * @author Ray
 */
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * The class Item implements an application that simply count and display the
 * data inputed by user on one invoice name: title of one item quantity: number
 * of one item price: price of one item total: total price of one item
 *
 * @author Ray
 */
public class Item {

    private String name;
    private int quantity;
    private double price;
    private double total;

    /**
     * construct method with no parameter
     */
    public Item() {
    }

    /**
     * construct method with four parameters
     *
     * @param name title of one item
     * @param quantity number of one item
     * @param price price of one item
     * @param total total price of one item
     */
    public Item(String name, int quantity, double price, double total) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
    }

    /**
     * obtain name of one item object
     *
     * @return title of one item
     */
    public String getName() {
        return name;
    }

    /**
     * assign name for one item object
     *
     * @param name title of one item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * obtain number of one item object
     *
     * @return number of one item
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * assign number for one item object
     *
     * @param quantity number of one item
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * obtain price of one item object
     *
     * @return price of one item
     */
    public double getPrice() {
        return price;
    }

    /**
     * assign price for one item object
     *
     * @param price price of one item
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * obtain total price of one item object
     *
     * @return total price of one item
     */
    public double getTotal() {
        return total;
    }

    /**
     * assign price for one item object
     *
     * @param total total price of one item
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * main method used to input several information of three items, count and
     * print them on one formal invoice
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // new one object Item with no parameter
        Item item1;
        item1 = new Item();
        //create one object in type of Scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("Input name of item 1:");
        //get and store the content of input in one line
        String name1 = sc.nextLine();
        //store the input information on name of item1
        item1.setName(name1);
        System.out.println("Input quantity of item 1:");
        // exception module
        try {
            // get and store the content of input in one line,transfer the data type from string to int
            int quantity1 = Integer.parseInt(sc.nextLine());
            //store the input information on quantity of item1
            item1.setQuantity(quantity1);
            System.out.println("Input price of item 1:");
            // get and store the content of input in one line,transfer the data type from double to int
            Double price1 = Double.parseDouble(sc.nextLine());
            //store the input information on price of item1
            item1.setPrice(price1);
            // new one object Item with no parameter
            Item item2;
            item2 = new Item();
            System.out.println("Input name of item 2:");
            //get and store the content of input in one line
            String name2 = sc.nextLine();
            //store the input information on name of item2
            item2.setName(name2);
            System.out.println("Input quantity of item 2:");
            // get and store the content of input in one line,transfer the data type from string to int
            int quantity2 = Integer.parseInt(sc.nextLine());
            //store the input information on quantity of item2
            item2.setQuantity(quantity2);
            System.out.println("Input price of item 2:");
            // get and store the content of input in one line,transfer the data type from double to int
            Double price2 = Double.parseDouble(sc.nextLine());
            //store the input information on price of item2
            item2.setPrice(price2);
            // new one object Item with no parameter
            Item item3;
            item3 = new Item();
            System.out.println("Input name of item 3:");
            //get and store the content of input in one line
            String name3 = sc.nextLine();
            //store the input information on name of item3
            item3.setName(name3);
            System.out.println("Input quantity of item 3:");
            // get and store the content of input in one line,transfer the data type from string to int
            int quantity3 = Integer.parseInt(sc.nextLine());
            //store the input information on quantity of item3
            item3.setQuantity(quantity3);
            System.out.println("Input price of item 3:");
            // get and store the content of input in one line,transfer the data type from double to int
            Double price3 = Double.parseDouble(sc.nextLine());
            //store the input information on price of item3
            item3.setPrice(price3);
            //create one object in type of DecimalFormat that make one formation reserved two decimals
            DecimalFormat df = new DecimalFormat("0.00");
            // create three attributes in type of double that obtain and count total prices of three items seperately
            Double totalOne = item1.getQuantity() * item1.getPrice();
            Double totalTwo = item2.getQuantity() * item2.getPrice();
            Double totalThree = item3.getQuantity() * item3.getPrice();
            // store total price one previous three objects
            item1.setTotal(totalOne);
            item2.setTotal(totalTwo);
            item3.setTotal(totalThree);
            // create one attribute in type of double that store total prices of all items
            Double subTotal = totalOne + totalTwo + totalThree;
            double tax = 0.0625;
            // tax fee
            Double salesTax = subTotal * tax;
            // real total price
            Double total = salesTax + subTotal;
            // display one invoice in format of requirements
            System.out.format("%-30s", "Your bill:");
            System.out.println();
            System.out.println();
            System.out.format("%-30s%-10s%-10s%-10s", "Item", "Quantity", "Price", "Total");
            System.out.println();
            System.out.format("%-30s%-10s%-10s%-10s", item1.getName(), item1.getQuantity(), df.format(item1.getPrice()), df.format(item1.getTotal()));
            System.out.println();
            System.out.format("%-30s%-10s%-10s%-10s", item2.getName(), item2.getQuantity(), df.format(item2.getPrice()), df.format(item2.getTotal()));
            System.out.println();
            System.out.format("%-30s%-10s%-10s%-10s", item3.getName(), item3.getQuantity(), df.format(item3.getPrice()), df.format(item3.getTotal()));
            System.out.println();
            System.out.format("%-50s%-10s", "Subtotal", df.format(subTotal));
            System.out.println();
            System.out.format("%-50s%-10s", "6.25% sales tax", df.format(salesTax));
            System.out.println();
            System.out.format("%-50s%-10s", "Total", df.format(total));
            System.out.println();
            // capture the exception inputed invalid data
        } catch (NumberFormatException e) {
            // display reason of exception
            System.out.println(e.getMessage() + " is invalid input!");
            System.out.println("Please Restart!");
        }
    }
}
