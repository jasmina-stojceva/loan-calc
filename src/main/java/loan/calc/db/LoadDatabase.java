package loan.calc.db;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import loan.calc.model.LoanRequest;

import loan.calc.service.impl.LoanRequestServiceImpl;

@Configuration
public class LoadDatabase {


	
	@Bean
	  CommandLineRunner initDatabase(LoanRequestServiceImpl loanRequestService) {
		return args -> {
			
			  LoanRequest loanRequest = new LoanRequest(1000,5,10);
			  loanRequestService.save(loanRequest);
			 
	};
	}
}