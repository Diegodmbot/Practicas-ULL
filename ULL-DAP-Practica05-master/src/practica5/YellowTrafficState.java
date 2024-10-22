package practica5;

import static practica5.Main.wait_;

public class YellowTrafficState extends TrafficState {
    public YellowTrafficState(TrafficLight trafficLight) {
        super(trafficLight);
    }

    @Override
    public void doAction() throws InterruptedException {
        this.getColor();
        System.out.println();
        wait_(3);
        this.trafficLight.changeState(new GreenTrafficState(trafficLight));
    }
    @Override
    public void getColor() {
        System.out.println("yellow");
    }
}
