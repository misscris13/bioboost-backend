package com.cdtm.bioboost.productgoal.model;

import com.cdtm.bioboost.goal.model.Goal;
import com.cdtm.bioboost.product.ProductService;
import com.cdtm.bioboost.product.model.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "productgoal")
public class ProductGoal {

    @EmbeddedId
    private ProductGoalId id;

    @ManyToOne
    @JoinColumn(name = "goalId")
    private Goal goal;

    @ManyToOne
    @JoinColumn(name = "productId")
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
