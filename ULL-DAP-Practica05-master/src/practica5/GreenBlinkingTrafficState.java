package practica5;

public class GreenBlinkingTrafficState extends TrafficState {
    public GreenBlinkingTrafficState(TrafficLight trafficLight) {
        super(trafficLight);
    }

    @Override
    public void doAction() throws InterruptedException {
        this.getColor();
        this.getSound();
        System.out.println();
        Main.wait_(3);
        this.trafficLight.changeState(new RedTrafficState(trafficLight));
    }
    @Override
    public void getColor() {
        System.out.println("green blinking");
    }
    public void getSound() {
        System.out.println("beep harder");
    }
}
