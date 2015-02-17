package sut.ac.th.serverTeam02.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sut.ac.th.serverTeam02.domain.Supplier;
import sut.ac.th.serverTeam02.repository.SupplierRepository;

@RestController
public class SupplierColltroller {
	
	@Autowired
	private SupplierRepository repo;
	
	@RequestMapping("/Supplier/showall")
	@ResponseBody
	public List<Supplier> showall(){
		return (List<Supplier>) repo.findAll();
	}
	
	@RequestMapping("/Supplier/save")
	@ResponseBody
	public String add(@Valid @RequestBody Supplier sup){
		
		repo.save(sup);
		
		return "{\"message\":\"บันทึกการสั่งสินค้า\"}";
		
	}

}
