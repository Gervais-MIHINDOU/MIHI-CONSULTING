package com.mihi.MIHI.model;

import org.springframework.stereotype.Service;

@Service
public class Utilisateur {
private String nom;
private String prenom;
private String login;
private String tel;
private String post;
private String salaire;
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public String getPost() {
	return post;
}
public void setPost(String post) {
	this.post = post;
}
public String getSalaire() {
	return salaire;
}
public void setSalaire(String salaire) {
	this.salaire = salaire;
}
}
