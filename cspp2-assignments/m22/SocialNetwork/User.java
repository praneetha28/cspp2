/**.
 * Class for user.
 */
class User {
	/**.
	 * { var_description }
	 */
	private String userName;
	/**.
	 * { var_description }
	 */
	private List<String> friendsList;
	/**.
	 * Constructs the object.
	 */
	public User() {
		/**.
		 * { item_description }
		 */
	}
	public User(String uname) {
		this.userName = uname;
		this.friendsList = null;
	}
	public User(String uname, List<String> connections) {
		this.userName = uname;
		this.friendsList = connections;
    }
    public String getUserName() {
    	return this.userName;
    }
    public void setUserName(String uname ) {
    	this.userName = uname;
    }
    public void setFriends(List<String> connections) {
    	this.friendsList = connections;
    }
    public List<String> getFriends() {
    	return friendsList;
    }
    // public String toString() {
    // 	return this.getUserName() + " " + this.getFriends();
    // }
    public boolean equals(Object o) {
    	User u = (User) o;
    	return u.getUserName().equals(this.getUserName());
    }
    public String toString() {
    	StringBuffer sb = new StringBuffer();
    	sb.append(this.getUserName() + ": [");
    	for(int i = 0;i < friendsList.size() - 1; i++) {
    		sb.append(friendsList.get(i) + ", ");
    	}
    	sb.append(friendsList.get(friendsList.size() - 1) + "], ");
    	return sb.toString();
    }
}