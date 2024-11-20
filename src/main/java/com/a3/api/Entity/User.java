package com.a3.api.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table()
public class User {
    
	@Id
	private Long Id;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String address;
	@Column
	private String avatar;
	@Column
	private String cover;
	@Column
	private Boolean open;
	
	public User() {}

	public User(long id, String name, String email, String address, String avatar, String cover, boolean open) {
		super();
		Id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.avatar = avatar;
		this.cover = cover;
		this.open = open;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}
	
	
	
	
}
