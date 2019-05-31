package coop.tecso.examen.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.dto.AccountDto;
import coop.tecso.examen.dto.CountryDto;
import coop.tecso.examen.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody AccountDto account) {
		
		accountService.save(account);
    	return new ResponseEntity<String>("Cuenta guardada correctamente", HttpStatus.OK);
    }
	
	@PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam(name = "account") String account) {
		
		accountService.delete(Long.valueOf(account));
    	return new ResponseEntity<String>("Cuenta borrada correctamente", HttpStatus.OK);
    }
	
	@GetMapping("/findAll")
	public List<AccountDto> findAll() {
		return accountService.findAll();
	}
	
}
