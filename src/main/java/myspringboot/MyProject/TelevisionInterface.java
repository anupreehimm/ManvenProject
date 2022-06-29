package myspringboot.MyProject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TelevisionInterface extends CrudRepository<Television, Integer> {

	
}
