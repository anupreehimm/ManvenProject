package myspringboot.MyProject;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TelevisionInterface extends CrudRepository<Television, Integer> {
	
	public List<Television> findAllByCost(int cost);
	public List<Television> findAllByBrand(String brand);
	public List<Television> findAllByType(String type);
	
	@Query("from Television where brand=:bnd and type>=:tp")
	public List<Television> findAllByBrandandType(String bnd, String tp);
	
	@Query("select brand from Television where model=:mdl")
	public List<String> findAllByModel(String mdl);

	
}
