package com.db.rules.engine.model;

import com.db.rules.engine.utils.EGender;
import com.db.rules.engine.utils.EState;
import com.db.rules.engine.utils.EVehicle;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Data {
    String city;
    EVehicle eVehicle;
    double amount;
    EGender gender;
   // @JsonIgnore
    double discountAmount;
    String discountRate;
    EState state;
    String message;
}
