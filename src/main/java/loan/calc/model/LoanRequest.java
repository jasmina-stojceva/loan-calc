package loan.calc.model;


import java.util.ArrayList;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;



@Entity
@Table(name="LoanRequest")
@Data

public class LoanRequest {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="loan_id")
	private Long loanId;
	
	private double loanAmount;
	private double interestRate;
	private int loanTerm;
	
	public LoanRequest(double loanAmount, double interestRate, int loanTerm){
		this.loanAmount=loanAmount;
		this.interestRate=interestRate;
		this.loanTerm=loanTerm;
	}
	
	public LoanRequest() {}
	
	
	
	
	  @OneToMany(mappedBy = "loanRequest", cascade = CascadeType.PERSIST) 
	  @JsonManagedReference
	  private List<AmortizationSchedule> amortizationSchedules=new ArrayList<>();
	 	 
	 
 
}
