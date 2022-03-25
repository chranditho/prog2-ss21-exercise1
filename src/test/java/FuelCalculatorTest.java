import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * This class only tests the functionalities, the required calculations are made in the main method of the
 * FuelCalculator class.
 * link to the repository: https://github.com/chranditho/prog2-ss21-exercise1
 */
public class FuelCalculatorTest {

    FuelCalculator fuelCalculator = new FuelCalculator();

    @Test
    void calculateRequiredFuelForOnePlanet_szenario1() {
        double actual = fuelCalculator.calculateRequiredFuel(12);
        double expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void calculateRequiredFuelForOnePlanet_szenario2() {
        double actual = fuelCalculator.calculateRequiredFuel(14);
        double expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void calculateRequiredFuelForOnePlanet_szenario3() {
        double actual = fuelCalculator.calculateRequiredFuel(1969);
        double expected = 654;
        assertEquals(expected, actual);
    }

    @Test
    void calculateRequiredFuelForOnePlanet_szenario4() {
        double actual = fuelCalculator.calculateRequiredFuel(100756);
        double expected = 33583;
        assertEquals(expected, actual);
    }

    @Test
    void calculateFuelForSeveralPlanets() {
        double[] masses = new double[] {12, 14, 1969, 100756};
        double actual = fuelCalculator.calculateRequiredFuelForMultiplePlanets(masses);
        assertEquals(2 + 2 + 654 + 33583, actual);
    }

    @Test
    void ensureEnoughFuelForTheFuelIsProvided_szenario1() {
        double actual = fuelCalculator.calculateFuelForFuel(0, 14);
        assertEquals(2, actual);
    }

    @Test
    void ensureEnoughFuelForTheFuelIsProvided_szenario2() {
        double actual = fuelCalculator.calculateFuelForFuel(0, 1969);
        assertEquals(966, actual);
    }

    @Test
    void calculateTotalFuelForSeveralPlanets() {
        double[] masses = new double[] {14, 1969};
        double actual = fuelCalculator.calculateTotalFuelForMultiplePlanets(masses);
        assertEquals(2 + 966, actual);
    }
}
