package loan.calc.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import loan.calc.model.AmortizationSchedule;
import loan.calc.model.LoanRequest;
import loan.calc.repository.AmortizationScheduleRepository;

import loan.calc.service.AmortizationScheduleService;

@Service
public class AmortizationScheduleServiceImpl implements AmortizationScheduleService{
	@Autowired
	private AmortizationScheduleRepository amortizationScheduleRepository;

	
	public AmortizationScheduleServiceImpl(AmortizationScheduleRepository repository) {
		super();
		this.amortizationScheduleRepository=repository;
	}

	@Override
	public AmortizationSchedule save(AmortizationSchedule amortizationSchedule) {
		return amortizationScheduleRepository.save(amortizationSchedule);
	}

	@Override
	public List<AmortizationSchedule> findByLoanRequest(LoanRequest loanRequest) {
		
		return loanRequest.getAmortizationSchedules();
	}

	
	 
	}
