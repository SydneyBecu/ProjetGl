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
	private HLayout layoutnom = new HLayout() ;
	private HLayout layoutauteur = new HLayout();
	private HLayout layoutboutons = new HLayout();
	final Label labelAnswer = new Label("Your answer here");
	private String Nom = "";
	private String Auteur = "";
	//Ce qu'on va mettre dans le LayoutNomAuteur
	  Label nom = new Label();
	  Label auteur = new Label();
	  Label auteurReel = new Label();
	  
	//On initialise le LayoutNomAuteur
	public NomAuteur(){
		super();
	  this.setHeight(NOMAUTEURHEIGHT);
	  //this.setWidth(NOMAUTEURWIDTH);
	  //this.setBackgroundColor("#B40404");
	  this.setShowEdges(true);
	  this.setShowResizeBar(false);
	  layoutnom.setBackgroundColor("#FF358B");
	  layoutauteur.setBackgroundColor("#1AAE04");
	  layoutboutons.setBackgroundColor("orange");
	  
	  nom.setWidth("10%");
	  
	  nom.setContents("Nom de la matrice:  ");
	  auteur.setContents("Auteur : ");
	  nom.setAlign(Alignment.CENTER);
	  auteur.setAlign(Alignment.RIGHT);
	  
	  //On rattache les labels au Layout Horizontal
	  layoutnom.addMember(nom);
	  layoutauteur.addMember(auteur);
	  layoutauteur.addMember(auteurReel);
	  
	
	  
	  //On rajoute les boutons:
	  
	  //Bouton permettant d'ajouter le nom
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
                         Nom  = value ;
                         nom.setContents("<html><body>Nom de la matrice:    <b> "+Nom + "</b> </body></html>");
                     } else {  
                         labelAnswer.setContents("Cancel");  
                     }  
                 }  
             }, dialogProperties);  
         }  
     });  
     
     //Bouton permettant d'ajouter l'auteur
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
                         Auteur = value;
                         auteurReel.setContents("<b>"+Auteur+"</b>");
                     } else {  
                         labelAnswer.setContents("Cancel");  
                     }  
                 }  
             }, dialogProperties);  
         }  
     });  
     layoutboutons.addMember(boutonNom);
     layoutboutons.addMember(boutonAuteur);
     this.addMember(layoutnom);
     this.addMember(layoutauteur);
     this.addMember(layoutboutons);
}
}