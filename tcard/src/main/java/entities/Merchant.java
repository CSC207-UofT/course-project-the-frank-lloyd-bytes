package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a base for all merchant classes. Stores basic merchant information.
 *
 */
public class Merchant {
    private final String NAME;
    private final String ADDRESS;
    private final String HOURS;
    private final List<Discount> DISCOUNTS = new ArrayList<>();

    /**
     * Constructs a Merchant object.
     * @param merchantInfo a list of strings containing merchant information.
     */
    public Merchant(List<String> merchantInfo) {
        this.NAME = merchantInfo.get(0);
        this.ADDRESS = merchantInfo.get(1);
        this.HOURS = merchantInfo.get(2);

        String[] discountsInfo = merchantInfo.get(3).split("\\|");
        for (String info : discountsInfo) {
            Discount discount = new Discount(info);
            DISCOUNTS.add(discount);
        }
    }

    /**
     * Getter for a merchants name.
     * @return a merchants name, represented as a string.
     */
    public String getName() { return this.NAME; }

    /**
     * Getter for a merchants address.
     * @return a merchants address, represented as a string.
     */
    public String getAddress() { return this.ADDRESS; }

    /**
     * Getter for a merchants hours.
     * @return a merchants hours, represented as a string.
     */
    public String getHours() { return this.HOURS; }

    /**
     * Getter for a merchants discounts.
     * @return a list of strings, each string representing a merchant discount.
     */
    public List<Discount> getDiscounts() { return this.DISCOUNTS; }
}
