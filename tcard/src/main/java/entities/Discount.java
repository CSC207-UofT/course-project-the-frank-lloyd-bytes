package entities;

import androidx.annotation.NonNull;

import java.util.Arrays;

/**
 * This is a base for all discount classes. Stores a discount amount, the items that are discounted, and criteria for
 * the discount to be applied.
 *
 */
public class Discount {
    private final String AMOUNT;
    private final String ITEMS;
    private final String CRITERIA;

    /**
     * Constructs a Discount object.
     *
     * @param discountInfo A string containing information for a discount.
     */
    public Discount(String discountInfo) {
        String[] discountInfoArray = discountInfo.split(":");
        this.AMOUNT = discountInfoArray[0];
        this.ITEMS = discountInfoArray[1];
        this.CRITERIA = discountInfoArray[2] + ":" + discountInfoArray[3];
    }

    /**
     * Getter for a discounts criteria.
     *
     * @return a discounts criteria, represented as a string.
     */
    public String getCriteria() {
        return this.CRITERIA;
    }

    /**
     * Helper method to represent a discounts items as a string.
     *
     * @return a string listing a discounts items in a sentence.
     */
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

    /**
     * Returns a string representation of a discount. Example output: "-10% off on textbooks and pencils!".
     *
     * @return a string describing a discounts information in a sentence.
     */
    @NonNull
    @Override
    public String toString() {
        return "-" + this.AMOUNT + "% off on " + makeItemsString() + "!";
    }
}

