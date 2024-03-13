package Opgave2;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class StopWatch {

    LocalTime startTime;
    LocalTime endTime;

    public StopWatch() {

    }

    public void start() {
        this.startTime = LocalTime.now();
    }

    public void stop() {
        this.endTime = LocalTime.now();
    }

    public long elapsedTime() {
        long elipsedMinutes = ChronoUnit.SECONDS.between(startTime,endTime);
        return elipsedMinutes;
    }

}
