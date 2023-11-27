package com.cdtm.bioboost.productgoal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ProductGoalId implements Serializable {

    @Column(name = "goalID")
    private Long goalId;

    @Column(name = "productID")
    private Long productId;

    public Long getGoalId() {
        return goalId;
    }

    public void setGoalId(Long goalId) {
        this.goalId = goalId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
