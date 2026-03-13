import java.util.Random;

public class ThermalSensor implements Sensor {

    private Random random = new Random();

    @Override
    public String readData() {

        int temperature = 34 + random.nextInt(6);

        if (temperature >= 37) {
            return "Sensor térmico: posible sobreviviente detectado (" + temperature + "°C)";
        } else {
            return "Sensor térmico: solo calor ambiental detectado (" + temperature + "°C)";
        }

    }
}
