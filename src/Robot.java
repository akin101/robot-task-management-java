public class Robot {
    private String modelName;
    private int batteryLevel;
    private String status;

    public Robot(String modelName, int batteryLevel){
        this.modelName = modelName;
        this.batteryLevel = batteryLevel;
        updateStatus();
    }

    public String getModelName(){
        return modelName;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public String getStatus() {
        return status;
    }

    private void updateStatus() {
        if (batteryLevel == 0) {
            status = "Inactive";
        } else if (batteryLevel < 20) {
            status = "Low Battery";
        } else {
            status = "Active";
        }
    }

    public void displayRobotInfo(){
        System.out.println(
                "Model name: " + modelName +
                        "\nBattery level: " + batteryLevel +
                        "\nStatus: " + status + "\n"
        );
    }

    public boolean isBatteryEnough(int requiredAmount) {
        return batteryLevel >= requiredAmount;
    }

    public boolean consumeBattery(int amount) {
        if (!isBatteryEnough(amount)) {
            return false;
        }

        batteryLevel -= amount;
        updateStatus();
        return true;
    }

    public void chargeBattery(int amount) {
        batteryLevel += amount;

        if (batteryLevel > 100) {
            batteryLevel = 100;
        }

        updateStatus();
    }

    public void performTask(Task t){
        System.out.println(modelName + " is attempting to task " + t.getTaskName());

        if (!consumeBattery(t.getEnergyCost())) {
            System.out.println("Task failed: Not enough battery.");
            return;
        }

        System.out.println("Task completed successfully.");
    }

    public void performTaskBatch(TaskBatch batch){
        if (batch.getTaskCount() == 0) {
            System.out.println("Task batch is empty, cannot process.");
            return;
        }

        int totalEnergy = batch.getTotalEnergyCost();

        if (!isBatteryEnough(totalEnergy)) {
            System.out.println("Not enough battery to process the entire task batch for: " + modelName);
            return;
        }

        System.out.println("\n" + modelName + " is processing task batch\n");

        for (Task t : batch.getTasks()) {
            if (t != null) {
                performTask(t);
            }
        }

        System.out.println("\nUpdated robot info after batch:");
        displayRobotInfo();
    }
}