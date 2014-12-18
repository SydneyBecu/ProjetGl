package fr.ensai.projet.client;

import java.util.ArrayList;

import com.google.gwt.user.client.Window;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PanneauCommentaires extends VLayout {
	// Une matrice de commentaires
	
	static String[][] matriceCom = new String[100][100];
	
	// Description de la PCM
	String description;
	Label descriptionLab = new Label("Description de la matrice : ");
	//Commentaire de la cellule selectionnée
	Label descriptionCell = new Label("Description de la cellule Selectionnée : ");
	
	//Constructeur
	public PanneauCommentaires(){
	this.setWidth100();
	this.setShowEdges(true);


	this.addMember(descriptionLab);
	this.addMember(descriptionCell);
	
	}
	
	//Pour ajouter un commentaire dans la matrice.
	public void ajouterCommentaire(int ligne, int colonne, String com){
		
		matriceCom[ligne][colonne]=com;
	}
	
	// Pour afficher un commentaire sur le panneau.
	public void afficherCommentaire (String com){
		descriptionCell.setContents("Description de la cellule Selectionnée : " +com);
	}
	
	// Pour récupérer un commentaire dans la matrice.
	public String recupererCommentaire(int ligne , int colonne){
		String com = matriceCom[ligne][colonne];
		return com;
	}
	
	public void afficherComm(int ligne, int colonne){
		Window.alert(matriceCom[ligne][colonne]);
	}
	
	public void supprimerLigne(int ligne){
		for(int j= 0;j<100;j++){
			for(int i=ligne;i<99;i++){
				String com = matriceCom[i+1][j];
				matriceCom[i][j] = com;
			}
		}
			
		}
	
	
	public void supprimerCol(int Col){
		for(int i= 0;i<100;i++){
			for(int j=Col;j<99;j++){
				String com = matriceCom[i][j+1];
				matriceCom[i][j] = com;
			}
		}
	}


}
