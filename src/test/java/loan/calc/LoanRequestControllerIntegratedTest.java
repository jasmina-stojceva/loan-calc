package loan.calc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import loan.calc.model.LoanRequest;
import loan.calc.repository.LoanRequestRepository;
import loan.calc.service.impl.LoanRequestServiceImpl;


@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc


public class LoanRequestControllerIntegratedTest {
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private LoanRequestServiceImpl loanRequestService;
	
	@Test
	public void givenLoanRequest_whenGetLoanRequest_thenStatus200()
			  throws Exception {
		LoanRequest loanRequest = new LoanRequest(20000.0,4.0,12);
		loanRequestService.save(loanRequest);
		
		mvc.perform(get("/api/loanRequests")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$[1].loanAmount", is(loanRequest.getLoanAmount())));
			      

	}

}
