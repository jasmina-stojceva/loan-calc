package loan.calc.service;

import java.util.List;

import loan.calc.model.AmortizationSchedule;
import loan.calc.model.LoanRequest;

public interface AmortizationScheduleService {
	AmortizationSchedule save(AmortizationSchedule amortizationSchedule);
	List<AmortizationSchedule> findByLoanRequest(LoanRequest loanRequest);
}
