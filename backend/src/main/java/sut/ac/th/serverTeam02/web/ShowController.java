package sut.ac.th.serverTeam02.web;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sut.ac.th.serverTeam02.domain.Datauser;
import sut.ac.th.serverTeam02.repository.ShowRepository;
@RestController
public class ShowController {
	@Autowired
	private ShowRepository showRepo;
	
	
	
	@RequestMapping("/show")
	@ResponseBody
	public List<Datauser> findshow(){
		return (List<Datauser>) showRepo.findAll();
	}
}
