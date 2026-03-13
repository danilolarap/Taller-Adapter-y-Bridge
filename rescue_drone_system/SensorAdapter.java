public class SensorAdapter implements Sensor {

    private LegacyThermalSensor legacySensor;

    public SensorAdapter(LegacyThermalSensor sensor) {
        this.legacySensor = sensor;
    }

    public String readData() {
        return legacySensor.getTemperature();
    }
}
