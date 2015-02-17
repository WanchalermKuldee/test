package sut.ac.th.serverTeam02;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sut.ac.th.serverTeam02.domain.Manager;
import sut.ac.th.serverTeam02.repository.ManagerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Application.class)
public class ManagerTest {
	@Autowired
	private ManagerRepository Repository;
	
	@Test
	public void testNormalManager() {
		Manager man1 = new Manager();
		
		man1.setNameLineManager("car1");
		man1.setName("panumas");
		man1.setTelphone("0903580757");
		man1.setDetel("Korat");
		man1.setLastname("srisook");
		man1 = Repository.save(man1);
		assertEquals("car1", man1.getNameLineManager());
		assertEquals("panumas", man1.getName());
		assertEquals("srisook",man1.getLastname());
		assertEquals("0903580757",man1.getTelphone());
		assertEquals("Korat",man1.getDetel());
	}
	@Rule
	public ExpectedException thrown = ExpectedException.none(); 
	
	@Test
	public void testNameLineManagerNull() {
		
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		
		Manager normal = new Manager();
		normal.setName("panumas");
		normal.setLastname("srisook");
		normal.setTelphone("0903580757");
		normal.setDetel("Klongpai");
		Repository.save(normal);
	}
	@Test
	public void testNameNull() {
		
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		
		Manager normal = new Manager();
		normal.setNameLineManager("Car1");
		normal.setLastname("srisook");
		normal.setTelphone("0903580757");
		normal.setDetel("Klongpai");
		Repository.save(normal);
	}
public void testLastNameNull() {
		
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		
		Manager normal = new Manager();
		normal.setNameLineManager("Car1");
		normal.setName("panumas");
		normal.setTelphone("0903580757");
		normal.setDetel("Klongpai");
		Repository.save(normal);
	}
	
	@Test
	public void testphoneNull() {
		
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		
		Manager normal = new Manager();
		normal.setNameLineManager("Car1");
		normal.setName("panumas");
		normal.setLastname("srisook");
		normal.setDetel("Klongpai");
		Repository.save(normal);
	}
	@Test
	public void testDetelNull() {
		
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		
		Manager normal = new Manager();
		normal.setNameLineManager("Car1");
		normal.setName("panumas");
		normal.setLastname("srisook");
		normal.setTelphone("0903580757");
		Repository.save(normal);
	}
	@Test
	public void testTelphonePattern() {
		
		thrown.expect(javax.validation.ConstraintViolationException.class);
		
		Manager normal1 = new Manager();
		normal1.setNameLineManager("Car1");
		normal1.setName("panumas");
		normal1.setLastname("srisook");
		normal1.setTelphone("8903580700");
		normal1.setDetel("Klongpai");
		normal1 = Repository.save(normal1);
	}  
	@Test
	public void testTelphoneOnly() {
		
		thrown.expect(javax.validation.ConstraintViolationException.class);
		
		Manager normal1 = new Manager();
		normal1.setNameLineManager("Car1");
		normal1.setName("panumas");
		normal1.setLastname("srisook");
		normal1.setTelphone("090AA80700");
		normal1.setDetel("Klongpai");
		normal1 = Repository.save(normal1);
	} 
	
	
}
