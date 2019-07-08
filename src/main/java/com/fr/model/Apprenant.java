package com.fr.model;

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
@Table(name = "tb_Apprenant")
public class Apprenant {

	private int id;
	private String idpe;
	private String nom;
	private String prenom;
	private int age;
	private float indemnite;
	private String diplome;

	private Session session;
	

	public Apprenant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Apprenant(String idpe, String nom, String prenom, int age, float indemnite, String diplome,
			Session session) {
		super();
		this.idpe = idpe;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.indemnite = indemnite;
		this.diplome = diplome;
		this.session = session;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "Identifiant_PoleEmploi")
	public String getIdpe() {
		return idpe;
	}

	public void setIdpe(String idpe) {
		this.idpe = idpe;
	}

	@Column(name = "Nom")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "Prenom")
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "Age")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Column(name = "Indemnites")
	public float getIndemnite() {
		return indemnite;
	}

	public void setIndemnite(float indemnite) {
		this.indemnite = indemnite;
	}

	@Column(name = "Diplomes")
	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_Session")
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public String toString() {
		return "Apprenant [id=" + id + ", idpe=" + idpe + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age
				+ ", indemnite=" + indemnite + ", diplome=" + diplome + ", session=" + session + "]";
	}



}
