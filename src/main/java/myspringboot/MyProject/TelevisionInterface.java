package myspringboot.MyProject;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TelevisionInterface extends CrudRepository<Television, Integer> {
	
	public List<Television> findAllByCost(int cost);
	public List<Television> findAllByBrand(String brand);
	public List<String> findAllByType(String type);
	
	@Transactional
	@Modifying
	@Query("delete from Television where type like %:own%")
	public void deleteAllByCustom(String own);
	
	@Query("select model from Television where type like %:tp%")
	public List<String> findAllByTypeLike(String tp);
	
	@Transactional
	@Modifying
	@Query("Update Television set cost=cost*0.050 where brand=:bnd ")
	public void updatePriceByBrand(String bnd);
	
	@Query("from Television where brand=:bnd and type>=:tp")
	public List<Television> findAllByBrandandType(String bnd, String tp);
	
	@Query("select brand from Television where model=:mdl")
	public List<String> findAllByModel(String mdl);

	

	
}
