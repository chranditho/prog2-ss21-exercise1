import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FuelCalculatorTest {

    FuelCalculator fuelCalculator = new FuelCalculator();

    private double[] santasMasses = new double[] {62371, 94458, 78824, 57296, 84226, 133256, 101771, 61857, 120186, 132234,
            50964, 97800, 81275, 109561, 145666, 134029, 81625, 61963, 83820, 104210, 62264, 146376, 91889, 116069,
            54596, 132877, 70341, 89983, 84627, 51617, 84846, 114416, 132268, 136516, 104082, 133669, 86585, 96389,
            111737, 51954, 132971, 84097, 66260, 133883, 84720, 51985, 61024, 55912, 125334, 69541, 58806, 56014,
            62563, 80799, 67284, 93971, 147238, 114830, 61376, 65096, 73498, 54792, 88590, 63225, 129226, 67872,
            55563, 110467, 91120, 100281, 148236, 121886, 75671, 124736, 90588, 52175, 140673, 71029, 73865, 142021,
            140326, 77894, 61245, 96492, 136329, 132967, 83975, 53082, 56784, 50024, 131154, 138517, 130787, 103334,
            104287, 140644, 148945, 58945, 62153, 93488};


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
