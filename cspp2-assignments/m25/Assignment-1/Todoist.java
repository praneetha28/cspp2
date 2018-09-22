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

    public void add(final Task task) {
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
    public String toString() {
    	String str = "";
    	for(int i = 0; i < taskArray.length; i++) {
    		str += taskArray[i].toString();
    	}
    	return str;
    }
    // public Task getNextTask(String name) {

    // }
}