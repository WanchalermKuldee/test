package sut.ac.th.serverTeam02.repository;

import org.springframework.data.repository.CrudRepository;

import sut.ac.th.serverTeam02.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	

	public User findOneByUserNameAndPassWord(String userName, String passWord);
	
}
