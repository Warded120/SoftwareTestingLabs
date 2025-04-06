package com.ivan.lab1;

public class HumanBmi {
    private double weight;
    private double height;

    public HumanBmi(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public String getResult() {
        double bodyWeightIndex = calculateBodyWeightIndex();
        if (bodyWeightIndex < 18.5) {
            return "Deficit";
        } else if (bodyWeightIndex >= 18.5 && bodyWeightIndex < 25) {
            return "Norm";
        } else if (bodyWeightIndex >= 25 && bodyWeightIndex < 30) {
            return "Warning!";
        } else {
            return "Fat";
        }
    }

    public double calculateBodyWeightIndex() {
        return this.weight / (this.height * this.height);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}