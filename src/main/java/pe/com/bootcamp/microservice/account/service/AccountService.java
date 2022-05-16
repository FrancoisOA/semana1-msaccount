package pe.com.bootcamp.microservice.account.service;

import pe.com.bootcamp.microservice.account.dto.AccountDTO;
import pe.com.bootcamp.microservice.account.entity.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {
		
	public Flux<Account> getAllAccount();
	public Mono<AccountDTO> createAccount(Mono<AccountDTO> account);
	public Mono<Account> updateAccount(String id, Account account);
	public Mono<Account> deleteAccount(String id);
	public Mono<Account> getAccountById(String id);
}
