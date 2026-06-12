public class FleetManager {

    public static void main(String[] args) {

        // 1D array of SpaceVessel objects — polymorphic fleet
        SpaceVessel[] fleet = new SpaceVessel[3];

        // Ship 1 — Class A, 3 bays, 4 containers each
        MiningShip ship1 = new MiningShip(
            (short) 1001, true, 'A', "Orion Vanguard", (byte) 3, (byte) 4
        );
        ship1.loadCargo((byte) 0, (byte) 0, 12500.50f);
        ship1.loadCargo((byte) 0, (byte) 1, 9800.00f);
        ship1.loadCargo((byte) 1, (byte) 0, 47999.99f);  // heaviest
        ship1.loadCargo((byte) 1, (byte) 2, 31000.75f);
        ship1.loadCargo((byte) 2, (byte) 3, 22400.00f);

        // Ship 2 — Class B, 2 bays, 3 containers each
        MiningShip ship2 = new MiningShip(
            (short) 1002, true, 'B', "Nebula Drifter", (byte) 2, (byte) 3
        );
        ship2.loadCargo((byte) 0, (byte) 0, 18000.00f);
        ship2.loadCargo((byte) 0, (byte) 1, 27500.50f);
        ship2.loadCargo((byte) 1, (byte) 2, 5000.25f);

        // Ship 3 — Class C, 2 bays, 2 containers each — offline
        MiningShip ship3 = new MiningShip(
            (short) 1003, false, 'C', "Dust Crawler", (byte) 2, (byte) 2
        );
        ship3.loadCargo((byte) 0, (byte) 0, 3200.00f);
        ship3.loadCargo((byte) 1, (byte) 1, 8750.00f);

        fleet[0] = ship1;
        fleet[1] = ship2;
        fleet[2] = ship3;

        // Run fleet report
        System.out.println("========== ORION MINING CONSORTIUM — FLEET REPORT ==========");
        long totalFleetValue = 0L;

        for (SpaceVessel vessel : fleet) {
            if (vessel instanceof MiningShip) {
                MiningShip ship = (MiningShip) vessel;
                ship.printStatus();

                // Assume 1 credit per kg for fleet value calculation
                totalFleetValue += (long) ship.calculateTotalOreWeight();
            }
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Total fleet ore value: " + totalFleetValue + " credits");
        System.out.println("=============================================================");
    }
}