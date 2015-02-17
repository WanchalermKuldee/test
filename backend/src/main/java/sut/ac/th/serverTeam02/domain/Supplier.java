package sut.ac.th.serverTeam02.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
public class Supplier {
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false, name = "cpu")
	private int cpu;
	@Column(nullable = false, name = "mainboard")
	private int mainboard;
	@Column(nullable = false, name = "ram")
	private int ram;
	@Column(nullable = false, name = "vga")
	private int vga;
	@Column(nullable = false, name = "dvd")
	private int dvd;
	@Column(nullable = false, name = "acces")
	private int acces;
	@Column(nullable = false, name = "price")
	private int price;
	@Column(unique = true, nullable = false, name = "emp", length = 30)
	@Pattern(regexp = "[a-zA-Z]+")
	private String emp;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCpu() {
		return cpu;
	}
	public void setCpu(int cpu) {
		this.cpu = cpu;
	}
	public int getMainboard() {
		return mainboard;
	}
	public void setMainboard(int mainboard) {
		this.mainboard = mainboard;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getVga() {
		return vga;
	}
	public void setVga(int vga) {
		this.vga = vga;
	}
	public int getDvd() {
		return dvd;
	}
	public void setDvd(int dvd) {
		this.dvd = dvd;
	}
	public int getAcces() {
		return acces;
	}
	public void setAcces(int acces) {
		this.acces = acces;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getEmp() {
		return emp;
	}
	public void setEmp(String emp) {
		this.emp = emp;
	}
	
}
