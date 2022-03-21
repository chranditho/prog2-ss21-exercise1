import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FuelCalculatorTest {

    @Test
    void calculateFuelForMassEqualsTwelve() {
        FuelCalculator fuelCalculator = new FuelCalculator();
        double mass = 12;

        double requiredFuel = fuelCalculator.calculateRequiredFuel(mass);

        assertEquals(2, requiredFuel);
    }

    @Test
    void calculateFuelForMassEqualsFourteen() {
        FuelCalculator fuelCalculator = new FuelCalculator();
        double mass = 14;

        double requiredFuel = fuelCalculator.calculateRequiredFuel(mass);

        assertEquals(2, requiredFuel);
    }

    @Test
    void calculateFuelForMassEquals1969() {
        FuelCalculator fuelCalculator = new FuelCalculator();
        double mass = 1969;

        double requiredFuel = fuelCalculator.calculateRequiredFuel(mass);

        assertEquals(654, requiredFuel);
    }

    @Test
    void calculateFuelForMassEquals100756() {
        FuelCalculator fuelCalculator = new FuelCalculator();
        double mass = 100756;

        double requiredFuel = fuelCalculator.calculateRequiredFuel(mass);

        assertEquals(33583, requiredFuel);
    }
}
