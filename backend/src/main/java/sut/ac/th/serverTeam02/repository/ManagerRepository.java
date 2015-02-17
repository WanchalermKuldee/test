package sut.ac.th.serverTeam02.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sut.ac.th.serverTeam02.domain.Manager;


@Repository
public interface ManagerRepository extends CrudRepository<Manager,Long>{
	public List<Manager> findOneById(Long id);
}
