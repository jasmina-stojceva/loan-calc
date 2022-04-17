package loan.calc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import loan.calc.model.LoanRequest;
import loan.calc.service.LoanRequestService;


@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class LoanRequestServiceTest {
	@Autowired
	LoanRequestService loanRequestService;
	
	
	
	@BeforeAll
	void setup() {
		LoanRequest loanRequest = new LoanRequest(2000.0,5.0,24);
		loanRequestService.save(loanRequest);
	}
	
	
	@Test
	void testFindById() {
		
		LoanRequest loanRequest=loanRequestService.findById(2L);
		assertEquals(24, loanRequest.getLoanTerm());
		
	}
	
	@Test
	void testFindAll() {
		Assertions.assertFalse(loanRequestService.findAll().isEmpty());
	}
	

}
