package lab9;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.text.DecimalFormat;

public class Lab9 {

	private static Map<String, Double> menu = new HashMap<>();
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner (System.in);
		String cartItem;
		String userDecision;
		String orderMore;
		DecimalFormat df = new DecimalFormat("#.00");
		
		System.out.println("Welcome to Dave's Market! \n");
		
		ArrayList<Double> cartPrices = new ArrayList<>();
		ArrayList<String> cartNames = new ArrayList<>();
		
		System.out.println("Item    Price ($) ");
		System.out.println("======================");
		populateMenu();
		printMenu();
		
		
		
		do {
			System.out.println("\nPlease enter the name of the item you would like to purchase: ");
			cartItem = scnr.nextLine();
			if (menu.containsKey(cartItem)) {
				System.out.println(cartItem + ": $" + menu.get(cartItem));
				cartPrices.add(menu.get(cartItem));
				cartNames.add(cartItem);
			}
			else {
				System.out.println("Invalid input. Please enter the name of the item exactly as it appears on the menu.");
			}
		
		
			System.out.println("You ordered " + cartItem +". Would you like to order more? (Enter y/n)");
			orderMore = scnr.nextLine();
		
			while (orderMore.equalsIgnoreCase("y")) {
				cartPrices.add(menu.get(cartItem));
				cartNames.add(cartItem);
				System.out.println("You ordered " + cartItem +". Would you like to order additional quantities of that item? (Enter y/n)");
				orderMore = scnr.nextLine();
				continue;
			}
		
			System.out.println("Would you like to order another item off of the menu? (Enter y/n)");
			System.out.println();
			System.out.println("Item    Price ($) ");
			System.out.println("======================");
			populateMenu();
			printMenu();
			userDecision = scnr.nextLine();
		
		
		} while (userDecision.equalsIgnoreCase("y"));
		scnr.close();
		
		System.out.println("Order summary: ");
		System.out.println("========================");
		for (int i = 0; i<cartPrices.size(); i++) {
			System.out.println(cartNames.get(i) + "     " + "$" +cartPrices.get(i));    
			
		}
		
		double sum = findSum(cartPrices);
		System.out.println("Your total is: $" + df.format(sum));
		System.out.println("The average price of the items you ordered is: $" + df.format(findAverage(cartPrices)));
	}
	
	private static void populateMenu() {
		menu.put("apple", 0.59);
		menu.put("cereal", 3.59);
		menu.put("milk", 2.59);
		menu.put("orange", 0.69);
		menu.put("yogurt", 0.99);
		menu.put("chicken", 4.99);
		menu.put("lettuce", 1.99);
		menu.put("rice", 0.99);
		
	}
	
	private static void printMenu() {
		for (String name : menu.keySet()) {
			System.out.println(name + "\t" + menu.get(name));
		}
	
	}

	
	private static Double findSum(ArrayList<Double> cartPrices) {
	    double sum = 0;
	    for (double j : cartPrices) {
	        sum += j;
	    }
	    return sum;
	}
	
	private static Double findAverage(ArrayList<Double> cartPrices) {
	    double sum = findSum(cartPrices);
	    return sum / cartPrices.size();
	}
	    
}
