public class Main {
    public static void main(String[] args) {
        SmartDevice[] devices = {
            new SmartLight("SL-01", "Living Room Light"),
            new SmartCamera("SC-01", "Front Door Camera", 45),
            new SmartCamera("SC-02", "Backyard Camera", 12),
            new SmartLock("LK-01", "Front Door Lock", 85),
            new SmartLock("LK-02", "Garage Lock", 8)
        };

        HomeHub hub = new HomeHub();
        hub.executeNightlyRoutine(devices);
    }
}