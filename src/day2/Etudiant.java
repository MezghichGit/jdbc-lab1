package day2;

import java.io.Serializable;

public class Etudiant implements Serializable{

	private int age;
	public Etudiant(String nom,int age) {
		super();
		this.age = age;
		this.nom = nom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	private String nom;
	@Override
	public String toString() {
		return "Etudiant [age=" + age + ", nom=" + nom + "]";
	}
}
