import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DroneUI extends JFrame {

    private JTextArea output;
    private JComboBox<String> droneType;
    private JComboBox<String> controlType;

    public DroneUI() {

        setTitle("Sistema de Drones de Rescate");
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Color gray = new Color(45,45,45);
        Color blue = new Color(70,130,180);

        JPanel topPanel = new JPanel();
        topPanel.setBackground(gray);

        droneType = new JComboBox<>(new String[]{"Vigilancia","Entrega"});
        controlType = new JComboBox<>(new String[]{"Manual","IA"});

        JButton launchButton = new JButton("Desplegar Drone");
        launchButton.setBackground(blue);
        launchButton.setForeground(Color.white);

        JButton sensorButton = new JButton("Escanear Sensores");
        sensorButton.setBackground(blue);
        sensorButton.setForeground(Color.white);

        topPanel.add(new JLabel("Tipo Drone"));
        topPanel.add(droneType);

        topPanel.add(new JLabel("Control"));
        topPanel.add(controlType);

        topPanel.add(launchButton);
        topPanel.add(sensorButton);

        add(topPanel,BorderLayout.NORTH);

        output = new JTextArea();
        output.setBackground(new Color(30,30,30));
        output.setForeground(Color.white);

        add(new JScrollPane(output),BorderLayout.CENTER);

        launchButton.addActionListener(e -> launchDrone());
        sensorButton.addActionListener(e -> scanSensors());
    }

    private void launchDrone() {

        ControlSystem control;

        if(controlType.getSelectedItem().equals("Manual"))
            control = new ManualControl();
        else
            control = new AIControl();

        Drone drone;

        if(droneType.getSelectedItem().equals("Vigilancia"))
            drone = new SurveillanceDrone(control);
        else
            drone = new DeliveryDrone(control);

        output.append("\n" + drone.operate() + "\n");
    }

    private void scanSensors() {

        Sensor gps = new GPSSensor();

        LegacyThermalSensor legacy = new LegacyThermalSensor();
        Sensor thermal = new SensorAdapter(legacy);

        output.append("\nEscaneo de sensores:\n");
        output.append(gps.readData() + "\n");
        output.append(thermal.readData() + "\n");
    }
}
