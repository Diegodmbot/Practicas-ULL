package practica5;

public abstract class TrafficState {
    protected TrafficLight trafficLight;
    public TrafficState(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }
    public abstract void doAction() throws InterruptedException;
    public abstract void getColor();
}
