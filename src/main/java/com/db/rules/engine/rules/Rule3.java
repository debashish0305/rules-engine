package com.db.rules.engine.rules;

import com.db.rules.engine.helper.RulesHelper;
import com.db.rules.engine.model.Data;
import com.db.rules.engine.utils.EState;
import com.db.rules.engine.utils.EVehicle;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Rules for Tamilnadu
 */
@RequiredArgsConstructor
@Component
public class Rule3 implements IRule {
    Logger log = LoggerFactory.getLogger(Rule3.class);

    private final RulesHelper rulesHelper;

    /***
     *  15% for 4 wheeler
     *  25% for 3 wheeler
     *  45% for 2 wheeler
     * @param data
     * @return
     */
    @Override
    public boolean executeRule(Data data) {
        if (data != null && data.getState().name().equalsIgnoreCase(EState.TN.name())) {

            if (data.getEVehicle().name().equals(EVehicle.FOUR_WHEELER.name())) {

                return rulesHelper.applyDiscount(data, 0.15);//15% discount

            } else if (data.getEVehicle().name().equals(EVehicle.TWO_WHEELER.name())) {

                return rulesHelper.applyDiscount(data, 0.45);//45% discount

            } else if (data.getEVehicle().name().equals(EVehicle.THREE_WHEELER.name())) {

                return rulesHelper.applyDiscount(data, 0.25);//25% discount
            }
        }
        return false;
    }
}
