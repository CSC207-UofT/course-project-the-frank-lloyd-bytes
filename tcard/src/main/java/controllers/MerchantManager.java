package controllers;

import entities.Merchant;
import usecases.DiscountHelper;
import usecases.MerchantMap;

import java.util.ArrayList;
import java.util.List;

public class MerchantManager {
    private final MerchantMap MERCHANT_MAP;
    private final DiscountHelper DISCOUNT_HELPER;
    private final UserManager USER_MANAGER;
    // Merchant Reader

    public MerchantManager(List<List<String>> merchantsInfo, UserManager userManager) {
        MERCHANT_MAP = new MerchantMap(merchantsInfo);
        DISCOUNT_HELPER = new DiscountHelper();
        USER_MANAGER = userManager;
    }

    public List<String> checkApplicableDiscounts(String merchantName) {
        return DISCOUNT_HELPER.getApplicableDiscounts(MERCHANT_MAP.
                getMerchant(merchantName).getDiscounts(), USER_MANAGER.getUser());
    }
}
