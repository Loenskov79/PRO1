package P35;

public class Microwave {

    private int time;
    private int powerLevel;

    public Microwave() {
        this.time = 0;
        this.powerLevel = 1;
    }

    public void addTime (int time) {
        this.time += time;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    public void reset() {
        this.time = 0;
        this.powerLevel = 1;
        System.out.println("Stopping... " + time + " seconds remaning, and at level " + powerLevel);
    }

    public void start() {
        System.out.println("Cooking for " + time + " seconds, at level " + powerLevel);
    }
}
