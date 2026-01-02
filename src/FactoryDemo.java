import java.util.Scanner;
public class FactoryDemo{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Robot rob1 = new Robot("X308",85);
        Robot rob2 = new Robot("Y155",45);
        System.out.println("Initial robot infos: \n");
        rob1.displayRobotInfo();
        rob2.displayRobotInfo();


        Task t1 = new Task("Running",25);
        Task t2 = new Task("Dancing",35);
        Task t3 = new Task("Inspection", 15);
        TaskBatch batch = new TaskBatch();

        batch.addTask(t1);
        batch.addTask(t2);
        batch.addTask(t3);

        batch.printBatchInfo();

        System.out.println("\nTotal Energy Cost: " + batch.getTotalEnergyCost());

        rob1.performTaskBatch(batch);
        rob2.performTaskBatch(batch);


    }
}