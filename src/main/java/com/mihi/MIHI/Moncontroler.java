package com.mihi.MIHI;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mihi.MIHI.model.Utilisateur;
import com.mihi.MIHI.service.Candidature;
import com.mihi.MIHI.service.GervaisMail;

@Controller
public class Moncontroler {
	
	static Logger logger = Logger.getLogger(Moncontroler.class);
	
	@Resource
	Candidature candidature;
	
	@Resource
    Utilisateur utilisateur;
	
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String HOME(final ModelMap model) {
		
		return "page/index";
	}
	
	@RequestMapping(value="/monToken", method = RequestMethod.GET)
	public String MonToken(final ModelMap model, @RequestParam(value = "token") final String token) {
		
	System.out.println("la valeur de notre token est : "+token);	
		return "page/index";
	}
	
	
	
	
	
	@RequestMapping(value="/newsletter", method = RequestMethod.POST)
	public String Newsletter(final ModelMap model, @RequestParam(value = "email") final String email) {
		System.out.println("la valeur de l'émail est : "+email);
		
		
		String host= "smtp.gmail.com";
		String port ="587";
		String userName = "consultingmihi33@gmail.com";
		String password = "fionalysia";
        String subject = "NewsLetter";
		
		String message1 ="Bonjour Cher collaborateurs\n\nLe visiteur ayant l'adresse mail : "+email+" , souhaite recevoir nos Newsletters \n\nLa direction MIHI CONSULTING ";
				
		String message2 ="Bonjour Nous avons bien reçu et approuvé votre demande d'inscription à notre newsletter\n Vous serez informer pour chaque nouveauté chez MIHI CONSULTING\n\nLa direction MIHI CONSULTING";
		 try {
				GervaisMail.sendPlainTextEmail(host, port, userName, password, userName, subject, message1);
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 try {
				GervaisMail.sendPlainTextEmail(host, port, userName, password, email,subject, message2);
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return "page/index";
		
	}
	
	
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String HOME2(final ModelMap model) {
		
		return "page/index";
	}
	
	@RequestMapping(value="/about_us", method = RequestMethod.GET)
	public String about_us(final ModelMap model) {
		
		return "page/about-us";
	}
	
	
	@RequestMapping(value="/service", method = RequestMethod.GET)
	public String service(final ModelMap model) {
		
		return "page/service";
	}
	
	@RequestMapping(value="/contact", method = RequestMethod.GET)
	public String contact(final ModelMap model) {
		
		return "page/contact";
	}
	
	
	
	@RequestMapping(value="/offre", method = RequestMethod.GET)
	public String offre(final ModelMap model) {
		
		return "page/portfolio";
	}
	@RequestMapping(value="/test", method = RequestMethod.GET)
	public String carriere(final ModelMap model) {
		
		return "page/test"; 
	}
	
	@RequestMapping(value="/contactResp", method = RequestMethod.POST)
	public String contactResp(final ModelMap model, @RequestParam(value = "name") final String name
			,@RequestParam(value = "email") final String email
			,@RequestParam(value = "subject") final String subject
			,@RequestParam(value = "message") final String message) {
		
		String host= "smtp.gmail.com";
		String port ="587";
		String userName = "consultingmihi33@gmail.com";
		String password = "fionalysia";

		
		String message1 ="Bonjour Cher collaborateurs voici le message de l'un de nos visiteur :\n\n"+message+"\n\n message reçu de "+name+"\nAdresse mail du visiteur :"+email+"\n\nLa direction MIHI CONSULTING ";
				
		String message2 ="Bonjour Nous avons bien reçu votre message nous allons \nle traiter et vous recontacter; dans les plus brefs délai\n\nLa direction MIHI CONSULTING ";
		 try {
				GervaisMail.sendPlainTextEmail(host, port, userName, password, userName, subject, message1);
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 try {
				GervaisMail.sendPlainTextEmail(host, port, userName, password, email,"Reponse à "+subject, message2);
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		return "page/contact";
		
				 
	}
	
	
				 @RequestMapping(value="/contactez_nous", method = RequestMethod.POST)
					public String contactez_nous(final ModelMap model, @RequestParam(value = "name") final String name
							,@RequestParam(value = "email") final String email
							,@RequestParam(value = "subject") final String subject
							,@RequestParam(value = "message") final String message) {
						
						String host= "smtp.gmail.com";
						String port ="587";
						String userName = "consultingmihi33@gmail.com";
						String password = "fionalysia";
					
					
					
					
						
						String message1 ="Bonjour Cher collaborateurs voici le message de l'un de nos visiteur :\n\n"+message+"\n\n message reçu de "+name+"\nAdresse mail du visiteur : "+email+"\n\nLa direction MIHI CONSULTING ";
						
						String message2 ="Bonjour Nous avons bien reçu votre message\nNous allons le traiter et vous recontacter dans les plus brefs délais\n\nLa direction MIHI CONSULTING ";
						 try {
								GervaisMail.sendPlainTextEmail(host, port, userName, password, userName, subject, message1);
							} catch (AddressException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (MessagingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						 
						 
						 try {
								GervaisMail.sendPlainTextEmail(host, port, userName, password, email,"Réponse à "+subject, message2);
							} catch (AddressException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (MessagingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
								
								return "page/index";
							
							
						
					
					}
	
	@RequestMapping(value="/resultat", method = RequestMethod.POST)
	public String resultat(final ModelMap model, @RequestParam(value = "nom") final String nom
			,@RequestParam(value = "prenom") final String prenom
			,@RequestParam(value = "login") final String login
			,@RequestParam(value = "tel") final String tel
			,@RequestParam(value = "post") final String post
			,@RequestParam(value = "salaire") final String salaire) {
		
		 DOMConfigurator.configure("log4j.xml");
		    
	        //Log in console in and log file
		    logger.debug("NOM : "+nom+"\nprenom"+prenom+"\nlogin"+login+"\ntel"+tel+"\npost"+post+"\nsalaire"+salaire);
		    model.addAttribute("prenom", prenom);
		    String host= "smtp.gmail.com";
			String port ="587";
			String userName = "consultingmihi33@gmail.com";
			String password = "fionalysia";
			String subject  = "MIHI CONSULTING";
		
			String subject2  = "Respect de rendez vous";
			String login2 = "consultingmihi33@gmail.com";
			
			utilisateur.setLogin(login);
			
			utilisateur.setPrenom(prenom);
			utilisateur.setPost(post);
			utilisateur.setSalaire(salaire);
			utilisateur.setTel(tel);
			utilisateur.setLogin(login);
			utilisateur.setNom(nom);
			
     Date date = new Date();
     
     GregorianCalendar gc = new GregorianCalendar();
     gc.setTime(date);
     gc.add(GregorianCalendar.DATE, 7);
     date = gc.getTime();
			
			String message1 = candidature.rendezvousTest(utilisateur, date);
			String message = candidature.RespectrendezvousTest(utilisateur, date);
		    try {
				GervaisMail.sendPlainTextEmail(host, port, userName, password, login, subject, message1);
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    try {
				GervaisMail.sendPlainTextEmail(host, port, userName, password, login2, subject2, message);
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		return "page/resultat";
	}
}