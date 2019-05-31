package coop.tecso.examen.service;

import java.math.BigDecimal;
import java.util.List;

import coop.tecso.examen.dto.AccountDto;

public interface AccountService {
	
	public void save(AccountDto account); 
	
	public void delete(Long accountNumber);
	
	public List<AccountDto> findAll();
}
