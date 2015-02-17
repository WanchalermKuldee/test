package sut.ac.th.serverTeam02.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sut.ac.th.serverTeam02.domain.User;
import sut.ac.th.serverTeam02.repository.UserRepository;



@RestController
public class LoginController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/login/{user}/{pass}", method = RequestMethod.GET)
	@ResponseBody
	public User login(@PathVariable("user") String userName, @PathVariable("pass") String passWord) {
		
		return userRepository.findOneByUserNameAndPassWord(userName, passWord);
	}
}