package sut.ac.th.serverTeam02;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sut.ac.th.serverTeam02.domain.Manufac;
import sut.ac.th.serverTeam02.repository.ManufacRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Application.class)
public class ManufacTest {

	@Autowired
	private ManufacRepository manufacRepository;
	
	@Test
	public void testNormal() {
	Manufac order = new Manufac();
	order.setProductname("gaming");
	order.setCustomername("pak");
	order.setAmount(1);
	order.setAmountram(1);
	order.setAmountcpu(1);
	order.setAmountmainboard(1);
	order.setAmountvga(1);
	order.setAmountdvd(1);
	order.setAmountaccessoeies(1);
	manufacRepository.save(order);
	assertEquals("pak", order.getCustomername());	
	assertEquals("gaming", order.getProductname());
	assertEquals(1, order.getAmount());	
	assertEquals(1, order.getAmountram());
	assertEquals(1, order.getAmountmainboard());
	assertEquals(1, order.getAmountvga());
	assertEquals(1, order.getAmountdvd());
	assertEquals(1, order.getAmountaccessoeies());
	
	}
	
}
