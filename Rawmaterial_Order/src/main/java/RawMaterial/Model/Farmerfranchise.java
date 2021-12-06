package RawMaterial.Model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties()
public class Farmerfranchise {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Access(AccessType.PROPERTY)
	private int Id;
	private String District;
	private String Franchise;
	private String Product;
	private int Quantity;
	private String State;
	
	public Farmerfranchise() {
		
	}
	@Override
	public String toString() {
		return "FarmerFranchise [Id=" + Id + ", Franchise=" + Franchise + ", Product=" + Product + ", Quantity="
				+ Quantity + ", District=" + District + ", State=" + State + "]";
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFranchise() {
		return Franchise;
	}
	public void setFranchise(String franchise) {
		Franchise = franchise;
	}
	public String getProduct() {
		return Product;
	}
	public void setProduct(String product) {
		Product = product;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	
	
	
	

}
