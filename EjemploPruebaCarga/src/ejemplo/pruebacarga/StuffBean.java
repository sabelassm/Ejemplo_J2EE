package ejemplo.pruebacarga;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

public class StuffBean {
	private String stuffName;
	private String stuffValue;
	private String stuffQuantity;
	public String message;

	private List<StuffDto> stuffList = new ArrayList<StuffDto>();
	
	public List<StuffDto> getStuffList() {
		return stuffList;
	}
	public void setStuffList(List<StuffDto> stuffList) {
		this.stuffList = stuffList;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStuffName() {
		return stuffName;
	}
	public void setStuffName(String stuffName) {
		this.stuffName = stuffName;
	}
	public String getStuffValue() {
		return stuffValue;
	}
	public void setStuffValue(String stuffValue) {
		this.stuffValue = stuffValue;
	}
	public String getStuffQuantity() {
		return stuffQuantity;
	}
	public void setStuffQuantity(String stuffQuantity) {
		this.stuffQuantity = stuffQuantity;
	}

	public int getStuffCount() {
		return stuffList.size();
	}
	
	public String getUserName() {
		return FacesContext.getCurrentInstance().getExternalContext().
					getSessionMap().get("UsuarioAppPruebasCarga").toString();
	}
	
	public String addStuff() {
		setMessage("Cosa agregada");
		
		StuffDto stuffDto = new StuffDto();
		stuffDto.setName(getStuffName());
		stuffDto.setValue(getStuffValue());
		stuffDto.setQuantity(getStuffQuantity());
		
		stuffList.add(stuffDto);
		
		setStuffName("");
		setStuffValue("");
		setStuffQuantity("");
		
		try {
			Thread.sleep(150);
		} catch (InterruptedException iiee) {}
		
		return "added";
	}
}
