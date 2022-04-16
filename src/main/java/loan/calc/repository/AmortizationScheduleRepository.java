package loan.calc.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import loan.calc.model.AmortizationSchedule;
import loan.calc.model.LoanRequest;
@Repository
public interface AmortizationScheduleRepository extends JpaRepository<AmortizationSchedule, Long> {
	List<AmortizationSchedule> findByLoanRequest(LoanRequest loanRequest);

}
