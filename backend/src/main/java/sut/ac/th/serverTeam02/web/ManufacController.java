package sut.ac.th.serverTeam02.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sut.ac.th.serverTeam02.domain.Manufac;
import sut.ac.th.serverTeam02.repository.ManufacRepository;



@RestController
public class ManufacController {
	@Autowired
	private ManufacRepository manufacRepo;
	
	@RequestMapping("/manufac/detail/showall")
	@ResponseBody
	public List<Manufac>  mshowall(){
		return (List<Manufac>) manufacRepo.findAll();
	}
	
	@RequestMapping("/manufac/detail/{id}")
	@ResponseBody
	public Manufac detailById(@PathVariable("id") Long id){
		return manufacRepo.findOneById(id);
	}
	
	@RequestMapping("/Manufacs")
	@ResponseBody

	public String add(@Valid @RequestBody Manufac product) {
		manufacRepo.save(product);
		return"{\"message\":\"บันทึกสำเร็จ\"}";
		}

	
	
}
