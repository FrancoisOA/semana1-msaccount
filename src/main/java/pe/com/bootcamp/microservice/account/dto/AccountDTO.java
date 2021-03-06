package pe.com.bootcamp.microservice.account.dto;
 
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Document(collection = "tb_account")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AccountDTO {
	@Id
	private String id;
	private String typeAccount;
	private String profileAccount;
	private String condition;
	private String idCustomer;
	private int numMaxDeposit;
	private int numMaxWithdraw;
	private String currency;
	private double initialAmount;
	private double currentAmount;
	private double minAmountAverage;	
}