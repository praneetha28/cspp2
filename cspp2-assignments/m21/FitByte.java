public class FitByte {
    private List<Log> logs;
    private int size = 0;
    FitByte() {
        logs = new List<Log>();
    }
    public void addLog(final Log l) {
        logs.add(l);
    }
    public void displaySummary() {
        for (int i = 0; i < logs.size(); i++) {
            System.out.println(logs.get(i));
        }
    }
    public void printFoodLog() {
        for(int i = 0; i < logs.size() - 1; i++) {
            if(logs.get(i) instanceof FoodLog) {
                System.out.println(logs.get(i));
            }
        }
        int i = logs.size() - 1;
        if(logs.get(i) instanceof FoodLog) {
            System.out.println(logs.get(i));
        }
    }
    public void printWeightLog() {
        for(int i = 0; i < logs.size() - 1; i++) {
            if(logs.get(i) instanceof Weight) {
                System.out.println(logs.get(i));
            }
        }
        int i = logs.size() - 1;
        if(logs.get(i) instanceof Weight) {
            System.out.println(logs.get(i));
        }
    }
    public void printWaterLog() {
        for(int i = 0; i < logs.size() - 1; i++) {
            if(logs.get(i) instanceof WaterLog) {
                System.out.println(logs.get(i));
            }
        }
        int i = logs.size() - 1;
        if(logs.get(i) instanceof WaterLog) {
            System.out.println(logs.get(i));
        }
    }
    public void printPhysicalActivity() {
        for(int i = 0; i < logs.size() - 1; i++) {
            if(logs.get(i) instanceof PhysicalActivity) {
                System.out.println(logs.get(i));
            }
        }
        int i = logs.size() - 1;
        if(logs.get(i) instanceof PhysicalActivity) {
            System.out.println(logs.get(i));
        }
    }
    public void printSleep() {
        for(int i = 0; i < logs.size() - 1; i++) {
            if(logs.get(i) instanceof Sleep) {
                System.out.println(logs.get(i));
            }
        }
        int i = logs.size() - 1;
        if(logs.get(i) instanceof Sleep) {
            System.out.println(logs.get(i));
        }
    }
}