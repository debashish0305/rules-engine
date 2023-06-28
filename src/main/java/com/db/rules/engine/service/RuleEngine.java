package com.db.rules.engine.service;

import com.db.rules.engine.model.Data;
import com.db.rules.engine.rules.IRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


@lombok.Data
public class RuleEngine {
    Logger log = LoggerFactory.getLogger(RuleEngine.class);
    private final List<IRule> rules;

    public RuleEngine(List<IRule> rules) {
        this.rules = rules;
    }
    public void process(Data data) {
        for (IRule rule : rules) {
            if (rule.executeRule(data)) {
                // call any task or invoke a method
                log.info("Vehicle price:{}", data.getAmount());
                log.info("Customer got {}% discount{}", data.getDiscountAmount());
                data.setMessage("Final price of the vehicle in " + data.getCity() + " is " + data.getAmount() + ", with discount rate of " + data.getDiscountRate());
            }
        }
    }
}
