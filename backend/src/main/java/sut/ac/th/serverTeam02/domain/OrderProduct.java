package sut.ac.th.serverTeam02.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;


@Entity
public class OrderProduct {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true, nullable = false, name = "customername", length = 20 )
	@Pattern (regexp = "[a-zA-Z]+")
	private String customername;
	
	@Column(nullable = false, name = "emailcustomer", length = 50 )
	private String emailcustomer;
	
	@Column(nullable = false, name = "productname", length = 10 )
	@Pattern (regexp = "[eco|gaming|office]+")
	private String productname;
	
	@Column(nullable = false, name = "amount", length = 3 )
	private int amount;
	
	@Column(nullable = false, name = "price", length = 10 )
	private int price;
	@Autowired
	
	@Column(nullable = false, name = "totalprice", length = 10 )
	private int totalprice;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getEmailcustomer() {
		return emailcustomer;
	}
	public void setEmailcustomer(String emailcustomer) {
		this.emailcustomer = emailcustomer;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}


}