package com.esra.mPulse.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esra.mPulse.model.Client;
import com.esra.mPulse.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	public Client save(Client newClient) {
		return clientRepository.save(newClient);
	}

	public Client findByAccountId(Long id) {
		return clientRepository.findByAccountId(id);
	}

	public Client findByMemberId(Long id) {
		return clientRepository.findByClientMemberId(id);
	}

	public Client findByPhoneNumber(String phone) {
		return clientRepository.findByPhoneNumber(phone);
	}
	
    public Client findByClientId(Long id) {
		return clientRepository.findById(id).get();
	}

	public List<Client> saveAll(List<Client> clients){
		Set<String> seenPhone = new HashSet<String>();
		Set<Long> seenMember = new HashSet<Long>();
		List<Client> uniqueClients = new ArrayList<>();
		for(Client client: clients) {
			if(!seenPhone.contains(client.getPhoneNumber()) && 
					!seenMember.contains(client.getClientMemberId())) {
				uniqueClients.add(client);
			}
			seenPhone.add(client.getPhoneNumber());
			seenMember.add(client.getClientMemberId());
		}
		System.out.println(uniqueClients.size()+" records passed duplicate check.");
		return (List<Client>) clientRepository.saveAll(uniqueClients);
	}
}
