package com.cdtm.bioboost.productgoal.model;

import com.cdtm.bioboost.goal.model.Goal;
import com.cdtm.bioboost.product.model.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ProductGoalDto {

    private Goal goal;

    private Product product;

    @Column(name = "weight", nullable = false)
    private float weight;

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
