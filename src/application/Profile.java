package application;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class Profile {

	public StringProperty id;
	public StringProperty name;
	public StringProperty proj;
	/**
	 * @param id
	 * @param name
	 * @param proj
	 */
	public Profile(String id, String name, String proj) {
		this.id = new SimpleStringProperty(id);
		this.name = new SimpleStringProperty(name);
		this.proj = new SimpleStringProperty(proj);
	}
	public String getId() {
		return id.get();
	}
	public String getName() {
		return name.get();
	}
	public String getProj() {
		return proj.get();
	}
	public void setId(String value) {
		id.set(value);
	}
	public void setName(String value) {
		name.set(value);
	}
	public void setProj(String value) {
		proj.set(value);
	}
//	public StringProperty idProperty() { return id;}
//	public StringProperty nameProperty() { return name;}
//	public StringProperty projProperty() { return proj;}
}
