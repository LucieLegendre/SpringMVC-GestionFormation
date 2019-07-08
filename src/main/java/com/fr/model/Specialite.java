package com.fr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_Specialite")
public class Specialite {

	private int id;
	private String libelle;
	
	public Specialite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Specialite(String libelle) {
		super();
		this.libelle = libelle;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="Libelle")
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Specialite [id=" + id + ", libelle=" + libelle + "]";
	}
	
	
}
