package com.fr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_Session")
public class Session {
	
	private int id;
	private Date date_debut;
	private Date date_fin;
	private String sujet;
	private String lieu;
	
	private Specialite specialite;
	
	public Session() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Session(Date date_debut, Date date_fin, String sujet, String lieu) {
		super();
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.sujet = sujet;
		this.lieu = lieu;
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

	@Column(name="Date_debut")
	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	@Column(name="Date_fin")
	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	@Column(name="Sujet")
	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	@Column(name="Lieu")
	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_Specialite")
	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

	@Override
	public String toString() {
		return "Session [id=" + id + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", sujet=" + sujet
				+ ", lieu=" + lieu + "]";
	}
	
	

}
