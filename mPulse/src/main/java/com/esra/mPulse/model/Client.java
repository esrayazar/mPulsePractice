package com.esra.mPulse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.opencsv.bean.CsvBindByName;

import lombok.Data;

@Data
@Entity
@Table(name="client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@CsvBindByName(column= "first_name")
	private String firstName;
	@CsvBindByName(column= "last_name")
	private String lastName;
	@CsvBindByName(column= "phone_number")
	@Column(unique=true)
	private String phoneNumber;
	@CsvBindByName(column= "client_member_id")
	@Column(unique=true)
	private Long clientMemberId;
	@CsvBindByName(column= "account_id")
	private Long accountId;
}
