package sut.ac.th.serverTeam02.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sut.ac.th.serverTeam02.domain.Prob;
import sut.ac.th.serverTeam02.repository.ProbRepository;

@Controller
@RestController
public class ProbController {
	@Autowired
	private ProbRepository probRepo;
	
	@RequestMapping("/Prob/show")
	@ResponseBody
	
	public List<Prob> show(){
		return(List<Prob>) probRepo.findAll();
	}
	
	@RequestMapping("/Prob/add")
	@ResponseBody
	
	public String add(@Valid @RequestBody Prob prob){
		probRepo.save(prob);
		return"{\"message\":\"บันทึกแล้ว\"}";
	}

}

