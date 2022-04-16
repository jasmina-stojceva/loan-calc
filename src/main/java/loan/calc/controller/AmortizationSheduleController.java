package loan.calc.controller;
import loan.calc.model.AmortizationSchedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import loan.calc.repository.LoanRequestRepository;
import loan.calc.service.impl.LoanRequestServiceImpl;

@RestController
@RequestMapping("/api")
public class AmortizationSheduleController {
	
	@Autowired
	private LoanRequestRepository loanRequestRepository;
	
	
	
	  @GetMapping("/loanRequests/{loanId}/amortizationSchedule") 
	  public List<AmortizationSchedule> getAllAmotrizationByLoanID(@PathVariable
	  (value="loanId") Long loanId){ 
		  return loanRequestRepository.getById(loanId).getAmortizationSchedules();
	  
		
		  
		 
	  }
	 
}
