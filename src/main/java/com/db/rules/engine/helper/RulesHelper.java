package com.db.rules.engine.helper;

import com.db.rules.engine.model.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RulesHelper {
    Logger log = LoggerFactory.getLogger(RulesHelper.class);

    public boolean applyDiscount(Data data, double discountRate) {

        double discountAmount = data.getAmount() * discountRate;
        double discountedTotal = data.getAmount() - discountAmount;
        log.info("Discounted amount: ", discountAmount);
        log.info("Total after discounted: ", discountedTotal);
        data.setAmount(discountedTotal);
        data.setDiscountAmount(discountAmount);
        data.setDiscountRate(discountRate * 100 + "%");
        return true;
    }
}
