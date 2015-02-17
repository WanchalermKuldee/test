package sut.ac.th.serverTeam02.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sut.ac.th.serverTeam02.domain.Manager;

import sut.ac.th.serverTeam02.repository.ManagerRepository;


@RestController
public class ManagerControll {
	
	@Autowired
	private ManagerRepository repo;
	@RequestMapping("man/save")
	
	@ResponseBody
	public String add(@Valid @RequestBody Manager manager) {
		
		repo.save(manager);
		
		return "{\"message\":\"บันทึกสำเร็จ\"}";
		}
	@RequestMapping("manager/show")
	@ResponseBody
	public List<Manager> showall(){
		return (List<Manager>) repo.findAll();
	}
	@RequestMapping("/manager/detail/{id}")
	@ResponseBody
	public List<Manager> managerById(@PathVariable("id") Long id){
		return (List<Manager>) repo.findOneById(id);
	}
	
	@RequestMapping("/manager/update")
	@ResponseBody
	public String managerUpdate(@Valid @RequestBody Manager pr){
		repo.save(pr);
		return "{\"message\":\"แก้ไขเสร็จสิ้น\"}";
	}
	

}
