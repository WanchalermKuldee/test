package sut.ac.th.serverTeam02.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
public class Prob {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column(nullable = false, name = "title", length = 70)
	@Pattern(regexp = "[a-zA-Z0-9\\s]+")
	private String titlepb;
	@Column(nullable = false, name = "detail", length = 150)
	@Pattern(regexp = "[a-zA-Z0-9\\s]+")
	private String detailpb;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitlepb() {
		return titlepb;
	}
	public void setTitlepb(String titlepb) {
		this.titlepb = titlepb;
	}
	public String getDetailpb() {
		return detailpb;
	}
	public void setDetailpb(String detailpb) {
		this.detailpb = detailpb;
	}
}
