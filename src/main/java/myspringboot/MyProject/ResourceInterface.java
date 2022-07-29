package myspringboot.MyProject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceInterface extends CrudRepository<Resource, Integer>{
	
	public Resource findByUsername(String username);
	

}
