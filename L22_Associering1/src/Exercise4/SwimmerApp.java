package Exercise4;

import java.util.ArrayList;

public class SwimmerApp {
    
    public static void main(String[] args) {

        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(1.02);
        lapTimes.add(1.01);
        lapTimes.add(0.99);
        lapTimes.add(0.98);
        lapTimes.add(1.02);
        lapTimes.add(1.04);
        lapTimes.add(0.99);
        Swimmer s1 = new Swimmer("Jan", 1994, lapTimes, "AGF");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.05);
        lapTimes.add(1.01);
        lapTimes.add(1.04);
        lapTimes.add(1.06);
        lapTimes.add(1.08);
        lapTimes.add(1.04);
        lapTimes.add(1.02);
        Swimmer s2 = new Swimmer("Bo", 1995, lapTimes, "Lyseng");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.03);
        lapTimes.add(1.01);
        lapTimes.add(1.02);
        lapTimes.add(1.05);
        lapTimes.add(1.03);
        lapTimes.add(1.06);
        lapTimes.add(1.03);
        Swimmer s3 = new Swimmer("Mikkel", 1993, lapTimes, "AIA-Tranbjerg");
        
        ArrayList<Swimmer> swimmers = new ArrayList<>();
        swimmers.add(s1);
        swimmers.add(s2);
        swimmers.add(s3);

        for (Swimmer s : swimmers) {
            System.out.println(s.getName() + "'s bedste tid: " + s.bestLapTime());
        }

        TrainingPlan t1 = new TrainingPlan('A', 16, 12);
        Swimmer Martin = t1.createSwimmer("Martin", 2003, lapTimes, "KSDH");
        Swimmer Mads = t1.createSwimmer("Mads", 2002, lapTimes, "AGF");

        for (Swimmer s: t1.getSwimmers()) {
            System.out.println("The swimmers on the trainingplan t1 are: " + s.getName() + " who are swimming for: " + s.getClub());
        }

        t1.removeSwimmer(Martin);

        for (Swimmer s: t1.getSwimmers()) {
            System.out.println("The swimmers on the trainingplan t1 are: " + s.getName() + " who are swimming for: " + s.getClub());
        }
    }
    
}
