/* Juna Roix
 * W24_COP2552_0M1
 * Professor Sullivan
 * Spring 2024
 * 
 * Project 1 - Price Markup
 * Prompt the user to enter an item number, 
 * a description, a current price, and a markup 
 * percentage. Then, the item's markup amount is 
 * found through the product of the markup decimal 
 * and initial price. Then, the sum of the markup amount 
 * and the initial price provides the new markup price. 
 * This information is then used to display 
 * the before & after info to the user.
 * 
 * Item.java class works with Markup.java class
 * 
 * It seemed like Markup.java is either a part of 
 * or an extension of the Item.java class.
 */

package commerce_item_API;

import java.util.Scanner;

public class Item {
	// Private fields
	private String id;
	private String description;
	private float price;
	// Public properties
	public String getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	public float getPrice() {
		return price;
	}
	public Item() {
		this.id= "";
		this.description = "";
		this.price= 0;
	}
	// Public methods
	public void terminal_promptValues(Scanner scanner_input) {
		System.out.print("Item number: ");
		id = scanner_input.nextLine(); 
		System.out.printf("Item %s description: ", id);
		description = scanner_input.nextLine(); 
		System.out.printf("Current price of item %s: ", id);
		price = scanner_input.nextFloat(); 
	}
}
