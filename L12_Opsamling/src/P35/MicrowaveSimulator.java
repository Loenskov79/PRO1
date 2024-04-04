package P35;

public class MicrowaveSimulator {

    public static void main(String[] args) {
        Microwave m1 = new Microwave();
        m1.start();
        m1.addTime(60);
        m1.setPowerLevel(2);
        m1.start();
        m1.reset();
    }

}
