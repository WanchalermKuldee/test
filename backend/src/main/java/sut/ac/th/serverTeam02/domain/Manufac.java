package sut.ac.th.serverTeam02.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;





@Entity
public class Manufac {
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false, name = "productname", length = 20 )
	@Pattern(regexp = "[eco|gaming|office]+")
	private String productname;
	@Column (unique = true, nullable = false, name = "customername", length = 20 )
	private String customername;
	@Column(nullable = false, name = "amount", length = 3 )
	private int amount;
	@Column(nullable = false, name = "amountram", length = 3 )
	private int amountram;
	@Column(nullable = false, name = "amountcpu", length = 3 )
	private int amountcpu;
	@Column(nullable = false, name = "amountmainboard", length = 3 )
	private int amountmainboard;
	@Column(nullable = false, name = "amountvga", length = 3 )
	private int amountvga;
	@Column(nullable = false, name = "amountdvd", length = 3 )
	private int amountdvd;
	@Column(nullable = false, name = "amountaccessoeies", length = 3 )
	private int amountaccessoeies;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getAmountram() {
		return amountram;
	}
	public void setAmountram(int amountram) {
		this.amountram = amountram;
	}
	public int getAmountcpu() {
		return amountcpu;
	}
	public void setAmountcpu(int amountcpu) {
		this.amountcpu = amountcpu;
	}
	public int getAmountmainboard() {
		return amountmainboard;
	}
	public void setAmountmainboard(int amountmainboard) {
		this.amountmainboard = amountmainboard;
	}
	public int getAmountvga() {
		return amountvga;
	}
	public void setAmountvga(int amountvga) {
		this.amountvga = amountvga;
	}
	public int getAmountdvd() {
		return amountdvd;
	}
	public void setAmountdvd(int amountdvd) {
		this.amountdvd = amountdvd;
	}
	public int getAmountaccessoeies() {
		return amountaccessoeies;
	}
	public void setAmountaccessoeies(int amountaccessoeies) {
		this.amountaccessoeies = amountaccessoeies;
	}
	
	

	
}