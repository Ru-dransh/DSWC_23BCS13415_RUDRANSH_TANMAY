public class SmartCamera extends SmartDevice implements BatteryOperated {
    private int batteryLevel;

    public SmartCamera(String deviceId, String deviceName, int batteryLevel) {
        super(deviceId, deviceName);
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void runDiagnostic() {
        System.out.println("[SmartCamera] " + deviceName + " (" + deviceId + "): Capturing test frame - OK");
    }

    @Override
    public int getBatteryLevel() {
        return batteryLevel;
    }

    @Override
    public void triggerRechargeAlert() {
        System.out.println("  WARNING: " + deviceName + " battery critical (" + batteryLevel + "%). Please recharge!");
    }
}