package ejemplo.pruebacarga;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoginValidator {
	
	private static Map<String, String> users = new Hashtable<String, String>();
	
	static {
		users.put("pepe", "pepe123");
		users.put("juan", "juan123");
		users.put("roberto", "roberto123");
		users.put("chonto", "chonto123");
	}
	
	public static boolean isValidLogin(String user, String password) {
		if ((users.get(user) != null) && (users.get(user).equals(password))){
			return true;
		}
		
		return false;
	}
}
