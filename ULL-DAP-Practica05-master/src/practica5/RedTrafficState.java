package practica5;

import static practica5.Main.wait_;

public class RedTrafficState extends TrafficState {
    public RedTrafficState(TrafficLight trafficLight) {
        super(trafficLight);
    }
    @Override
    public void doAction() throws InterruptedException {
        this.getColor();
        System.out.println();
        wait_(10);
        this.trafficLight.changeState(new YellowTrafficState(trafficLight));
    }

    @Override
    public void getColor() {
        System.out.println("red");
    }
}
