package entities;

public class Bike {

	private int id;
	private int year;
	private String make;
	private String model;
	private int engineSize;

	public Bike(int id, int year, String make, String model, int engineSize) {
		this.setId(id);
		this.setYear(year);
		this.setMake(make);
		this.setModel(model);
		this.setEngineSize(engineSize);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getEngineSize() {
		return engineSize;
	}
	public void setEngineSize(int engineSize) {
		this.engineSize = engineSize;
	}
}
