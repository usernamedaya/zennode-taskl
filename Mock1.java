package countarray;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter.BigDecimalLayoutForm;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
//patterns
public class Mock1
{
	
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
        int price1 = 20;
        int price2 = 40;
        int price3= 50;
        System.out.print("Enter quantity for Product A : ");
        int quantity1 = scanner.nextInt();
        System.out.print("Is Product A a gift? (true/false): ");
        boolean gift1 = scanner.nextBoolean();

        System.out.print("Enter quantity for Product B: ");
        int quantity2 = scanner.nextInt();
        System.out.print("Is Product B a gift? (true/false): ");
        boolean gift2 = scanner.nextBoolean();

        System.out.print("Enter quantity for Product C: ");
        int quantity3 = scanner.nextInt();
        System.out.print("Is Product C a gift? (true/false): ");
        boolean gift3 = scanner.nextBoolean();

        // Calculate total amount for each product
        int total1 = calculateTotal(price1, quantity1);
        int total2 = calculateTotal(price2, quantity2);
        int total3 = calculateTotal(price3, quantity3);
        int subtotal = total1+ total2 + total3;

        // Apply discounts
        DiscountResult discountResult = applyDiscounts(quantity1, quantity2, quantity3);

        // Calculate shipping and gift wrap fees
        int shippingFee = calculateShippingFee(quantity1 + quantity2 + quantity3);
        int giftWrapFee = calculateGiftWrapFee(quantity1, gift1) +calculateGiftWrapFee(quantity2, gift2) +calculateGiftWrapFee(quantity3, gift3);

        int total = subtotal - discountResult.discountAmount + shippingFee + giftWrapFee;

        // Display details
        System.out.println("\nProduct Details:");
        displayProductDetails("Product A", quantity1, total1);
        displayProductDetails("Product B", quantity2, total2);
        displayProductDetails("Product C", quantity3, total3);

        System.out.println("\nSubtotal: $" + subtotal);
        System.out.println("Discount Applied: " + discountResult.discountName + " - $" + discountResult.discountAmount);
        System.out.println("Shipping Fee: $" + shippingFee);
        System.out.println("Gift Wrap Fee: $" + giftWrapFee);
        System.out.println("\nTotal: $" + total);
    }

    private static int calculateTotal(int price, int quantity) {
        return price * quantity;
    }

    private static DiscountResult applyDiscounts(int quantityA, int quantityB, int quantityC) 
    {
        return new DiscountResult("No Discount", 0);
    }

    private static int calculateShippingFee(int totalQuantity) 
    {
        return (int) Math.ceil((double) totalQuantity / 10) * 5;
    }

    private static int calculateGiftWrapFee(int quantity, boolean isGift)
    {
        return isGift ? quantity : 0;
    }

    private static void displayProductDetails(String productName, int quantity, int totalAmount) 
    {
        System.out.println(productName + " - Quantity: " + quantity + ", Total: $" + totalAmount);
    }

    private static class DiscountResult
    {
        String discountName;
        int discountAmount;

        public DiscountResult(String discountName, int discountAmount) 
        {
            this.discountName = discountName;
            this.discountAmount = discountAmount;
        }
    }
		
}

	


