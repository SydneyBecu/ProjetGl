package fr.ensai.projet.server;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.gwt.xml.client.Document;

import fr.ensai.projet.client.EssaiSauvegarde;

public class EssaiSauvegardeImpl extends RemoteServiceServlet implements
		EssaiSauvegarde {

	public String sauvegarde(String xml) {
		System.out.println(xml);
		System.out.println("entree essaiSauvegarde");
		System.out.println("Ca s'est bien effectué");
		return("aha");
	}
	
	

}
