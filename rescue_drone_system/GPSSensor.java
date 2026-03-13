import java.util.Random;

public class GPSSensor implements Sensor {

    public String readData() {
        Random r = new Random();
        int x = r.nextInt(100);
        int y = r.nextInt(100);

        return "GPS detecta coordenadas: (" + x + "," + y + ")";
    }
}
