package myspringboot.MyProject;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;
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
	
	@Test
	public void testingAll() {
		Television t1=new Television(121,"Saumsang Q Serice","Samusang",179999,65.1,"Ultra HD");
		Television t2=new Television(131,"Sony Smart Android TV","Sony",60999,49.2,"Ultra HD");
		Television t3=new Television(141,"Philips 6800 Series","Philips",29999,43.0,"Ultra LED");
		Television t4=new Television(151,"Hyundai smart webOS TV","Hyundai",33000,50.0,"Ultra HD LED");

		
		when(repo.findAll()).thenReturn(Stream.of(t1,t2,t3,t4).collect(Collectors.toList()));
		
		assertSame(4,service.makeFetchAll().size());
		//assertNull(service.makeFetchAll().get(0));		
		
	}
	

	@Test
	void contextLoads() {
	}

}
