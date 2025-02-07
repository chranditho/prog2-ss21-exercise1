public class FuelCalculator {

    private double[] masses = new double[] {62371, 94458, 78824, 57296, 84226, 133256, 101771, 61857, 120186, 132234,
            50964, 97800, 81275, 109561, 145666, 134029, 81625, 61963, 83820, 104210, 62264, 146376, 91889, 116069,
            54596, 132877, 70341, 89983, 84627, 51617, 84846, 114416, 132268, 136516, 104082, 133669, 86585, 96389,
            111737, 51954, 132971, 84097, 66260, 133883, 84720, 51985, 61024, 55912, 125334, 69541, 58806, 56014,
            62563, 80799, 67284, 93971, 147238, 114830, 61376, 65096, 73498, 54792, 88590, 63225, 129226, 67872,
            55563, 110467, 91120, 100281, 148236, 121886, 75671, 124736, 90588, 52175, 140673, 71029, 73865, 142021,
            140326, 77894, 61245, 96492, 136329, 132967, 83975, 53082, 56784, 50024, 131154, 138517, 130787, 103334,
            104287, 140644, 148945, 58945, 62153, 93488};

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

    public static void main(String[] args) {
        FuelCalculator fuelCalculator = new FuelCalculator();
        double fuel = fuelCalculator.calculateRequiredFuelForMultiplePlanets(fuelCalculator.masses);
        System.out.println("fuel = " + fuel);

        System.out.println();

        double totalFuel = fuelCalculator.calculateTotalFuelForMultiplePlanets(fuelCalculator.masses);
        System.out.println("total fuel = " + totalFuel);
    }

    public double calculateFuelForFuel(double totalFuel, double mass) {
        double requiredFuelForFuel = calculateRequiredFuel(mass);
        if (requiredFuelForFuel > 0) {
            totalFuel += requiredFuelForFuel;
            return calculateFuelForFuel(totalFuel, requiredFuelForFuel);
        }
        return totalFuel;
    }

    public double calculateTotalFuelForMultiplePlanets(double[] masses) {
        double fuel = 0;
        for (double mass : masses) {
            fuel += calculateFuelForFuel(0, mass);
        }
        return fuel;
    }
}
