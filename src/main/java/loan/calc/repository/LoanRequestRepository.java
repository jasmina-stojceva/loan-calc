package loan.calc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import loan.calc.model.LoanRequest;
@Repository
public interface LoanRequestRepository extends JpaRepository<LoanRequest, Long> {
}
