package com.example.android.justjava; /**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p/>
 * package com.example.android.justjava;
 */


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        displayMessage(createOrderSummary("Sagar", calculatePrice(5)));
    }

    /**
     * This method returns summary of an order
     */
    private String createOrderSummary(String name, int price) {
        return ("Name: " + name + "\nQuantity: " + quantity + "\nTotal Rs." + price + " \nThank You!");
    }

    /**
     * Calculates the price of the order.
     *
     * @param pricePerCup is the price per cups of coffee ordered
     */
    private int calculatePrice(int pricePerCup) {
        return quantity * pricePerCup;
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSumamryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSumamryTextView.setText(message);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
        displayPrice(calculatePrice(5));
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);
        displayPrice(calculatePrice(5));
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}