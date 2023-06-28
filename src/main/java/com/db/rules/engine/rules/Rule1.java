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
 * Rules for Delhi
 */
@Component
@RequiredArgsConstructor
public class Rule1 implements IRule {
    Logger log = LoggerFactory.getLogger(Rule1.class);

    private final RulesHelper rulesHelper;

    /***
     *  10% for 4 wheeler
     *  20% for 3 wheeler
     *  30% for 2 wheeler
     * @param data
     * @return
     */
    @Override
    public boolean executeRule(Data data) {
        if (data != null && data.getState().name().equalsIgnoreCase(EState.DEL.name())) {

            if (data.getEVehicle().name().equals(EVehicle.FOUR_WHEELER.name())) {

                return rulesHelper.applyDiscount(data, 0.1);//10% discount

            } else if (data.getEVehicle().name().equals(EVehicle.TWO_WHEELER.name())) {

                return rulesHelper.applyDiscount(data, 0.3);//30% discount

            } else if (data.getEVehicle().name().equals(EVehicle.THREE_WHEELER.name())) {

                return rulesHelper.applyDiscount(data, 0.2);//20% discount
            }
        }
        return false;
    }


}
