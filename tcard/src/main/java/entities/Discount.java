package entities;

import androidx.annotation.NonNull;

import java.util.Arrays;
import java.util.List;

/**
 * This is a base for all discounts. Stores discount amount and criteria.
 *
 */
public class Discount {
    private final String AMOUNT;
    private final String ITEMS;
    private final String CRITERIA;

    public Discount(String discountInfo) {
        String[] discountInfoArray = discountInfo.split(":");
        this.AMOUNT = discountInfoArray[0];
        this.ITEMS = discountInfoArray[1];
        this.CRITERIA = discountInfoArray[2] + ":" + discountInfoArray[3];
    }

    public String getAmount() { return this.AMOUNT; }

    public String getItems() { return this.ITEMS; }

    public String getCriteria() { return this.CRITERIA; }

    private List<String> getItemsList(String items) {
        return Arrays.asList(items.substring(items.indexOf("(") + 1, items.indexOf(")")).
                split("/"));
    }

    private String makeItemsString() {
        String[] itemsArray = ITEMS.substring(1, ITEMS.length() - 1).split("/");

        StringBuilder itemsString = new StringBuilder(itemsArray[0]);

        if (itemsArray.length == 2) {
            itemsString.append(" and ").append(itemsArray[1]);
        } else if (itemsArray.length > 2) {
            for (String item : Arrays.copyOfRange(itemsArray, 1, itemsArray.length - 1)) {
                itemsString.append(", ").append(item);
            }
            itemsString.append(", and ").append(itemsArray[itemsArray.length - 1]);
        }
        return itemsString.toString();
    }

    @NonNull
    @Override
    public String toString() { return "-" + this.AMOUNT + "% off on " + makeItemsString() + "!"; }
}
