public class TaskBatch {
    private Task[] tasks;
    private int taskCount;

    public TaskBatch() {
        tasks = new Task[5];
        taskCount = 0;
    }
    public Task[] getTasks() {
        if (taskCount == 0) {
            System.out.println("Task batch is empty.");
            return null;
        }
        return tasks;
    }

    public void addTask(Task t) {
        if (taskCount < 5) {
            tasks[taskCount] = t;
            taskCount++;
        } else {
            System.out.println(" Batch is full! Cannot add more tasks.");
        }
    }
    public int getTotalEnergyCost() {
        if (taskCount == 0) {
            System.out.println(" No tasks in batch!");
            return 0;
        }
        int total = 0;
        for (int i = 0; i < taskCount; i++) {
            total += tasks[i].getEnergyCost();
        }
        return total;
    }

    public int getTaskCount() {
        return taskCount;
    }
    public void printBatchInfo() {
        if (taskCount == 0) {
            System.out.println("Task batch is empty.");
            return;
        }

        System.out.println("=== Task Batch Info ===");
        for (int i = 0; i < taskCount; i++) {
            tasks[i].describeTask();
        }
    }


}
