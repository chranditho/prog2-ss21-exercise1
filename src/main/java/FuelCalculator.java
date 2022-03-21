public class FuelCalculator {

    public double calculateRequiredFuel(double mass) {
        return Math.floor(mass / 3) - 2;
    }

}
