package sut.ac.th.serverTeam02.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sut.ac.th.serverTeam02.domain.OrderProduct;
import sut.ac.th.serverTeam02.repository.OrderProductRepository;

@RestController
public class OrderProductController {
	@Autowired
	private OrderProductRepository orderRepo;
	@RequestMapping("order/add")
	@ResponseBody
	public String add(@Valid @RequestBody OrderProduct order){
		orderRepo.save(order);
		return "{\"message\":\"บันทึกใบรายการสินค้าสำเร็จ\"}";
	}
	@RequestMapping("order/find")
	@ResponseBody
	public List<OrderProduct> findshow(){
		return (List<OrderProduct>) orderRepo.findAll();
	}
	@RequestMapping("/order/detail/{id}")
	@ResponseBody
	public List<OrderProduct> detailById(@PathVariable("id") Long id){
		return (List<OrderProduct>) orderRepo.findOneById(id);
	}
	////////////////////////////POND///////////////////////////////
	@RequestMapping("/delivery/showall")
	@ResponseBody
	public List<OrderProduct> showall(){
		return (List<OrderProduct>) orderRepo.findAll();
	}
	/////////////////KAPITAL////////////////////////////////
	@RequestMapping("/manufac/showall")
	@ResponseBody
	public List<OrderProduct> showal(){
	return (List<OrderProduct>) orderRepo.findAll();
	}

}
