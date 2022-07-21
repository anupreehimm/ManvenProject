package myspringboot.MyProject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class MyProjectApplicationTests {
	@MockBean
	TelevisionInterface repo;
	
	@Autowired
	TelevisionService service;
	
	
	public void typeAllType() {
		String t1="Samusang";
		String t2="Sony";
		String t3="Philips";
		String t4="Hyundai";
		
		List<String> check1=Stream.of(t1,t2,t3).collect(Collectors.toList());
		List<String> check2=Stream.of(t2,t4,t3).collect(Collectors.toList());
		List<String> check3=Stream.of(t2,t3,t4).collect(Collectors.toList());
		List<String> check4=Stream.of(t1,t3,t4).collect(Collectors.toList());
		
		when(repo.findAllByType("Ultra HD")).thenReturn(Stream.of(t1,t2,t3).collect(Collectors.toList()));
		
		assertLinesMatch(check4,service.makeReadType("Ultra HD"));
	}
	
	@Test
	public void testAllByBrand() {
		
		Television t1=new Television(121,"Samusang Q Serice","Samusang",179999,65.1,"Ultra HD");
		Television t2=new Television(131,"Sony Smart Android TV","Sony",60999,49.2,"Ultra HD");
		Television t3=new Television(141,"Philips 6800 Series","Philips",29999,43.0,"Ultra LED");
		Television t4=new Television(151,"Hyundai smart webOS TV","Hyundai",29999,50.0,"Ultra HD LED");
		Television t5=new Television(178,"Hyundai smart webOS TV","Hyundai",19999,30.0,"HD LED");
		 
		when(repo.findAllByBrand("Hyundai")).thenReturn(Stream.of(t4,t5).collect(Collectors.toList()));
	}
	
	@Test
	public void testfindAllByCost() {
		Television t1=new Television(121,"Samusang Q Serice","Samusang",179999,65.1,"Ultra HD");
		Television t2=new Television(131,"Sony Smart Android TV","Sony",60999,49.2,"Ultra HD");
		Television t3=new Television(141,"Philips 6800 Series","Philips",29999,43.0,"Ultra LED");
		Television t4=new Television(151,"Hyundai smart webOS TV","Hyundai",29999,50.0,"Ultra HD LED");
		 
		when(repo.findAllByCost(29999)).thenReturn(Stream.of(t3,t4).collect(Collectors.toList()));
		
	}
	
	
	@Test
	public void testDelete() {
		Television t1=new Television(121,"Samusang Q Serice","Samusang",179999,65.1,"Ultra HD");
		repo.delete(t1);
		verify(repo,times(1)).delete(t1);
		
	}
	
	
	@Test
	public void testRead() {
		Optional<Television> t1=Optional.of(new Television(121,"Samusang Q Serice","Samusang",179999,65.1,"Ultra HD"));
		Optional<Television> t2=Optional.of(new Television(131,"Sony Smart Android TV","Sony",60999,49.2,"Ultra HD"));
		
		when(repo.findById(121)).thenReturn(t1);
		when(repo.findById(131)).thenReturn(t2);
		
		assertEquals(t2,service.makeRead(131));
		assertTrue(service.makeRead(121).get().getType().equals(t1.get().getType()));
	}
	
	@Test
	public void testCreate() {
		Television t1=new Television(121,"Samusang Q Serice","Samusang",179999,65.1,"Ultra HD");
		Television t2=new Television(131,"Sony Smart Android TV","Sony",60999,49.2,"Ultra HD");
		
		when(repo.save(t1)).thenReturn(t1);
		when(repo.save(t2)).thenReturn(t2);
		
		assertTrue(service.makeNewOne(t1).getbrand().equals("Samusang"));
		assertNotNull(service.makeNewOne(t2).getModel());
		
	}
	
	@Test
	public void testingAll() {
		Television t1=new Television(121,"Samusang Q Serice","Samusang",179999,65.1,"Ultra HD");
		Television t2=new Television(131,"Sony Smart Android TV","Sony",60999,49.2,"Ultra HD");
		Television t3=new Television(141,"Philips 6800 Series","Philips",29999,43.0,"Ultra LED");
		Television t4=new Television(151,"Hyundai smart webOS TV","Hyundai",33000,50.0,"Ultra HD LED");
		Television t5=null;
		
		when(repo.findAll()).thenReturn(Stream.of(t1,t2,t3,t4,t5).collect(Collectors.toList()));
		
		assertSame(5,service.makeFetchAll().size());
		assertNull(service.makeFetchAll().get(4));		
		
	}
	

	@Test
	void contextLoads() {
	}

}
