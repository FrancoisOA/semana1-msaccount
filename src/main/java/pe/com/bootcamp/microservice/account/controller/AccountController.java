package pe.com.bootcamp.microservice.account.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pe.com.bootcamp.microservice.account.dto.AccountDTO;
import pe.com.bootcamp.microservice.account.service.impl.AccountServiceImpl;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/account")
public class AccountController {

	@Autowired
	private final AccountServiceImpl accountServiceImpl;

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void createAccountDTO(@RequestBody AccountDTO accountDTO) {
		accountServiceImpl.createAcc(accountDTO);
	}

	@GetMapping(value = "/get/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	@ResponseBody
	public Flux<AccountDTO> findAll() {
		return accountServiceImpl.findAllAcc();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Mono<AccountDTO>> findAccountDTOById(@PathVariable("id") String id) {
		Mono<AccountDTO> account = accountServiceImpl.findByAccId(id);
		return new ResponseEntity<Mono<AccountDTO>>(account, account != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<AccountDTO> update(@PathVariable("id") String id, @RequestBody AccountDTO accountDTO) {
		return accountServiceImpl.updateAcc(id, accountDTO);
	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") String id) {
		accountServiceImpl.deleteAcc(id).subscribe();
	}
}