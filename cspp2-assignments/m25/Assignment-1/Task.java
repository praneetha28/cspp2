class Task {
	String title;
	String assignedTo;
	int timeToComplete;
	String important;
	String urgent;
	String status;
	Task() {

	}
	Task(String ttle, String assgnedTo, int tmeToCmplete, boolean imp, boolean urgnt, String sttus) throws Exception {
		if (ttle.length() == 0) {
			throw new Exception ("Title not provided ");
		} else {
			this.title = ttle;
		}

		this.assignedTo = assgnedTo;
		if (tmeToCmplete < 0) {
			throw new Exception ("Invalid timeToComplete " + tmeToCmplete);
		}
		this.timeToComplete = tmeToCmplete;
		this.setImportant(imp);
		this.setUrgent(urgnt);
		if (sttus.equals("todo") || sttus.equals("done")) {
			this.status = sttus;

		} else {
			throw new Exception ("Invalid status " + sttus);
		}

	}
	public String getTitle() {
		return this.title;
	}
	public String getAssignedTo() {
		return this.assignedTo;
	}
	public int getTimeToComplete() {
		return this.timeToComplete;
	}
	public String getImportant() {
		return this.important;
	}
	public String getUrgent() {
		return this.urgent;
	}
	public String getStatus() {
		return this.status;
	}
	public void setTitle(String ttle) {
		this.title = ttle;
	}
	public void setAssignedTo(String assgnedTo) {
		this.assignedTo = assgnedTo;
	}
	public void setTimeToComplete(int tmeToCmplete) {
		this.timeToComplete = tmeToCmplete;
	}
	public void setImportant(boolean imp) {
		if (imp) {
			this.important = "Important";
		} else {
			this.important = "Not Important";
		}

	}
	public void setUrgent(boolean urgnt) {
		if (urgnt) {
			this.urgent = "Urgent";
		} else {
			this.urgent = "Not Urgent";
		}
	}
	public void setStatus(String sttus) {
		this.status = sttus;
	}
	public String toString() {
		return this.getTitle() + ", " + this.getAssignedTo() +
		 ", " + this.getTimeToComplete() + ", " + this.getImportant() +
		  ", " + this.getUrgent() + ", " + this.getStatus();
	}
}