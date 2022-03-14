package com.esra.mPulse.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esra.mPulse.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
	List<Client> findAll();
	
	Client findByAccountId(Long id);
	
	Client findByClientMemberId(Long id);
	
	Client findByPhoneNumber(String phoneNumber);
}
