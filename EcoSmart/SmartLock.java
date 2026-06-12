public class SmartLock extends SmartDevice implements BatteryOperated {
    private int batteryLevel;

    public SmartLock(String deviceId, String deviceName, int batteryLevel) {
        super(deviceId, deviceName);
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void runDiagnostic() {
        System.out.println("[SmartLock] " + deviceName + " (" + deviceId + "): Cycling lock/unlock - OK");
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