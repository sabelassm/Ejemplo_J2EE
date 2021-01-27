package ejemplo.pruebacarga;

public class StuffDto {
	private String name;
	private String value;
	private String quantity;
	
	public String getName() {
		return name;
	}
	public void setName(String stuffName) {
		this.name = stuffName;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String stuffValue) {
		this.value = stuffValue;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String stuffQuantity) {
		this.quantity = stuffQuantity;
	}
}