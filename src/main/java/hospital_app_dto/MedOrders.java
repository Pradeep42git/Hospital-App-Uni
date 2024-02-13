package hospital_app_dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class MedOrders {
	@Id
	private int id;
	private double bill;
	@CreationTimestamp
	LocalDateTime localDateTime;
//	private LocalTime localTime;
	@ManyToMany
	private List<Item>items;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBill() {
		return bill;
	}
	public void setBill(double bill) {
		this.bill = bill;
	}
//	public LocalDate getLocalDate() {
//		return localDate;
//	}
//	public void setLocalDate(LocalDate localDate) {
//		this.localDate = localDate;
//	}
//	public LocalTime getLocalTime() {
//		return localTime;
//	}
//	public void setLocalTime(LocalTime localTime) {
//		this.localTime = localTime;
//	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	
}
