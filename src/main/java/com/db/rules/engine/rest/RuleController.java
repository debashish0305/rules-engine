package com.db.rules.engine.rest;

import com.db.rules.engine.model.Data;
import com.db.rules.engine.rules.IRule;
import com.db.rules.engine.rules.Rule1;
import com.db.rules.engine.rules.Rule2;
import com.db.rules.engine.rules.Rule3;
import com.db.rules.engine.service.RuleEngine;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rules")
public class RuleController {


    private final Rule1 rule1;
    private final Rule2 rule2;
    private final Rule3 rule3;

    @PostMapping
    public Mono<String> processRule(@RequestBody Data data) {
        List<IRule> rules = List.of(rule1, rule2, rule3); // Create a list of rules
        RuleEngine ruleEngine = new RuleEngine(rules); // Create the rule engine
        ruleEngine.process(data); // Execute the rules against the input data
        return Mono.just(data.getMessage());
    }

    @GetMapping("/fetch")
    public Mono<String> getRule() {
        return Mono.just("Rules Engine Running..");

    }
}
