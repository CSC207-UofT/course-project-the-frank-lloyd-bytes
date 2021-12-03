package controllers;

import entities.Merchant;
import usecases.DiscountHelper;
import usecases.MerchantMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller class that controls the flow of information relating to merchants.
 */
public class MerchantManager {
    private final MerchantMap MERCHANT_MAP;
    private final DiscountHelper DISCOUNT_HELPER;
    private final UserManager USER_MANAGER;
    // Merchant Reader

    /**
     * Contructs a MerchantManager object.
     * @param merchantsInfo a list of lists, each sublist contains the information for a single merchant represented as
     *                      strings.
     * @param userManager a UserManager object.
     */
    public MerchantManager(List<List<String>> merchantsInfo, UserManager userManager) {
        MERCHANT_MAP = new MerchantMap(merchantsInfo);
        DISCOUNT_HELPER = new DiscountHelper();
        USER_MANAGER = userManager;
    }

    /**
     * Returns the discounts offered by a given merchant that are applicable to the user associated to UserManager.
     * @param merchantName a merchants name, represented as a string.
     * @return a list of applicable discounts, each represented as a string.
     */
    public List<String> checkApplicableDiscounts(String merchantName) {
        return DISCOUNT_HELPER.getApplicableDiscounts(MERCHANT_MAP.
                getMerchant(merchantName).getDiscounts(), USER_MANAGER.getUser());
    }
}
