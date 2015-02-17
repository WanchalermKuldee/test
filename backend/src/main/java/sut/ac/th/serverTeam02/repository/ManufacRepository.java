package sut.ac.th.serverTeam02.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sut.ac.th.serverTeam02.domain.Manufac;

@Repository
public interface ManufacRepository extends CrudRepository <Manufac , Long>{
	public Manufac findOneById(Long id);
}
