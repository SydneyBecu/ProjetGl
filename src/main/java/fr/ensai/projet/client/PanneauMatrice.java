package fr.ensai.projet.client;


import java.util.ArrayList;
import java.util.List;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Window;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.form.validator.IntegerRangeValidator;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.RowOverEvent;
import com.smartgwt.client.widgets.grid.events.RowOverHandler;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.viewer.DetailViewerField;

public class PanneauMatrice extends HLayout {
	// Hauteur du panneau contenant la matrice.
	private final static int Hauteur=400;
	
	// La matrice
	ListGrid Grid = new ListGrid();
	// Le constructeur
	public PanneauMatrice(){
		super();
		//On définit la hauteur, la largeur et le fait que l'on voie les bords
		this.setHeight(Hauteur);
		this.setWidth100();
		this.setShowEdges(true);
		
		/*Label panneau = new Label();
		panneau.setContents("Emplacement de la matrice");
		panneau.setAlign(Alignment.CENTER);
		
		
		this.addMember(panneau);
		*/
		
		// Dimensions de la matrice
	     	Grid.setWidth(500);  
	        Grid.setHeight(224);  
	        Grid.setTop(50); 
	        
	    // Fait que l'on voie toutes les lignes
	        Grid.setShowAllRecords(true); 
	    // Message lorsque la matrice est vide    
	        Grid.setShowEmptyMessage(true);  
	        
	       // Grid.setAlternateRecordStyles(true);
	    //Fait que l'on puisse supprimer une ligne    
	        Grid.setCanRemoveRecords(true);
	    
	        /*
	        Grid.setEmptyMessage("Ajoutez des lignes ou des colonnes");
	        ListGridField Nom = new ListGridField("Bière");
	        ListGridField Prix = new ListGridField("Prix");
	        ListGridField Qualité = new ListGridField("Qualité");
	        
	        Grid.setFields(Nom,Prix,Qualité);
	        */	       
	        //Grid.setCanSelectCells(true);
	        // Affichage du contenu lorsque l'on passe sur l'élément
	        Grid.setCanHover(true);
	        // On peut sélectionner tous les éléments
	        Grid.setCanSelectAll(true);
	        //Grid.setShowRollOver(true);
	        // Affichage du numéo des lignes.
	        Grid.setShowRowNumbers(true);
	        //On ajoute la matrice au panneau
	        this.addMember(Grid);
	       	}
	
	//Récupérer le nom des colonnes
	public ArrayList<String> recupHeadersCol(){
	ArrayList<String> liste = new ArrayList<String>();
	for (int i=0;i<Grid.getFields().length;i++){
	liste.add(Grid.getFieldName(i));
	}
	return liste;
		
	}
	// Ajouter un élément à la liste des colonnes
	public ArrayList<String> ajouterHeaderColString(String nouveauHeader){
		ArrayList<String> listeExist = recupHeadersCol();
		listeExist.add(nouveauHeader);
		
		return listeExist;
	}
	
	// Ajouter une colonne
	public void ajouterHeaderCol(String nouveauHeader){
		ArrayList<String> liste= ajouterHeaderColString(nouveauHeader);
		ListGridField[] listeFields = Grid.getFields();
		int nombre=listeFields.length;
		ListGridField[] liste2 = new ListGridField[nombre+1];
		for(int i=0;i<nombre;i++){
			liste2[i]=listeFields[i];
		}
		ListGridField nouveau = new ListGridField(nouveauHeader);
		liste2[nombre]=nouveau;
		Grid.setFields(liste2);
		
	}
	// Ajouter une colonne de type numérique
	public void ajouterHeaderColNumerique(String nouveauHeader){
		ArrayList<String> liste= ajouterHeaderColString(nouveauHeader);
		ListGridField[] listeFields = Grid.getFields();
		int nombre=listeFields.length;
		ListGridField[] liste2 = new ListGridField[nombre+1];
		for(int i=0;i<nombre;i++){
			liste2[i]=listeFields[i];
		}
		ListGridField nouveau = new ListGridField(nouveauHeader);
		nouveau.setType(ListGridFieldType.FLOAT);
		liste2[nombre]=nouveau;
		
		
		Grid.setFields(liste2);
		
	}
	
	// Ajouter une colonne de type booléen
	public void ajouterHeaderColBool(String nouveauHeader){
		ArrayList<String> liste= ajouterHeaderColString(nouveauHeader);
		ListGridField[] listeFields = Grid.getFields();
		int nombre=listeFields.length;
		ListGridField[] liste2 = new ListGridField[nombre+1];
		for(int i=0;i<nombre;i++){
			liste2[i]=listeFields[i];
		}
		ListGridField nouveau = new ListGridField(nouveauHeader);
		nouveau.setType(ListGridFieldType.BOOLEAN);
		liste2[nombre]=nouveau;
		
		
		Grid.setFields(liste2);
		
	}
	
	//Ajouter une ligne
	public void ajouterLigne(){
		Grid.startEditingNew();
	}
	
	//Permet de réinitialiser la matrice. 
	public void reinitialiserMatrice(){
		Grid = new ListGrid();
	}
	
	
	public void supprimerField(String nom){
		boolean indic = false;
		ListGrid nouvelle = new ListGrid();
		
		int nbcol=Grid.getAllFields().length-2;
		Window.alert(""+nbcol);
		ListGridField[] listeNew = new ListGridField[nbcol-1];

		for(int i=0;i<nbcol;i++){
			Window.alert(""+indic);
			Window.alert(nom + " "+Grid.getAllFields()[i+2].getName());
			if(Grid.getAllFields()[i+2].getName().equals(nom) && !indic){
				indic = true;
			}
			else if(!indic){
				ListGridField field = Grid.getAllFields()[i+2];
				listeNew[i]=field;
			}
			else{
				ListGridField field = Grid.getAllFields()[i+2];
				listeNew[i-1]=field;
			}
		}
		
		for(int i=0;i<nbcol-1;i++	){
			Window.alert(nouvelle.getAllFields()[i].getName());
		}
		Grid.setFields(listeNew);
	}
 

}
	
