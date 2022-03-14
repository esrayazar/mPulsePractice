package com.esra.mPulse.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.esra.mPulse.model.Client;
import com.esra.mPulse.service.ClientService;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private ClientService clientService;

	// Get a member for a given Account ID
	@GetMapping("/account/{id}")
	public Client getMemberByAcountId(@PathVariable("id") Long id) {
		return clientService.findByAccountId(id);
	}

	// Get a member by their ID
	@GetMapping("/member/{id}")
	public Client getMemberById(@PathVariable("id") Long id) {
		return clientService.findByMemberId(id);
	}

	// Get a member by their Phone Number
	@GetMapping("/phone/{phone}")
	public Client getMemberByPhoneNumber(@PathVariable("phone") String phone) {
		return clientService.findByPhoneNumber(phone);
	}

	// Get a member by their Client Member ID
	@GetMapping("/client/{id}")
	public Client getMemberByClientId(@PathVariable("id") Long id) {
		return clientService.findByClientId(id);
	}

	// Create a new Member
	@PostMapping("/new/member")
	public Client createMember(@RequestBody Client newClient) {
		Client client;
		try {
			client = clientService.save(newClient);
		} catch (Exception e) {
			System.out.println(e);
			client = clientService.findByMemberId(newClient.getClientMemberId());
		}
		return client;
	}

	// Batch insert members by uploading a CSV (similar to the one provided)
	@PostMapping("/new/batch")
	public int createMembersInBatch(@RequestBody MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		int result = 0;
		try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

			// create csv bean reader
			CsvToBean<Client> csvToBean = new CsvToBeanBuilder(reader).withType(Client.class)
					.withIgnoreLeadingWhiteSpace(true).build();

			// convert `CsvToBean` object to list of users
			List<Client> clients = csvToBean.parse();
			System.out.println(clients.size() + " records are going to be loaded.");
			List<Client> batch = clientService.saveAll(clients);
			result = batch.size();

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return result;
	}

}
