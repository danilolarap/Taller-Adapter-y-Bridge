public class SurveillanceDrone extends Drone {

    public SurveillanceDrone(ControlSystem controlSystem) {
        super(controlSystem);
    }

    public String operate() {
        return "Drone de vigilancia desplegado.\n" + controlSystem.control();
    }
}
