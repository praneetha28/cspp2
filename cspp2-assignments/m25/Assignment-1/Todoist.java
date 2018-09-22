import java.util.Arrays;
class Todoist {

	private static final int X = 10;
	private int size;
	Task[] taskArray;

	Todoist() {
		taskArray = new Task[X];
		size = 0;
	}

	public Todoist(final int capacity) {
        size = 0;
        taskArray = new Task[capacity];
    }

    public void addTask(final Task task) {
        if (size == taskArray.length) {
            resize();
        }
        taskArray[size++] = task;
    }

	private void resize() {
        taskArray = Arrays.copyOf(taskArray, size * 2);
    }
    // public Task get(final int index) {
    //     if (index < 0 || index >= size) {
    //         return null;
    //     } else {
    //         return taskArray[index];
    //     }
    // }
    public int size() {
    	return size;
    }
    public String toString() {
    	String str = "";
    	for(int i = 0; i < size; i++) {
    		str += taskArray[i]+ "\n";

    	}
    	return str;
    }

    public Task getNextTask(String name) {
    	for (int i = 0; i < size; i++) {
    		if (taskArray[i].getAssignedTo().equals(name)) {
    			if (taskArray[i].getStatus().equals("todo")) {
    				if (taskArray[i].getImportant().equals("Important")) {
    					if (taskArray[i].getUrgent().equals("Not Urgent")) {
    						return taskArray[i];
    					}
    				}
    			}
    		}
    	}
    	for (int i = 0; i < size; i++) {
    		if (taskArray[i].getAssignedTo().equals(name)) {
    			if (taskArray[i].getStatus().equals("todo")) {
    				if (taskArray[i].getImportant().equals("Important")) {
    					if (taskArray[i].getUrgent().equals("Urgent")) {
    						return taskArray[i];
    					}
    				}
    			}
    		}
    	}
    	return null;
    }
    public Task[] getNextTask(String name, int count) {
    	Task[] countTask = new Task[count];
    	int count1 = 0;
    	for (int i = 0; i < size; i++) {
    		if (taskArray[i].getAssignedTo().equals(name)) {
    				if (taskArray[i].getStatus().equals("todo")) {
    					if (taskArray[i].getImportant().equals("Important")) {
    						if (taskArray[i].getUrgent().equals("Not Urgent")) {
    							countTask[count1++] = taskArray[i];
    						}
    					}
    				}
    			}
    	}
    	// for (int i = 0;i < count; i++) {
    	// 	c
    	return countTask;
    }
    public int totalTime4Completion() {
    	int res = 0;
    	for (int i = 0; i < size; i++) {
    		if (taskArray[i].getStatus().equals("todo")) {
    			res += taskArray[i].getTimeToComplete();
    		}
    	}
    	return res;
    }
}