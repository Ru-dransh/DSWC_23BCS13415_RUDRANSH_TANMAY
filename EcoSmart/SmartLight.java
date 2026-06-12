public class SmartLight extends SmartDevice {

    public SmartLight(String deviceId, String deviceName) {
        super(deviceId, deviceName);
    }

    @Override
    public void runDiagnostic() {
        System.out.println("[SmartLight] " + deviceName + " (" + deviceId + "): Toggling light ON/OFF - OK");
    }
}