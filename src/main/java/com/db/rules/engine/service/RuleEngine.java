package com.db.rules.engine.service;

import com.db.rules.engine.model.Data;
import com.db.rules.engine.rules.IRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RuleEngine {
    Logger LOG = LoggerFactory.getLogger(RuleEngine.class);
    private List<IRule> rules;

    public RuleEngine(List<IRule> rules) {
        this.rules = rules;
    }

    public void process(Data data) {
        for (IRule rule : rules) {
            if (rule.executeRule(data)) {
                // Take action based on the rule evaluation
                // Example: Execute a specific task or invoke a method
                LOG.info("Vehicle price:{}", data.getAmount());
                LOG.info("Customer got {}% discount{}", data.getDiscountAmount());
                data.setMessage("Final price of the vehicle in " + data.getCity() + " is " + data.getAmount() + ", with discount rate of " + data.getDiscountRate());
            }
        }
    }
}
