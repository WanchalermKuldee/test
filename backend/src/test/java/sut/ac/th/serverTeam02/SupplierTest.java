package sut.ac.th.serverTeam02;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sut.ac.th.serverTeam02.domain.Supplier;
import sut.ac.th.serverTeam02.repository.SupplierRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Application.class)
public class SupplierTest {
	
	@Autowired
	private SupplierRepository repo;
	
	@Test
	public void testNormalSupplies() {
		Supplier sp = new Supplier();
		sp.setCpu(1);
		sp.setMainboard(1);
		sp.setRam(1);
		sp.setVga(1);
		sp.setDvd(1);
		sp.setAcces(1);
		sp.setPrice(1);
		sp.setEmp("wiwat");
		sp = repo.save(sp);
		assertEquals(1, sp.getCpu());
		assertEquals(1, sp.getMainboard());
		assertEquals(1, sp.getRam());
		assertEquals(1, sp.getVga());
		assertEquals(1, sp.getDvd());
		assertEquals(1, sp.getAcces());
		assertEquals(1, sp.getPrice());
		assertEquals("wiwat", sp.getEmp());
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testEmpNull() {
		
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		
		Supplier sp = new Supplier();
		sp.setCpu(1);
		sp.setMainboard(1);
		sp.setRam(1);
		sp.setVga(1);
		sp.setDvd(1);
		sp.setAcces(1);
		sp.setPrice(1);
		sp = repo.save(sp);
		
	}
	
	@Test
	public void testEmpPattern() {
		
		thrown.expect(javax.validation.ConstraintViolationException.class);
		
		Supplier sp = new Supplier();
		sp.setCpu(1);
		sp.setMainboard(1);
		sp.setRam(1);
		sp.setVga(1);
		sp.setDvd(1);
		sp.setAcces(1);
		sp.setPrice(1);
		sp.setEmp("wiwat1");
		sp = repo.save(sp);
	}
	
	@Test
	public void tesEmpUnique() {
		
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);

		Supplier sp = new Supplier();
		sp.setCpu(1);
		sp.setMainboard(1);
		sp.setRam(1);
		sp.setVga(1);
		sp.setDvd(1);
		sp.setAcces(1);
		sp.setPrice(1);
		sp.setEmp("wiwat");
		sp = repo.save(sp);

		Supplier sp2 = new Supplier();
		sp2.setCpu(1);
		sp2.setMainboard(1);
		sp2.setRam(1);
		sp2.setVga(1);
		sp2.setDvd(1);
		sp2.setAcces(1);
		sp2.setPrice(1);
		sp2.setEmp("wiwat");
		sp2 = repo.save(sp2);
	}

}
