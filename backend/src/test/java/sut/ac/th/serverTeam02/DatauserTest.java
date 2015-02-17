package sut.ac.th.serverTeam02;

import static org.junit.Assert.assertEquals;




import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sut.ac.th.serverTeam02.domain.Datauser;
import sut.ac.th.serverTeam02.repository.DatauserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Application.class)
public class DatauserTest {
	@Autowired
	private DatauserRepository repo;
	
	@Test
	public void testNormalUser() {
		Datauser u1 = new Datauser();
		u1.setUsername("Yannadech");
		u1.setAge(21);
		u1.setAddress("samutprakan");
		u1.setTel("0982724835");
		u1.setEmail("pee@hotmailcom");
		u1 = repo.save(u1);
		assertEquals("Yannadech",u1.getUsername());
		assertEquals(21,u1.getAge());
		assertEquals("samutprakan",u1.getAddress());
		assertEquals("0982724835",u1.getTel());
		assertEquals("pee@hotmailcom",u1.getEmail());
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none(); 
	
	@Test
	public void testNameNull() {
		
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		
		Datauser u1 = new Datauser();
		
		u1.setAge(21);
		u1.setAddress("samutprakan");
		u1.setTel("0982724835");
		u1.setEmail("pee@hotmailcom");
		u1 = repo.save(u1);
	}
	
	@Test
	public void testNamefail() {
		
		thrown.expect(javax.validation.ConstraintViolationException.class);
		
		Datauser u1 = new Datauser();
		u1.setUsername("Yannadech123");
		u1.setAge(21);
		u1.setAddress("samutprakan");
		u1.setTel("0982724835");
		u1.setEmail("pee@hotmailcom");
		u1 = repo.save(u1);
	}

	
	@Test
	public void testAddressNull() {
		
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		Datauser u1 = new Datauser();
		
		u1.setUsername("Yannadech");
		u1.setAge(21);
		u1.setTel("0982724835");
		u1.setEmail("pee@hotmailcom");
		u1 = repo.save(u1);
	}
	@Test
	public void testTelNull() {
		 thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
	Datauser u1 = new Datauser();
	u1.setUsername("Yannadech");
	u1.setAge(21);
	u1.setAddress("samutprakan");
	u1.setEmail("pee@hotmailcom");
	u1 = repo.save(u1);
	}
	@Test
	public void testTelfail() {
		
		thrown.expect(javax.validation.ConstraintViolationException.class);
		
		Datauser u1 = new Datauser();
		u1.setUsername("Yannadech123");
		u1.setAge(21);
		u1.setAddress("samutprakan");
		u1.setTel("0982724835AAAAAA");
		u1.setEmail("pee@hotmailcom");
		u1 = repo.save(u1);
	}
	
	@Test
	public void testEmailNull() {
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		Datauser u1 = new Datauser();
		u1.setUsername("Yannadech");
		u1.setAge(21);
		u1.setAddress("samutprakan");
		u1.setTel("0982724835");
		u1 = repo.save(u1);
	}
	}
