package fr.ensai.projet.client;

import com.google.gwt.core.client.GWT;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;

import com.smartgwt.client.widgets.layout.HLayout;

public class NomAuteur extends HLayout {
	private static final int NOMAUTEURHEIGHT=50;
	private static final int NOMAUTEURWIDTH=500;

	//On initialise le LayoutNomAuteur
	public NomAuteur(){
		super();
	  this.setHeight(NOMAUTEURHEIGHT);
	  //this.setWidth(NOMAUTEURWIDTH);
	  this.setBackgroundColor("#B40404");
	  this.setShowEdges(true);
	  this.setShowResizeBar(false);
	  
	  //Ce qu'on va mettre dans le LayoutNomAuteur
	  Label nom = new Label();
	  Label auteur = new Label();
	  
	  nom.setContents("Nom : ");
	  auteur.setContents("Auteur : ");
	  nom.setAlign(Alignment.CENTER);
	  auteur.setAlign(Alignment.RIGHT);
	  
	  //On rattache les labels au Layout Horizontal
	  this.addMember(nom);
	  this.addMember(auteur);
	}

}
