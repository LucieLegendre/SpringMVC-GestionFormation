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
@Table(name="tb_Formateur")
public class Formateur {

	private int id;
	private String identifiant;
	private String nom;
	private String prenom;
	private int age;
	private float salaire;
	
	private Session session;
	private Specialite specialite;
	
	
	public Formateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Formateur(String identifiant, String nom, String prenom, int age, float salaire, Session session,
			Specialite specialite) {
		super();
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.salaire = salaire;
		this.session = session;
		this.specialite = specialite;
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

	@Column(name="Identifiant")
	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	@Column(name="Nom")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name="Prenom")
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name="Age")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Column(name="Salaire")
	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "id_Session")
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "id_Specialite")
	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

	@Override
	public String toString() {
		return "Formateur [id=" + id + ", identifiant=" + identifiant + ", nom=" + nom + ", prenom=" + prenom + ", age="
				+ age + ", salaire=" + salaire + ", session=" + session + ", specialite=" + specialite + "]";
	}
	
	
	
}
