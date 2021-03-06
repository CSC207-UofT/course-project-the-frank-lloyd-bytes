package usecases;

import entities.Merchant;
import java.util.HashMap;
import java.util.List;

/**
 * Use case that maps names of merchants to their respective Merchant objects.
 */
public class MerchantMap {
    private final HashMap<String, Merchant> MERCHANT_MAP = new HashMap<>();

    /**
     * Constructs a MerchantMap object.
     * @param merchantList a list of lists, each sublist contains the information for a single merchant represented as
     *                     strings.
     */
    public MerchantMap(List<List<String>> merchantList){
        for (List<String> merchantInfo : merchantList) {
            Merchant merchant = new Merchant(merchantInfo);
            MERCHANT_MAP.put(merchant.getName(), merchant);
        }
    }

    /**
     * Get a Merchant object from the merchant map by indexing the merchant's name.
     * @param name a merchant name presented as a string.
     * @return a Merchant object.
     */
    public Merchant getMerchant(String name){
        return MERCHANT_MAP.get(name);
    }
}
