package modele;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "modele")

public class Matrice {
	
	/* ATTRIBUTS */
	
	private String nom;
	private String auteur;
	private String commentaire;
	private int nb_colonnes;
	private int nb_lignes;
	private boolean isAuteur;
	List<Cellule> celluleList = new ArrayList<Cellule>();	
	List<Header> headerList = new ArrayList<Header>();
	
	/*CONSTRUCTEUR*/
	
	public Matrice(String nom, String auteur, String commentaire,
			int nb_colonnes, int nb_lignes, boolean isAuteur) {
		super();
		this.nom = nom;
		this.auteur = auteur;
		this.commentaire = commentaire;
		this.nb_colonnes = nb_colonnes;
		this.nb_lignes = nb_lignes;
		this.isAuteur = isAuteur;
	}
	
	/* GETTERS AND SETTERS*/
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public int getNb_colonnes() {
		return nb_colonnes;
	}
	public void setNb_colonnes(int nb_colonnes) {
		this.nb_colonnes = nb_colonnes;
	}
	public int getNb_lignes() {
		return nb_lignes;
	}
	public void setNb_lignes(int nb_lignes) {
		this.nb_lignes = nb_lignes;
	}
	public boolean isAuteur() {
		return isAuteur;
	}
	public void setAuteur(boolean isAuteur) {
		this.isAuteur = isAuteur;
	}	
}
