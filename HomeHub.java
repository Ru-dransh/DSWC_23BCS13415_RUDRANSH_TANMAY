public class HomeHub {

    public void executeNightlyRoutine(SmartDevice[] devices) {
        System.out.println("===== EcoSmart Nightly Diagnostic - 2:00 AM =====\n");

        for (SmartDevice device : devices) {
            device.runDiagnostic();

            if (device instanceof BatteryOperated) {
                BatteryOperated batteryDevice = (BatteryOperated) device;
                int level = batteryDevice.getBatteryLevel();
                System.out.println("  Battery level: " + level + "%");
                if (level < 20) {
                    batteryDevice.triggerRechargeAlert();
                }
            }

            System.out.println();
        }

        System.out.println("===== Routine Complete =====");
    }
}