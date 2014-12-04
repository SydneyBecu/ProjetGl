package modele;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "cellule")
@XmlType(propOrder = { "commentaire", "num_colonne", "num_ligne" })

public class Cellule {




	/*ATTRIBUTS*/

	private String commentaire;
	private int num_colonne;
	private int num_ligne;

	/* CONSTUCTEUR */
	
	public Cellule(String commentaire, int num_colonne, int num_ligne) {
		super();
		this.commentaire = commentaire;
		this.num_colonne = num_colonne;
		this.num_ligne = num_ligne;
	}
	
	/* GETTERS AND SETTERS */
	
	
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public int getNum_colonne() {
		return num_colonne;
	}
	public void setNum_colonne(int num_colonne) {
		this.num_colonne = num_colonne;
	}
	public int getNum_ligne() {
		return num_ligne;
	}
	public void setNum_ligne(int num_ligne) {
		this.num_ligne = num_ligne;
	}
}
