package com.poslovnaInformatika.banka.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "korisnici")
@Getter
@Setter
public class Korisnik implements UserDetails {

	@Id	
	@Column(name = "username", unique = true, nullable = false)
//	@NotEmpty(message = "{validation.username.NotEmpty}")
	private String username;
	
	@Column(name = "password", nullable = false)
//	@NotEmpty(message = "{validation.password.NotEmpty}")
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authorities",
            joinColumns = @JoinColumn(name = "user_username", referencedColumnName = "username"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
	private Collection<Authority> authorities;
	
	@OneToOne
	private Klijent klijent;

	public Korisnik() {}

	public Korisnik(String username, String password, Collection<Authority> authorities, Klijent klijent) {
		this.username = username;
		this.password = password;		
		this.authorities = authorities;
		this.klijent = klijent;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
