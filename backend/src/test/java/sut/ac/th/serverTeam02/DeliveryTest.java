package sut.ac.th.serverTeam02;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sut.ac.th.serverTeam02.domain.Delivery;
import sut.ac.th.serverTeam02.repository.DeliveryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Application.class)
public class DeliveryTest {
	
	@Autowired
	private DeliveryRepository repo;
	
	@Test
	public void testNormalDelivery() {
		Delivery deli = new Delivery();
		deli.setDayTotal("3");
		deli.setDeliveryType("plane");
		deli.setCustomername("pond");
		deli = repo.save(deli);
		assertEquals("3", deli.getDayTotal());
		assertEquals("plane", deli.getDeliveryType());
		assertEquals("pond",deli.getCustomername());
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testCustomernameNull() {
		
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		
		Delivery deli = new Delivery();
		deli.setDayTotal("3");
		deli.setDeliveryType("plane");
		deli = repo.save(deli);
	}
	
	@Test
	public void testCustomernamePattern() {
		
		thrown.expect(javax.validation.ConstraintViolationException.class);
		
		Delivery deli = new Delivery();
		deli.setDayTotal("3");
		deli.setDeliveryType("plane");
		deli.setCustomername("_");	
		deli = repo.save(deli);
	}
	
	@Test
	public void testDayPattern() {
		
		thrown.expect(javax.validation.ConstraintViolationException.class);
		
		Delivery deli = new Delivery();
		deli.setDayTotal("1");
		deli.setDeliveryType("plane");
		deli.setCustomername("pond");	
		deli = repo.save(deli);
	}
	
	@Test
	public void testTypePattern() {
		
		thrown.expect(javax.validation.ConstraintViolationException.class);
		
		Delivery deli = new Delivery();
		deli.setDayTotal("3");
		deli.setDeliveryType("bicycle");
		deli.setCustomername("pond");	
		deli = repo.save(deli);
	}
	
	@Test
	public void tesCustomernameUnique() {
		
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);

		Delivery deli = new Delivery();
		deli.setDayTotal("3");
		deli.setDeliveryType("plane");
		deli.setCustomername("pondny");	
		deli = repo.save(deli);

		Delivery deli2 = new Delivery();
		deli2.setDayTotal("7");
		deli2.setDeliveryType("truck");
		deli2.setCustomername("pondny");	
		deli2 = repo.save(deli2);
	}


}
