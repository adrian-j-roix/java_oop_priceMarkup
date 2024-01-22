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
 * Uses Item.java class
 *  
 * It seemed like Markup.java is either a part of 
 * or an extension of the Item.java class.
 */

package commerce_item_API;
import java.util.Scanner;
import java.util.Locale;
import java.text.NumberFormat;

public class Markup {
	// Private fields
	private float markup_percent;
	private float markup_decimal;
	private float markup_amount;
	private float markup_price;
	private String currency_markup_price;
	private String currency_current_price;
	private Item markup_item;
	// Public properties
	public float getMarkup_percent() {
		return markup_percent;
	}
	public void setMarkup_percent(Scanner scanner_input) {
		System.out.print("Percent markup %: ");
		markup_percent = scanner_input.nextFloat();
	}
	public float getMarkup_decimal() {
		return markup_decimal;
	}
	public void setMarkup_decimal() {
		markup_decimal = markup_percent / 100;
	}
	public float getMarkup_price() {
		return markup_price;
	}
	public void setMarkup_price(float initial_price) {
		markup_amount = markup_decimal * markup_item.getPrice();
		markup_price = markup_amount + markup_item.getPrice();
	}
	public String getCurrency_markup_price() {
		return currency_markup_price;
	}
	public void setCurrency_markup_price() {
		currency_markup_price = formatCurrency(markup_price); 
	}
	public String getCurrency_current_price() {
		return currency_current_price;
	}
	public void setCurrency_current_price() {
		currency_current_price = formatCurrency(markup_item.getPrice()); 
	}
	// Constructors
	public Markup(Item item_new, Scanner scanner_input) {
		this.markup_item = item_new;
		// Prompt user for item number, description, and current price
		this.markup_item.prompt_values(scanner_input);
		// Prompt user for markup percent
		this.setMarkup_percent(scanner_input);
		// Calculate new price
		this.setMarkup_decimal();
		this.setMarkup_price(this.markup_item.getPrice());
		this.setCurrency_markup_price();
		this.setCurrency_current_price();
	}
	// Public methods
	private static String formatCurrency(float amount) {
        // Create a NumberFormat instance for US locale
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        // Format the float as currency
        return currencyFormatter.format(amount);
    }
	public void final_toString() {
		/* 
		 * Item number
		 * Description
		 * Current price
		 * New price
		 */
		System.out.printf("Item number: %s\n", markup_item.getId());
		System.out.printf("Item description: %s\n", markup_item.getDescription());
		System.out.printf("Current price: %s\n", this.currency_current_price);
		System.out.printf("New price: %s\n", this.currency_markup_price);
	}
	// Main
	public static void main(String[] args) {
		System.out.println("Price Markup App\n");
		Scanner scanner_input = new Scanner(System.in);
		Item item_new = new Item();
		Markup markup = new Markup(item_new, scanner_input);
		System.out.println();
		markup.final_toString();
		scanner_input.close();
	}
}
