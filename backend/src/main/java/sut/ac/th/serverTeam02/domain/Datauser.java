package sut.ac.th.serverTeam02.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;


@Entity
public class Datauser {
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false, name ="username",length =20)
	@Pattern(regexp = "[a-zA-Z]+")
	private String username;
	
	@Column(nullable = false, name ="age",length =2)
	private int age;
	
	@Column(nullable = false, name ="address",length =100)
	private String address;
	
	@Column(nullable = false, name ="tel",length =10)
	@Pattern (regexp = "[0-9]+")
	private String tel;
	
	@Column(nullable = false, name ="email",length =30)
	private String email;

	
	public Long getid() {
		return id;
	}
	public void setUserid(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
