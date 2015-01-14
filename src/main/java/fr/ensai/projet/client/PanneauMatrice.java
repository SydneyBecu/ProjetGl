package fr.ensai.projet.client;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.XMLParser;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Dialog;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.validator.IntegerRangeValidator;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.grid.events.CellContextClickEvent;
import com.smartgwt.client.widgets.grid.events.CellContextClickHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.RowOverEvent;
import com.smartgwt.client.widgets.grid.events.RowOverHandler;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.viewer.DetailViewerField;

public class PanneauMatrice extends VLayout {
	// Hauteur du panneau contenant la matrice.
	private final static int Hauteur=400;
	
	PanneauCommentaires panneauCom;
	
	IButton ajouterDesc = new IButton("Ajouter Description");

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
	       // Grid.setCanRemoveRecords(true);
	        Grid.setWarnOnRemoval(true);
	        /*
	        Grid.setEmptyMessage("Ajoutez des lignes ou des colonnes");
	        ListGridField Nom = new ListGridField("Bière");
	        ListGridField Prix = new ListGridField("Prix");
	        ListGridField Qualité = new ListGridField("Qualité");
	        
	        Grid.setFields(Nom,Prix,Qualité);
	        */	       
	        
	        Grid.setCanSelectCells(true);
	        // Affichage du contenu lorsque l'on passe sur l'élément
	        Grid.setCanHover(true);
	        // On peut sélectionner tous les éléments
	        Grid.setCanSelectAll(true);
	        //Grid.setShowRollOver(true);
	        // Affichage du numéo des lignes.
	        Grid.setShowRowNumbers(true);
	        //Filtre
	        Grid.setAutoFetchData(true);
	        Grid.setShowFilterEditor(true);
	        //On ajoute la matrice au panneau
	        //Le click droit sert à entrer un commentaire pour la cellule concernée
	        Grid.addCellContextClickHandler(new CellContextClickHandler() {
				
				public void onCellContextClick(CellContextClickEvent event) {
					final Dialog dialogProperties = new Dialog();  
		             dialogProperties.setWidth(300);  
		             SC.askforValue("Nouveau commentaire", "Lache ton com' !", "", new ValueCallback() {  
		                   
		                 public void execute(String value) {  
		                     if (value != null) {  
		                    	 int [][] celluleChoisie = Grid.getCellSelection().getSelectedCells();
		                    	 int ligne = celluleChoisie[0][0];
		                    	 int colonne =celluleChoisie[0][1];
		                    	 panneauCom.ajouterCommentaire(ligne, colonne, value);
		                    	 //panneauCom.afficherComm(ligne, colonne);
		                     } else {  
		                     }  
		                 }  
		             }, dialogProperties);  
					
				}
			});
	        
	        //Le click gauche simple permet d'afficher le commentaire de la cellule cliquée
	        Grid.addCellClickHandler(new CellClickHandler() {
				
				public void onCellClick(CellClickEvent event) {
					int [][] celluleChoisie = Grid.getCellSelection().getSelectedCells();
               	 int ligne = celluleChoisie[0][0];
               	 int colonne =celluleChoisie[0][1];

               	 String com = panneauCom.recupererCommentaire(ligne, colonne);
               	 panneauCom.afficherCommentaire(com);
				}
			});
	        
	        //Bonton pour ajouter un commentaire à la matrice
	        ajouterDesc.setWidth(300);
	        ajouterDesc.addClickHandler(new ClickHandler() {  
	            public void onClick(ClickEvent event) {  
	                final Dialog dialogProperties = new Dialog();  
	                dialogProperties.setWidth(300);  
	                SC.askforValue("Description de la PCM", "Entrer description", "", new ValueCallback() {  
	                      
	                    public void execute(String value) {  
	                        if (value != null) {  
	                        	panneauCom.descriptionLab.setContents("Description de la matrice : <b>" +value + "</b>");
	                        	
	                        } else {  
	                            Label labelAnswer =new Label();
								labelAnswer.setContents("Cancel");  
	                        }  
	                    
	                    }}, dialogProperties);  
	            }  
	        });  
	        
	        
	        
	        //On rattache les objets au panneau
	        this.addMember(Grid);
	        this.addMember(ajouterDesc);

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
	
	//Permet de supprimer une colonne
	public void supprimerField(String nom){
		boolean indic = false;		
		int nbcol=Grid.getAllFields().length;
		int compteurNew = 0;		
		//Liste des nouvelles colonnes
		ListGridField[] listeNew = new ListGridField[nbcol-3];
		
		//Pour chaque colonne de la grille
		for(int i=0;i<nbcol;i++){
			//Pour les colonnes n'étant pas les index ou suppresseur de ligne
			if(Grid.getFieldName(i)!="$61b" && Grid.getFieldName(i)!="$74y"){
				
				
			if(Grid.getAllFields()[i].getName().equals(nom) && !indic){
				indic = true;
				panneauCom.supprimerCol(i);

			}
			
			else{
				ListGridField field = Grid.getAllFields()[i];
				listeNew[compteurNew]=field;
				compteurNew++;

			}
			}
		}
		Grid.setFields(listeNew);
		this.addMember(Grid);
	}
	
	// Getters/Setters pour le panneau commentaire
	public PanneauCommentaires getPanneauCom() {
		return panneauCom;
	}

	public void setPanneauCom(PanneauCommentaires panneauCom) {
		this.panneauCom = panneauCom;
	}
	
	public void exportGridXML(){
		 Window.alert("Entree");
		
		RecordList records = Grid.getRecordList();

	    Document doc = XMLParser.createDocument();
	    Element rootElement = doc.createElement("ROOT");
	    doc.appendChild(rootElement);

	    for (int i = 0; i < records.getLength(); i++) {

	        Record rec = records.get(i);
	        Element row = doc.createElement("ROW");

	        for (String str : rec.getAttributes()) {


	            String propertyVal = rec.getAttributeAsString(str);

	                if (propertyVal != null && propertyVal.equalsIgnoreCase("") != true) {
	                    Element columnElement = doc.createElement(str.toUpperCase());
	                    columnElement.appendChild(doc.createTextNode(propertyVal));
	                    row.appendChild(columnElement);
	                }
	            }
	        rootElement.appendChild(row);
	    }
	    Window.alert("avant xml");
	          Window.alert(" " + doc.toString());
	          Window.alert("avant async");
	      	EssaiSauvegardeAsync essai = (EssaiSauvegardeAsync) GWT.create(EssaiSauvegarde.class);
	      	 Window.alert("avant callback");
	          AsyncCallback callback = new AsyncCallback() {
	        	    /*public void onSuccess(Void result) {
	        	      Window.alert("le callback a marche");
	        	    }
					*/
	        	    public void onFailure(Throwable caught) {
	        	    	Window.alert("le callback a pas marche");
	        	    	Window.alert(caught.toString());
	        	    	Window.alert("passe le caught");

	        	    	 }

					public void onSuccess(Object arg0) {
						Window.alert("le callback a marche");
						
					}
	        	  };

	        	  // (3) Make the call. Control flow will continue immediately and later
	        	  // 'callback' will be invoked when the RPC completes.
	        	  //
	        	  essai.sauvegarde(doc.toString(), callback);
	          
	}
	
	
}
	
