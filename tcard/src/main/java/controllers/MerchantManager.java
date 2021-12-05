package controllers;

import usecases.DiscountHelper;
import usecases.MerchantMap;

import java.util.List;

/**
 * Controller class that controls the flow of information relating to merchants.
 */
public class MerchantManager {
    private final MerchantMap MERCHANT_MAP;
    private final DiscountHelper DISCOUNT_HELPER;
    private final UserManager USER_MANAGER;
    private final List<List<String>> MERCHANT_LIST;

    /**
     * Contructs a MerchantManager object.
     * @param merchantList a list of lists, each sublist contains the information for a single merchant represented as
     *                      strings.
     * @param userManager a UserManager object.
     */
    public MerchantManager(List<List<String>> merchantList, UserManager userManager) {
        MERCHANT_MAP = new MerchantMap(merchantList);
        DISCOUNT_HELPER = new DiscountHelper();
        USER_MANAGER = userManager;
        MERCHANT_LIST = merchantList;
    }

    /**
     * Returns the discounts offered by a given merchant that are applicable to the user associated to UserManager.
     * @param merchantName a merchants name, represented as a string.
     * @return a list of applicable discounts, each represented as a string.
     */
    public String checkApplicableDiscounts(String merchantName) {
        List<String> discountsList = DISCOUNT_HELPER.getApplicableDiscounts(MERCHANT_MAP.getMerchant(merchantName).
                getDiscounts(), USER_MANAGER.getUser());

        if (discountsList.size() == 0){
            return "You have no discounts at this merchant";
        } else {
            StringBuilder discountsString = new StringBuilder();

            for (String discount : discountsList) {
                discountsString.append(discount).append("\n");
            }
            discountsString.delete(discountsString.length() - 1, discountsString.length());

            return discountsString.toString();
        }
    }

    public List<List<String>> getMerchantList() {return MERCHANT_LIST; }
}
