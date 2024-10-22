package practica5;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TrafficLight trafficLight = new TrafficLight();
        trafficLight.doAction();
    }
    static void wait_(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000L);
    }
}