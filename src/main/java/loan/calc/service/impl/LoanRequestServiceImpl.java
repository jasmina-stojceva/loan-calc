package loan.calc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import loan.calc.model.AmortizationSchedule;
import loan.calc.model.LoanRequest;

import loan.calc.repository.LoanRequestRepository;
import loan.calc.service.LoanRequestService;
@Service
public class LoanRequestServiceImpl implements LoanRequestService{
	@Autowired
	private LoanRequestRepository loanRequestRepository;

	
	public LoanRequestServiceImpl(LoanRequestRepository loanRequestRepository) {
		super();
		this.loanRequestRepository = loanRequestRepository;
	}

	@Override
	public LoanRequest save(LoanRequest loanRequest) {
		List<AmortizationSchedule> amortizationScheduleList = new ArrayList<>();
		
	        
	      	double payment, interestRatePerMonth, interestAmount, principalAmount, balanceOwed;
	      	double loanAmount = loanRequest.getLoanAmount();
			int months=loanRequest.getLoanTerm();
			interestRatePerMonth = loanRequest.getInterestRate()/100.0/12.0;
			balanceOwed=loanAmount;
			
			do {
			payment = loanAmount*interestRatePerMonth*Math.pow(interestRatePerMonth+1, months)/(Math.pow(interestRatePerMonth+1, months)-1);
			interestAmount = interestRatePerMonth*balanceOwed;
			principalAmount = payment - interestAmount;
			balanceOwed = balanceOwed - principalAmount;
			
			amortizationScheduleList.add(new AmortizationSchedule(payment, principalAmount, interestAmount, balanceOwed, loanRequest));
			} while (balanceOwed>0);
			
			
			loanRequest.setAmortizationSchedules(amortizationScheduleList);
		
		return loanRequestRepository.save(loanRequest);
			
	}

}
