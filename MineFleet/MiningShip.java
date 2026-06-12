public class MiningShip extends SpaceVessel {

    private String shipName;
    private float[][] cargoHold;  // [bays][containers] — float saves 4 bytes per cell vs double

    public MiningShip(short shipId, boolean isOperational, char fleetClass,
                      String shipName, byte numBays, byte containersPerBay) {
        super(shipId, isOperational, fleetClass);
        this.shipName = shipName;
        this.cargoHold = new float[numBays][containersPerBay];
    }

    public void loadCargo(byte bay, byte container, float weight) {
        cargoHold[bay][container] = weight;
    }

    public float calculateTotalOreWeight() {
        float total = 0f;
        for (float[] bay : cargoHold) {
            for (float container : bay) {
                total += container;
            }
        }
        return total;
    }

    public float findHeaviestContainer() {
        float heaviest = 0f;
        for (float[] bay : cargoHold) {
            for (float container : bay) {
                if (container > heaviest) {
                    heaviest = container;
                }
            }
        }
        return heaviest;
    }

    public void printStatus() {
        System.out.println("--------------------------------------------------");
        System.out.println("Ship      : " + shipName + " (ID: " + shipId + ")");
        System.out.println("Class     : " + fleetClass);
        System.out.println("Status    : " + (isOperational ? "Active Mining" : "Offline"));
        System.out.printf ("Total ore : %.2f kg%n", calculateTotalOreWeight());
        System.out.printf ("Heaviest  : %.2f kg%n", findHeaviestContainer());
    }
}