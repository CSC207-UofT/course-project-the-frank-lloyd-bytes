package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a base for all merchant classes. Stores basic merchant information.
 *
 */
public class Merchant {
    // attribute for each piece of info, private, make getters
    private final String NAME;
    private final String ADDRESS;
    private final String HOURS;
    private final List<Discount> DISCOUNTS = new ArrayList<Discount>();

    public Merchant(List<String> merchantInfo) {
        // marchantInfo = [name, address, hours,
        // amnt:(item1/...):(stud_yr/...),(stud_prog/...):(fac_yr/...),(fac_dep/...)|...)
        this.NAME = merchantInfo.get(0);
        this.ADDRESS = merchantInfo.get(1);
        this.HOURS = merchantInfo.get(2);

        String[] discountsInfo = merchantInfo.get(3).split("\\|");
        for (String info : discountsInfo) {
            Discount discount = new Discount(info);
            DISCOUNTS.add(discount);
        }
    }

    public String getName() { return this.NAME; }

    public String getAddress() { return this.ADDRESS; }

    public String getHours() { return this.HOURS; }

    public List<Discount> getDiscounts() { return this.DISCOUNTS; }
}
