public abstract class Drone {

    protected ControlSystem controlSystem;

    public Drone(ControlSystem controlSystem) {
        this.controlSystem = controlSystem;
    }

    public abstract String operate();
}
