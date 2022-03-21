public class FuelCalculator {

    public double calculateRequiredFuel(double mass) {
        return Math.floor(mass / 3) - 2;
    }

    public double calculateRequiredFuelForMultiplePlanets(double[] masses) {
        double fuel = 0;
        for (double mass : masses) {
            fuel += calculateRequiredFuel(mass);
        }
        return fuel;
    }
}
