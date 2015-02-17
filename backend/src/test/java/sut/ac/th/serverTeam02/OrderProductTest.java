package sut.ac.th.serverTeam02;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sut.ac.th.serverTeam02.domain.OrderProduct;
import sut.ac.th.serverTeam02.repository.OrderProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Application.class)
public class OrderProductTest {

	@Autowired
	private OrderProductRepository orderRepository;
	
	@Test
	public void testNormal() {
		OrderProduct order = new OrderProduct();
		order.setCustomername("pop");
		order.setEmailcustomer("pop@hotmail.com");
		order.setProductname("gaming");	
		order.setAmount(1);	
		order.setPrice(38000);	
		order.setTotalprice(38000);
		orderRepository.save(order);
		assertEquals("pop", order.getCustomername());
		assertEquals("pop@hotmail.com", order.getEmailcustomer());
		assertEquals("gaming", order.getProductname());
		assertEquals(1, order.getAmount());
		assertEquals(38000, order.getPrice());
		assertEquals(38000, order.getTotalprice());
	
	}
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testCustomernamePattern() {
		
		thrown.expect(javax.validation.ConstraintViolationException.class);
		
		  OrderProduct order = new OrderProduct();
		  	order.setCustomername("3");
			order.setEmailcustomer("pophotmailcom");
			order.setProductname("gaming");	
			order.setAmount(1);	
			order.setPrice(38000);	
			order.setTotalprice(38000);
			order = orderRepository.save(order);
	}

	@Test
	public void testCustomernameUnique(){
		  thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		
		  OrderProduct order1 = new OrderProduct();
			order1.setCustomername("popza");
			order1.setEmailcustomer("pophotmailcom");
			order1.setProductname("gaming");	
			order1.setAmount(1);	
			order1.setPrice(38000);	
			order1.setTotalprice(38000);
			order1 = orderRepository.save(order1);
			
			 OrderProduct order2 = new OrderProduct();
				order2.setCustomername("popza");
				order2.setEmailcustomer("popzzhotmailcom");
				order2.setProductname("eco");	
				order2.setAmount(2);	
				order2.setPrice(38000);	
				order2.setTotalprice(84000);
				order2 = orderRepository.save(order2);
		  	
	}
	
	@Test
	public void testCustomernameNull() {
		
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		
		  OrderProduct order = new OrderProduct();
			order.setEmailcustomer("pophotmailcom");
			order.setProductname("gaming");	
			order.setAmount(1);	
			order.setPrice(38000);	
			order.setTotalprice(38000);
			order = orderRepository.save(order);
	}
	
	@Test
	public void testEmailcustomerNull() {
		
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		
		  OrderProduct order = new OrderProduct();
		  	order.setCustomername("pop");
			order.setProductname("gaming");	
			order.setAmount(1);	
			order.setPrice(38000);	
			order.setTotalprice(38000);
			order = orderRepository.save(order);
	}

	@Test
	public void testProductnameNull() {
		
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		
		  OrderProduct order = new OrderProduct();
		  	order.setCustomername("pop");
			order.setEmailcustomer("pophotmailcom");
			order.setAmount(1);	
			order.setPrice(38000);	
			order.setTotalprice(38000);
			order = orderRepository.save(order);
	}
	
	@Test
	public void testProductnameFail() {
		
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		
		  OrderProduct order = new OrderProduct();
		  	order.setCustomername("pop");
			order.setEmailcustomer("pophotmailcom");
			order.setProductname("com");	
			order.setAmount(1);	
			order.setPrice(38000);	
			order.setTotalprice(38000);
			order = orderRepository.save(order);
	}
	
	

	
}

