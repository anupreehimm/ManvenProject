package myspringboot.MyProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelevisionService {
	
	@Autowired
	TelevisionInterface obj;
	
	public Television makeNewOne(Television tele) {
		 return obj.save(tele);
		
					
	}

}
