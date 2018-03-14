package com.example.harjoitustyo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Elokuva {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String nimi;
	private String ohjaaja;
	private long arvio;
	private String kommentti;
	
	
	
	public Elokuva( String nimi, String ohjaaja, long arvio, String kommentti) {
		super();
		
		this.nimi = nimi;
		this.ohjaaja = ohjaaja;
		this.arvio = arvio;
		this.kommentti = kommentti;
	}
	
	
	
	public Elokuva() {
		super();
		this.nimi=null;
		this.ohjaaja=null;
		this.arvio=0;
		this.kommentti=null;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public String getOhjaaja() {
		return ohjaaja;
	}
	public void setOhjaaja(String ohjaaja) {
		this.ohjaaja = ohjaaja;
	}
	public long getArvio() {
		return arvio;
	}
	public void setArvio(long arvio) {
		this.arvio = arvio;
	}
	public String getKommentti() {
		return kommentti;
	}
	public void setKommentti(String kommentti) {
		this.kommentti = kommentti;
	}



	@Override
	public String toString() {
		return "Elokuva [id=" + id + ", nimi=" + nimi + ", ohjaaja=" + ohjaaja + ", arvio=" + arvio + ", kommentti="
				+ kommentti + "]";
	}
	
	
}
