package myspringboot.MyProject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TelevisionService {
	
	@Autowired
	TelevisionInterface obj;
	
	public List<String> makeDeleteAllByCustom(String st){
		List<String> tmp=obj.findAllByTypeLike(st);
		obj.deleteAllByCustom(st);
		return tmp;
	}
	
	public String makeDeleteById(int key){
		Television t=obj.findById(key).orElse(null);
		String msg=t.getModel()+"Has Deleted";
		obj.deleteById(key);
		return msg;
		
	}
	
	public void makeUpdate(String tl) {
		 obj.updatePriceByBrand(tl);
		
	}
	
	public String makeDelete(Television tel) {
		String msg=tel.getModel()+"has been Deleted";
		obj.delete(tel);
		return msg;
	}
	
	public List<String> makeFetchByModel(String button){
		return obj.findAllByModel(button);
	}
	
	public List<Television> makeFetchBrandandType(String alpha,String beta){
		return obj.findAllByBrandandType(alpha, beta);
	}
	
	public List<Television> makeReadBrand(String company){
		return obj.findAllByBrand(company);
	}
	
	public List<Television> makeReadType(String style){
		return obj.findAllByType(style);
	}
	public Optional<Television> makeReadCost(int amount){
		return obj.findAllByCost(amount);
	}
	
	
	public Optional<Television> makeRead(int value){
		return obj.findById(value);
	}
	
	public List<Television> makeFetchAll(){
		return (List<Television>) obj.findAll();
	}
	
	public Television makeNewOne(Television tele) {
		 return obj.save(tele);
		
					
	}

}
