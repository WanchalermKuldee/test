package sut.ac.th.serverTeam02.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import sut.ac.th.serverTeam02.domain.Datauser;


public interface DatauserRepository extends CrudRepository<Datauser , Long> {
	public List<Datauser> findOneById(Long id);
}
