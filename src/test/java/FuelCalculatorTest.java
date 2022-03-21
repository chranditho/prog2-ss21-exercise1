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
        int expectedFuel;

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
        FuelCalculator fuelCalculator = new FuelCalculator();
        double[] masses = new double[] {12, 14, 1969, 100756};

        double requiredFuel = fuelCalculator.calculateRequiredFuelForMultiplePlanets(masses);

        assertEquals(2 + 2 + 654 + 33583, requiredFuel);
    }
}
