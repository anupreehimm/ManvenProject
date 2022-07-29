package myspringboot.MyProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ResourceService implements UserDetailsService{
	
	@Autowired
	ResourceInterface repo;
	
	public Resource implementSave(Resource resource)
	{
		return repo.save(resource);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Resource rec=repo.findByUsername(username);
		if(rec==null) {
			throw new UsernameNotFoundException("User Invalid");
		}
		
		return rec;
	}
	
	
	
	
	

}
