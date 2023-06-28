package com.db.rules.engine.rules;

import com.db.rules.engine.model.Data;

public interface IRule {
    boolean executeRule(Data data);
}
