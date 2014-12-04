package modele;

public class Header {

	/* ATTRIBUTS */
	
	private String nom;
	private String commentaire;
	private int num_colonne;
	private int num_ligne;
	
	/* CONSTRUCTEUR */
	
	public Header(String nom, String commentaire, int num_colonne, int num_ligne) {
		super();
		this.nom = nom;
		this.commentaire = commentaire;
		this.num_colonne = num_colonne;
		this.num_ligne = num_ligne;
	}
	
	/* GETTERS AND SETTERS */
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
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
