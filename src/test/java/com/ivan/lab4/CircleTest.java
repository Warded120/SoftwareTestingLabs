package com.ivan.lab4;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Nested
    class SetRadiusTests {
        @Test
        void should_ThrowException_when_RadiusIsLessThanOrEqualToZero() {
            // given
            Circle circle = new Circle(5.0);

            //when
            //then
            assertThrows(IllegalArgumentException.class, () -> circle.setRadius(0));
        }
    }

    @Nested
    class CalculateAreaTests {

        @Test
        void should_CalculateCorrectArea_when_ValidRadiusIsGiven() {
            // given
            Circle circle = new Circle(5.0);

            // when
            double result = circle.calculateArea();

            // then
            double expectedArea = Math.PI * 5.0 * 5.0;
            assertEquals(expectedArea, result, 0.0001);
        }
    }

    @Nested
    class CalculateCircumferenceTests {

        @Test
        void should_CalculateCorrectCircumference_when_ValidRadiusIsGiven() {
            // given
            Circle circle = new Circle(5.0);

            // when
            double result = circle.calculateCircumference();

            // then
            double expectedCircumference = 2 * Math.PI * 5.0;
            assertEquals(expectedCircumference, result, 0.0001);
        }
    }

    @Nested
    class IsUnitCircleTests {

        @Test
        void should_ReturnTrue_when_CircleIsUnitCircle() {
            // given
            Circle unitCircle = new Circle(1.0);

            // when
            boolean result = unitCircle.isUnitCircle();

            // then
            assertTrue(result);
        }

        @Test
        void should_ReturnFalse_when_CircleIsNotUnitCircle() {
            // given
            Circle circle = new Circle(5.0);

            // when
            boolean result = circle.isUnitCircle();

            // then
            assertFalse(result);
        }
    }

    @Nested
    class CanFitInsideTests {

        @Test
        void should_ReturnTrue_when_CircleCanFitInsideAnotherCircle() {
            // given
            Circle smallCircle = new Circle(3.0);
            Circle largeCircle = new Circle(5.0);

            // when
            boolean result = smallCircle.canFitInside(largeCircle);

            // then
            assertTrue(result);
        }

        @Test
        void should_ReturnFalse_when_CircleCannotFitInsideAnotherCircle() {
            // given
            Circle smallCircle = new Circle(6.0);
            Circle largeCircle = new Circle(5.0);

            // when
            boolean result = smallCircle.canFitInside(largeCircle);

            // then
            assertFalse(result);
        }
    }
}