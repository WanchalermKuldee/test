package sut.ac.th.serverTeam02.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sut.ac.th.serverTeam02.domain.Delivery;
import sut.ac.th.serverTeam02.repository.DeliveryRepository;

@RestController
public class DeliveryController {
	
	@Autowired
	private DeliveryRepository repo;
	

	@RequestMapping("/delivery/detail/{id}")
	@ResponseBody
	public List<Delivery> detailById(@PathVariable("id") Long id){
		return (List<Delivery>) repo.findOneById(id);
	}
	
	@RequestMapping("/delivery/update")
	@ResponseBody
	public String updateDelivery(@Valid @RequestBody Delivery dl){
		repo.save(dl);
		return "{\"message\":\"บันทึกสำเร็จ\"}";
	}

}
