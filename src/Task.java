public class Task {
    private String taskName;
    private int energyCost;

    public Task(String taskName, int energyCost){
        this.taskName = taskName;
        this.energyCost = energyCost;
    }

    public int getEnergyCost() {
        return energyCost;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setEnergyCost(int energyCost) {
        this.energyCost = energyCost;
    }
    public void describeTask() {
        System.out.println(" Task: " + taskName + ", Energy cost: " + energyCost);
    }



}
