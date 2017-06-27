package com.example.android.justjava; /**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p/>
 * package com.example.android.justjava;
 */


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;
    int pricePerCup = 20;
    boolean whippedTopping = false;
    boolean chocoTopping = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText nm = (EditText) findViewById(R.id.edit_text);
        String name = nm.getText().toString();
        displayMessage(createOrderSummary(name, calculatePrice()));
    }

    /**
     * This method returns summary of an order
     */
    private String createOrderSummary(String name, int price) {
        return ("Name: " + name + "\nAdd Whipped Cream ? " + whippedTopping + "\nAdd Chocolate ? " + chocoTopping + "\nQuantity: " + quantity + "\nTotal Rs: " + price + " \nThank You!");
    }

    /**
     * called when choclate toppings added
     *
     * @param view
     */
    public void chocoadded(View view) {
        CheckBox chocolate = (CheckBox) findViewById(R.id.Chocolate_Checkbox);
        chocoTopping = chocolate.isChecked();
        if (chocoTopping) {
            pricePerCup = pricePerCup + 7;
            displayPrice(calculatePrice());
        } else {
            pricePerCup = pricePerCup - 7;
            displayPrice(calculatePrice());
        }
    }

    /**
     * called when whipped cream toppings added
     *
     * @param view
     */
    public void whippedadded(View view) {
        CheckBox whippedCream = (CheckBox) findViewById(R.id.Whipped_Cream_Checkbox);
        whippedTopping = whippedCream.isChecked();
        if (whippedTopping) {
            pricePerCup = pricePerCup + 5;
            displayPrice(calculatePrice());
        } else {
            pricePerCup = pricePerCup - 5;
            displayPrice(calculatePrice());
        }
    }

    /**
     * Calculates the price of the order.
     */
    private int calculatePrice() {
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
        if (quantity == 99) {
            Context context = getApplicationContext();
            Toast.makeText(context, "This much coffee can cause you trouble!!", Toast.LENGTH_SHORT).show();
        } else {
            quantity = quantity + 1;
            display(quantity);
            displayPrice(calculatePrice());
        }
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity == 1 && quantity < 2) {
            Context context = getApplicationContext();
            Toast.makeText(context, "You must order at least 1 cup!!", Toast.LENGTH_SHORT).show();
        } else {
            quantity = quantity - 1;
            display(quantity);
            displayPrice(calculatePrice());
        }
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