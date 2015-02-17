package sut.ac.th.serverTeam02.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sut.ac.th.serverTeam02.domain.Delivery;

@Repository
public interface DeliveryRepository extends CrudRepository<Delivery,Long> {
	
	public List<Delivery> findOneById(Long id);
	
}
