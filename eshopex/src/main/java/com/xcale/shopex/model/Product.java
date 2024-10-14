package com.xcale.shopex.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8231159319429252605L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	//newInvitation.setExpirationDate(LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis() + (INVITATION_VALIDITY * 60000)), ZoneId.systemDefault()));
	
	@Column
	private String name;
	
	@Column
	private float price;
}
