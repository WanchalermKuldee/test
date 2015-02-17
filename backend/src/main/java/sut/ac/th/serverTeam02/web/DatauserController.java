package sut.ac.th.serverTeam02.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sut.ac.th.serverTeam02.domain.Datauser;
import sut.ac.th.serverTeam02.repository.DatauserRepository;

@RestController
public class DatauserController {
	
	@Autowired
	private DatauserRepository DataRepo;
	
	@RequestMapping("data/add")
	@ResponseBody
	public String add(@Valid @RequestBody Datauser adddatauser) {
		
		DataRepo.save(adddatauser);
		
		return "{\"message\":\"เรียบร้อย\"}";
		
	}
	
	@RequestMapping("/user/show")
	@ResponseBody
	public List<Datauser> showall2(){
		return (List<Datauser>) DataRepo.findAll();
	}
	

	
}
