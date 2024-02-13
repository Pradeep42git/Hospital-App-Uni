package hospital_app_dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Hospital {
	@Id
	private int id;
	private String name;
	private String chairMan;
	@OneToMany
	private List<Branch>branch;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getchairMan() {
		return chairMan;
	}
	public void setchairMan(String chairMan) {
		this.chairMan = chairMan;
	}
	public List<Branch> getBranch() {
		return branch;
	}
	public void setBranch(List<Branch> branch) {
		this.branch = branch;
	}
	
	
	
	

}
