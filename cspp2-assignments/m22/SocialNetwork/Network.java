import java.util.ArrayList;
import java.util.Arrays;
class Network {

	private List<User> userList;

	public Network() {
		userList = new List<User>();
	}

	public void addConnection(String uname, String friend) {
		int index = userList.indexOf(new User(uname));
		if (index == -1) {
			System.out.println("Not a user in Network");
			return;
		} else {
			if (userList.get(index).getFriends().contains(friend) == false) {
				userList.get(index).getFriends().add(friend);
			}
		}
	}

	public void addNewUser(String uname, List<String> connections) {
		if (userList.size() == 0) {
			userList.add(new User(uname, connections));
		} else {
			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getUserName().equals(uname)) {
					System.out.println("User already exists");
					return;
				}
			}
			userList.add(new User(uname, connections));
		}
	}
	public List<String> getConnection(String uname) {
		int index = userList.indexOf(new User(uname));
		if (index != -1) {
			return userList.get(index).getFriends();
		}
		return null;
	}
	public List<String> getCommonConnection(String uname, String uname1) {
		List<String> common = new List<String>();
		List<String> frndsListA = getConnection(uname);
		List<String> frndsListB = getConnection(uname1);
		for (int i = 0; i < frndsListA.size(); i++) {
			if (frndsListB.contains(frndsListA.get(i))) {
				common.add(frndsListA.get(i));
			}
		}
		return common;
	}
	public String toString() {
		StringBuffer s = new StringBuffer();
		ArrayList list = new ArrayList();
		for (int i = 0; i < userList.size(); i++) {
			list.add(userList.get(i).getUserName());
		}
		java.util.Collections.sort(list);
		for (int i = 0; i < userList.size(); i++) {
			int index = userList.indexOf(new User((String)list.get(i)));
			s.append(userList.get(index));
		}
		String string = s.toString();
		return string.substring(0, string.length() - 2);
	}
}