package com.a3.api.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Administracao extends User {
    
	@Column
	private String address;
	@Column
	private String cover;
	@Column
	private Boolean open;
	
}
