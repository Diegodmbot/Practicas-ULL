package practica5;

import static practica5.Main.wait_;

public class GreenTrafficState extends TrafficState {
    public GreenTrafficState(TrafficLight trafficLight) {
        super(trafficLight);
    }

    @Override
    public void doAction() throws InterruptedException {
        this.getColor();
        this.getSound();
        System.out.println();
        wait_(7);
        this.trafficLight.changeState(new GreenBlinkingTrafficState(trafficLight));
    }
    @Override
    public void getColor() {
        System.out.println("green");
    }
    public void getSound() {
        System.out.println("beep");
    }
}
