package sut.ac.th.serverTeam02.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
public class Manager {
@Id
@GeneratedValue
private Long id ;
@Column(nullable = false, name = "nameLineManager", length = 50)
private String nameLineManager;
@Column(nullable = false, name = "name", length = 50)
@Pattern(regexp="[A-Za-z]+")
private String name;
@Column(nullable = false, name = "detel", length = 150)
private String detel;
@Column(nullable = false, name = "telphone", length = 10)
@Size(min = 10, max = 10)
@Pattern(regexp="[0]\\d+")
private String telphone;
@Column(unique = true, name = "lastname", length = 50)
@Pattern(regexp="[A-Za-z]+")
private String lastname;



public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getTelphone() {
	return telphone;
}
public void setTelphone(String telfron) {
	this.telphone = telfron;
}


public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNameLineManager() {
	return nameLineManager;
}
public void setNameLineManager(String nameLineManager) {
	this.nameLineManager = nameLineManager;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDetel() {
	return detel;
}
public void setDetel(String detel) {
	this.detel = detel;
}




}
