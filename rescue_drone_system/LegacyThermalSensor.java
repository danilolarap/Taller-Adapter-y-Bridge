import java.util.Random;

public class LegacyThermalSensor {

    public String getTemperature() {
        Random r = new Random();
        int temp = 30 + r.nextInt(10);

        return "Sensor térmico detecta temperatura corporal: " + temp + "°C";
    }
}
