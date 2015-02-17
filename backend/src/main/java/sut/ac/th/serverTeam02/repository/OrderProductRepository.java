package sut.ac.th.serverTeam02.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sut.ac.th.serverTeam02.domain.OrderProduct;

@Repository
public interface OrderProductRepository extends CrudRepository<OrderProduct, Long>{
	public List<OrderProduct> findOneById(Long id);
}
