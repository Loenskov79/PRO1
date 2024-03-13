import java.util.Map;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.HashMap;

public class Gym {
    private final int totalGymMembers;
    private Map<MachineType, Integer> availableMachines;

    public Gym(int totalGymMembers, Map<MachineType, Integer> availableMachines) {
        this.totalGymMembers = totalGymMembers;
        this.availableMachines = availableMachines;
    }

    public void openForTheDay() {
        List<Thread> gymMembersRoutines;
        gymMembersRoutines = IntStream.rangeClosed(1, this.totalGymMembers).mapToObj((id) -> {
            Member member = new Member(id);
            return new Thread(() -> {
                try {
                    member.performRoutine();
                } catch (Exception e) {
                    System.out.println("An error occurred while performing routine for member.");
                }
            });
        }).collect(Collectors.toList());
        Thread supervisor = createSupervisor(gymMembersRoutines);
        gymMembersRoutines.forEach(Thread::start);
        supervisor.start();
    }

    private Thread createSupervisor(List<Thread> threads) {
        Thread supervisor = new Thread(() -> {
            while (true) {
                List<String> runningThreads = threads.stream().filter(Thread::isAlive).map(Thread::getName).collect(Collectors.toList());
                System.out.println(Thread.currentThread().getName() + " - " + runningThreads.size() + " members currently exercising: " + runningThreads + "\n");
                if (runningThreads.size() == 0) {
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            System.out.println(Thread.currentThread().getName() + " - All threads have completed.");
        });
        supervisor.setName("Gym Staff");
        return supervisor;
    }

    public static void main(String[] args) {
        Gym fitnessUnited = new Gym(5, new HashMap<>() {
            {
                put(MachineType.LEGPRESSMACHINE, 5);
                put(MachineType.BARBELL, 5);
                put(MachineType.SQUATMACHINE, 5);
                put(MachineType.LEGEXTENSIONMACHINE, 5);
                put(MachineType.LEGCURLMACHINE, 5);
                put(MachineType.LATPULLDOWNMACHINE, 5);
                put(MachineType.CABLECROSSOVERMACHINE, 5);
            }
        });
        fitnessUnited.openForTheDay();
    }
}
