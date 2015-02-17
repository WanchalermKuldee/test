package sut.ac.th.serverTeam02;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



import sut.ac.th.serverTeam02.domain.Prob;
import sut.ac.th.serverTeam02.repository.ProbRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Application.class)
public class ProbTest {
	@Autowired
	private ProbRepository probRepository;
	@Test
	public void testNormal(){
		Prob bobo = new Prob();
		bobo.setTitlepb("issueproblem");
		bobo.setDetailpb("detailproblem");
		probRepository.save(bobo);
		assertEquals("issueproblem", bobo.getTitlepb());
		assertEquals("detailproblem", bobo.getDetailpb());
	}
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testTitlepbNull() {
		
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		
		Prob bobo = new Prob();		
		bobo.setDetailpb("detailproblem");
		probRepository.save(bobo);
	}
	@Test
	public void testDetailpbNull() {
		
		thrown.expect(org.springframework.dao.DataIntegrityViolationException.class);
		
		Prob bobo = new Prob();		
		bobo.setTitlepb("issueproblem");
		probRepository.save(bobo);
	}
	@Test
	public void testPattern() {
		
		thrown.expect(javax.validation.ConstraintViolationException.class);
		
		Prob bobo = new Prob();		
		bobo.setTitlepb("____");
		bobo.setDetailpb("detailproblem1234");
		probRepository.save(bobo);
	}
	
	@Test
	public void testPattern1() {
		
		thrown.expect(javax.validation.ConstraintViolationException.class);
		
		Prob bobo = new Prob();		
		bobo.setTitlepb("issueproblem1234");
		bobo.setDetailpb("____");
		probRepository.save(bobo);
	}
	@Test
	public void testPattern3() {
		
		thrown.expect(javax.validation.ConstraintViolationException.class);
		
		Prob bobo = new Prob();		
		bobo.setTitlepb("issue problem 1234");
		bobo.setDetailpb("____");
		probRepository.save(bobo);
	}
	

}
