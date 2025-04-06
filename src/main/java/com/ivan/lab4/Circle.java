package com.ivan.lab4;

import lombok.Getter;

public class Circle {
    @Getter
    private double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be greater than 0.");
        }
        this.radius = radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be greater than 0.");
        }
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    public boolean isUnitCircle() {
        return radius == 1;
    }

    public boolean canFitInside(Circle otherCircle) {
        return this.radius <= otherCircle.getRadius();
    }
}
