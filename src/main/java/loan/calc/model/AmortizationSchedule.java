package loan.calc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Table(name="AmortizationSchedule")
@Data

public class AmortizationSchedule {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="amortization_Id")
	private  Long amortizationId;
	private double paymentAmount;
	private double principleAmount;
	private double interestAmount;
	private double balanceOwed;
	
	  @ManyToOne(fetch = FetchType.LAZY)
	  
	  @JoinColumn(name="loan_id", nullable=false, referencedColumnName = "loan_id")
	  @JsonBackReference
	  private LoanRequest loanRequest;
	  public AmortizationSchedule(double paymentAmount, double principleAmount, double interestAmount,
			  double balanceOwed, LoanRequest loanRequest) {
		  this.paymentAmount =paymentAmount;
		  this.principleAmount=principleAmount;
		  this.interestAmount = interestAmount;
		  this.balanceOwed = balanceOwed;
		  this.loanRequest = loanRequest;
	  }
	  
	  public AmortizationSchedule() {}
}
