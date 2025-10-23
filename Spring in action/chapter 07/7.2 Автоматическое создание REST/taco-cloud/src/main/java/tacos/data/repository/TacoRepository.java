package tacos.data.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import tacos.model.Taco;

@Repository
public interface TacoRepository extends PagingAndSortingRepository<Taco, Long>{
	Taco save(Taco taco);

	Optional<Taco> findById(Long id);
}