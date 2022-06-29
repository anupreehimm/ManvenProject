package myspringboot.MyProject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Television {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private int tvId;
	@Column(name="product_model")
	private String model;
	@Column(name="product_brand")
	private String brand;
	@Column(name="product_cost")
	private int cost;
	@Column(name="product_size")
	private double size;
	@Column(name="product_type")
	private String type;
	
	@Override
	public String toString() {
		return "Television [tvId=" + tvId + ", model=" + model + ", brand=" + brand + ", cost=" + cost
				+ ", size=" + size + ", type=" + type + "]";
	} 
	
	public Television() {
		
	}
	
	public Television(int tvId, String model, String brand , int cost, double inches, String type) {
		super();
		this.tvId = tvId;
		this.model = model;
		this.brand = brand;
		this.cost = cost;
		this.size = inches;
		this.type = type;
	}
	


	public int getTvId() {
		return tvId;
	}
	public void setTvId(int tvId) {
		this.tvId = tvId;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getbrand() {
		return brand;
	}
	public void setBrandName(String brand) {
		this.brand = brand;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}
