import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FuelCalculatorTest {

    FuelCalculator fuelCalculator = new FuelCalculator();

    @ParameterizedTest
    @ValueSource(doubles = {12, 14, 1969, 100756})
    void calculateRequiredFuelForOnePlanet(double mass) {
        double requiredFuel = fuelCalculator.calculateRequiredFuel(mass);
        double expectedFuel;

        if (mass == 12 || mass == 14) {
            expectedFuel = 2;
        } else if (mass == 1969) {
            expectedFuel = 654;
        } else if (mass == 100756) {
            expectedFuel = 33583;
        } else {
            expectedFuel = 0;
        }

        assertEquals(expectedFuel, requiredFuel,
                "The expected fuel consumption for a mass of " + mass + " Newton is " + expectedFuel + " liters");
    }

    @Test
    void calculateFuelForSeveralPlanets() {
        double[] masses = new double[] {12, 14, 1969, 100756};

        double requiredFuel = fuelCalculator.calculateRequiredFuelForMultiplePlanets(masses);

        assertEquals(2 + 2 + 654 + 33583, requiredFuel);
    }

    @ParameterizedTest
    @ValueSource(doubles = {14, 1969})
    void ensureEnoughFuelForTheFuelIsProvided(double mass) {
        double requiredTotalFuel = fuelCalculator.calculateFuelForFuel(0, mass);
        if (mass == 14) {
            assertEquals(2, requiredTotalFuel);
        } else if (mass == 1969) {
            assertEquals(966, requiredTotalFuel);
        }
    }

    @Test
    void calculateTotalFuelForSeveralPlanets() {
        double[] masses = new double[]{14, 1969};

        double totalFuel = fuelCalculator.calculateTotalFuelForMultiplePlanets(masses);

        assertEquals(2 + 966, totalFuel);
    }
}
