package com.mihi.MIHI.service;

import org.springframework.stereotype.Service;

import com.mihi.MIHI.model.Utilisateur;

import java.util.Date;

@Service
public class Candidature {
  
	public String rendezvousTest(Utilisateur utilisateur,Date date) {
		
		String message;
	
		message ="Bonjour "+utilisateur.getNom()+" "+utilisateur.getPrenom()+"\n\nVous avez émis le souhait de rejoindre nos équipes\n"
				+ "Nous vous invitons à passer un Test d'algorithme sur le post de "+utilisateur.getPost()+"\n qui se fera à Libreville le "+date+" à 17h00 à coté de la station service de Petro Gabon des charbonnages\n\nMerci Pour votre compéhension\n\nLa direction MIHI CONSULTING";
		
		
		return message;
	}
	
public String RespectrendezvousTest(Utilisateur utilisateur,Date date) {
		
		String message;
	
		message ="Bonjour cher administrateurs\nVous venez de recevoir une demande du candidat réprésenté par"
				+ " "+utilisateur.getNom()+" "+utilisateur.getPrenom()+"\nsur le poste de "+utilisateur.getPost()+" à 17h00 au charbonnage \nVous etes invité à évaluer ce candidat le "+date+" à 17h veuillez vous munir du Test d'algorithme adéquat pour l'évaluer\nLe salaire qu'il souhaite est : "+utilisateur.getSalaire()+"\n\nMerci Pour votre compéhension\nLa direction MIHI CONSULTING";
		
		
		return message;
}            

}