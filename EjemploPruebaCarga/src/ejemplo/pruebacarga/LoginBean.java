package ejemplo.pruebacarga;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

public class LoginBean {
	
	private String user;
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String password;
	
	public String login(){
		
		if (LoginValidator.isValidLogin(getUser(), getPassword())) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("UsuarioAppPruebasCarga", getUser().toUpperCase());
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("HeavyObject", createHeavyObject());
			
			try {
				Thread.sleep(250);
			} catch (InterruptedException iiee) {}
			
			return "ok";
		}
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("UsuarioAppPruebasCarga");
		
		return "error";
	}
	
	private List<Map<String, String>> createHeavyObject() {
		List<Map<String, String>> heavyObject = new ArrayList<Map<String,String>>();
		Map<String, String> theMap = new HashMap<String, String>();
		
		for (int i = 0; i < 500; i++) {
			theMap.put(Integer.toString(i), "dsafsdfiuoriqwer,mn,.fmandsfiuaoisfdu iouafapsdifpoiae8r9qw45klrqe lwrkjqñewr8q90ewrqwer");
		}
		
		for (int i = 0; i < 500; i++) {
			heavyObject.add(new HashMap<String, String>(theMap));
		}
		
		return heavyObject;
	}
}
