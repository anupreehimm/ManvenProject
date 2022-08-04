package myspringboot.MyProject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@CrossOrigin(origins = "http://localhost:3000")
public class TelevisionExecutive {
	
	@Autowired
	TelevisionService service;
	
	@Autowired
	ResourceService ser;
	
	@Autowired
	PasswordEncoder encoder;
	
	@PostMapping("/Signup")
	public Resource Signup(@RequestBody Resource resource) {
		String newone=encoder.encode(resource.getPassword());
		resource.setPassword(newone);		
		return ser.implementSave(resource);
	}
		
	@DeleteMapping("/deleall/{st}")
	public List<String> callingDeleteByMany(@PathVariable("st") String st){
		return service.makeDeleteAllByCustom(st);
	}
	
	@DeleteMapping("/dele/{pos}")
	public String callingDeleteId(@PathVariable("pos") int pos) {
		return service.makeDeleteById(pos);
		
	}
	
	@PutMapping("/ups/{brand}")
	public void callingUpdateBuyPrice(@PathVariable("brand") String brand) {
		service.makeUpdate(brand);
	}
	
	@PutMapping("/up")
	public Television makeUpdate(@RequestBody Television tl) {
		return service.makeNewOne(tl);
	}
	
	@DeleteMapping("/del")
	public String makeDelete(@RequestBody Television tata) {
		return service.makeDelete(tata);
		
	}
	@GetMapping("/bysome/{just}")
	public List<String> callingFetchModel(@PathVariable("just") String just){
		return service.makeFetchByModel(just);
	}
	
	
	@GetMapping("/bytwo/{gun}/{run}")
	public List<Television> callingReadBrandandType(@PathVariable("gun") String gun,@PathVariable("run") String run){
		return service.makeFetchBrandandType(gun,run);
	}
	
	@GetMapping("/bybrand/{company}")
	public List<Television> callingReadBrand(@PathVariable("company") String company){
		return service.makeReadBrand(company);
	}
	
	@GetMapping("/bytype/{noise}")
	public List<String> callingReadType(@PathVariable("noise") String noise){
		return service.makeReadType(noise);
	}
	
	@GetMapping("/byamount/{You}")
	public List<Television> callingReadCost(@PathVariable("You") int You){
		return service.makeReadCost(You);
	}
	
	@GetMapping("/{Hi}")
	public Optional<Television> callingRead(@PathVariable("Hi") int Hi){
		return service.makeRead(Hi);
		
	}
	@GetMapping("/")
	public List<Television> callingTrade(){
		return service.makeFetchAll();
		
	}
	
	
	@PostMapping("/new")
	public Television callingCreation(@RequestBody Television tell) {
		
		return service.makeNewOne(tell);
	}
}
