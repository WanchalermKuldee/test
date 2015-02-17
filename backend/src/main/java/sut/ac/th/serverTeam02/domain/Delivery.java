package sut.ac.th.serverTeam02.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
public class Delivery {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = true, name = "dayTotal", length = 1)
	@Pattern(regexp = "[3-7]*")
	private String dayTotal;
	
	@Column(nullable = true, name = "deliveryType", length = 5)
	@Pattern(regexp = "[plane|ship|truck|train]*")
	private String deliveryType;
	
	@Column(unique = true, nullable = false, name = "customername", length = 30)
	@Pattern(regexp = "[a-zA-Z]+")
	private String customername;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDayTotal() {
		return dayTotal;
	}

	public void setDayTotal(String dayTotal) {
		this.dayTotal = dayTotal;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}
	
}
