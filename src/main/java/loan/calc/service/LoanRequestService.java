package loan.calc.service;

import java.util.List;

import loan.calc.model.LoanRequest;

public interface LoanRequestService {
	LoanRequest save(LoanRequest loanRequest);
	LoanRequest findById(Long id);
	List<LoanRequest> findAll();
}
