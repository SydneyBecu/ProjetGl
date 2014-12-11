package fr.ensai.projet.client;

import com.google.gwt.core.client.GWT;
import com.smartgwt.client.util.BooleanCallback;  
import com.smartgwt.client.util.SC;  
import com.smartgwt.client.util.ValueCallback;  
import com.smartgwt.client.widgets.Canvas;  
import com.smartgwt.client.widgets.Dialog;  
import com.smartgwt.client.widgets.IButton;  
import com.smartgwt.client.widgets.Label;  
import com.smartgwt.client.widgets.events.ClickEvent;  
import com.smartgwt.client.widgets.events.ClickHandler; 
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Dialog;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;

public class NomAuteur extends HLayout {
	private static final int NOMAUTEURHEIGHT=50;
	private static final int NOMAUTEURWIDTH=500;
	final Label labelAnswer = new Label("Your answer here");
	//On initialise le LayoutNomAuteur
	public NomAuteur(){
		super();
	  this.setHeight(NOMAUTEURHEIGHT);
	  //this.setWidth(NOMAUTEURWIDTH);
	  //this.setBackgroundColor("#B40404");
	  this.setShowEdges(true);
	  this.setShowResizeBar(false);
	  
	  //Ce qu'on va mettre dans le LayoutNomAuteur
	  Label nom = new Label();
	  Label auteur = new Label();
	  
	  nom.setContents("<b>Nom de la matrice: </b> "
	  		+ "<p/> <b>Auteur</b> : ");
	  //auteur.setContents("<b>Auteur : </b>");
	  nom.setAlign(Alignment.CENTER);
	  //auteur.setAlign(Alignment.RIGHT);
	  
	  //On rattache les labels au Layout Horizontal
	  this.addMember(nom);
	  //this.addMember(auteur);
	
	  
	  //On rajoute les boutons:
	 IButton boutonNom = new IButton("Entrer nom");  
     boutonNom.setLeft(300);  
     boutonNom.addClickHandler(new ClickHandler() {  
         public void onClick(ClickEvent event) {  
             final Dialog dialogProperties = new Dialog();  
             dialogProperties.setWidth(300);  
             SC.askforValue("Nouveau nom", "Nom du PCM", "", new ValueCallback() {  
                   
                 public void execute(String value) {  
                     if (value != null) {  
                         labelAnswer.setContents(value);  
                     } else {  
                         labelAnswer.setContents("Cancel");  
                     }  
                 }  
             }, dialogProperties);  
         }  
     });  
     
     IButton boutonAuteur = new IButton("Entrer Auteur");  
     boutonAuteur.setLeft(300);  
     boutonAuteur.addClickHandler(new ClickHandler() {  
         public void onClick(ClickEvent event) {  
             final Dialog dialogProperties = new Dialog();  
             dialogProperties.setWidth(300);  
             SC.askforValue("Auteur", "Nom de l'auteur", "", new ValueCallback() {  
                   
                 public void execute(String value) {  
                     if (value != null) {  
                         labelAnswer.setContents(value);  
                     } else {  
                         labelAnswer.setContents("Cancel");  
                     }  
                 }  
             }, dialogProperties);  
         }  
     });  
     this.addMember(boutonNom);
     this.addMember(boutonAuteur);
}
}