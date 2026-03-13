public class DeliveryDrone extends Drone {

    public DeliveryDrone(ControlSystem controlSystem) {
        super(controlSystem);
    }

    public String operate() {
        return "Drone de rescate con suministro médico.\n" + controlSystem.control();
    }
}
