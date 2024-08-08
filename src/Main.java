import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Double> price = new ArrayList<>();
        String userID, password;
         double payment,applyVAT,VAT_rate, discountpercentage;

        while(true) {
            System.out.print("Enter User ID (or 'quit' to exit): ");
             userID = in.nextLine();
            if (userID.equals("quit")) {
                System.out.println("goodbye");
            }
            System.out.print("Enter Password: ");
            password = in.nextLine();
        }
        if (userID.equals("Valid userID") || password.equals("Valid password")) {
            while (true) {
                price.clear();
                System.out.print("Enter Your Number of Items: ");
                int numItems = in.nextInt();

                for (int i = 0; i < numItems; i++) {
                    System.out.print("Enter the price of your item" + (i + 1) + ": ");
                    double itemPrice;

                }
                System.out.print("Should VAT be applied? (Y/N): ");
                String vat = in.nextLine();
                boolean applyvat = vat.equals("Y") || vat.equals("Yes");


                if (vat.equals("y")) {
                    System.out.println("13 % VAT is added");
                }
                System.out.print("Enter discount percentage: ");
                double discountPercentage = in.nextDouble();

                double total = calculateTotal(price, applyVAT, discountpercentage);
                System.out.println("The total price is: " + total);

                System.out.println("Enter the payment amount");
                double payment;


                if (payment < total) {
                    System.out.println("The payment is not enough. Please try again");

                }
                double change = payment - total;
                System.out.println("The change is: " + change);
                System.out.println("highest denomination of the change:" + (change));
            } else{
                System.out.println("The credential does not exist. please try again");
            }
        }
        in.close();

    }
}
public static double calculateTotal(ArrayList<Double>prices,boolean applyVAT,double discount){
    double subtotal = 0;
    for (int i = 0; i < prices.size(); i++) {
        subtotal += prices.get(i);
        if (applyVAT) {
            subtotal += subtotal*VAT_rate;
        }
        if (discount > 0) {
            subtotal -= subtotal*(discount/100);
        }
        return subtotal;
    }
    public static double getHighestDenomination(double change){
        int [] n={1000,500,100,50,20,10,5,2,1};
        for (int a:n) {
            if (change >= a) {
                return a;
            }
        }
        return 0;
    }
}

