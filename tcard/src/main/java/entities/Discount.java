package entities;

import java.util.ArrayList;
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
}
