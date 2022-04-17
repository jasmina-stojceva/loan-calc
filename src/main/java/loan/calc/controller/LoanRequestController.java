package loan.calc.controller;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import loan.calc.repository.LoanRequestRepository;
import loan.calc.service.impl.LoanRequestServiceImpl;
import loan.calc.exception.ResourceNotFoundException;
import loan.calc.model.LoanRequest;

@RestController
@RequestMapping("/api")
public class LoanRequestController {
	@Autowired
	private LoanRequestRepository loanRequestRepository;
	
	@Autowired
	private LoanRequestServiceImpl loanRequestService;

	
	
	@GetMapping("/loanRequests")
	public ResponseEntity<List<LoanRequest>> getAllLoanRequests(){
		List<LoanRequest> loanRequests = new ArrayList<>();
		loanRequestRepository.findAll().forEach(loanRequests::add);
		if (loanRequests.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} 
			
		return new ResponseEntity<>(loanRequests, HttpStatus.OK);
		
	}
	
	@GetMapping("/loanRequests/{id}")
	public ResponseEntity<LoanRequest> getLoanRequestById(@PathVariable("id") long id){
		LoanRequest loanRequest=loanRequestRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Not found Loan Request with id " + id));
		return new ResponseEntity<>(loanRequest, HttpStatus.OK);	
	}
	
	@PostMapping("/save-loan")
    public 
    LoanRequest newLoanRequest(@Valid @RequestBody LoanRequest newLoanRequest) {
        return loanRequestService.save(newLoanRequest);
    }

}
