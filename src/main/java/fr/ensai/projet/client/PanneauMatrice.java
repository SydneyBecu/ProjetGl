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
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.viewer.DetailViewerField;

public class PanneauMatrice extends HLayout {
	private final static int Hauteur=400;
	ListGrid Grid = new ListGrid(); 
	ListGridRecord[] selectionne;
	public PanneauMatrice(){
		super();
		this.setHeight(Hauteur);
		this.setWidth100();
		this.setShowEdges(true);
		Label panneau = new Label();
		panneau.setContents("Emplacement de la matrice");
		panneau.setAlign(Alignment.CENTER);
		
		this.addMember(panneau);
		
	        Grid.setWidth(500);  
	        Grid.setHeight(224);  
	        Grid.setTop(50);  
	        Grid.setShowAllRecords(true);  
	        Grid.setShowEmptyMessage(true);  
	        Grid.setAlternateRecordStyles(true);
	        Grid.setEmptyMessage("Ajoutez des lignes ou des colonnes");
	        ListGridField Nom = new ListGridField("Bière");
	        ListGridField Prix = new ListGridField("Prix");
	        ListGridField Qualité = new ListGridField("Qualité");
	      
	        Grid.setFields(Nom,Prix,Qualité);	       
	        Grid.setCanSelectCells(true);
	        
	        //Grid.setCanSelectAll(true);
	        Grid.setSelectionType(SelectionStyle.SINGLE);
	        Grid.setShowRollOver(true);
	        Grid.setShowRowNumbers(true);
	        this.addMember(Grid);
	    
	        final Label detailViewer = new Label();
	        
	        
	        
		
	    
	        this.addMember(detailViewer);

		
	}
	
	//Récupérer le nom des colonnes
	public ArrayList<String> recupHeadersCol(){
	ArrayList<String> liste = new ArrayList<String>();
	for (int i=0;i<Grid.getFields().length;i++){
	liste.add(Grid.getFieldName(i));
	}
	return liste;
		
	}
	
	public ArrayList<String> ajouterHeaderColString(String nouveauHeader){
		ArrayList<String> listeExist = recupHeadersCol();
		listeExist.add(nouveauHeader);
		
		return listeExist;
	}
	
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
	
	
	// Récupérer le nom des lignes
	//public ArrayList<String> recupHeaderLigne(){
		//ArrayList<String> liste = new ArrayList<String>();
		//Grid.get
	//}
	
	
	public void ajouterLigne(){
		Grid.startEditingNew();
	}
	
	public ListGridRecord[] selectionne(){

		return selectionne;
	}
	public void supprimerLigne(ListGridRecord[] record){
		Grid.removeData(record[0]);
	}
	
	public void supprimerLigneSelectionnee(){
		Grid.addRecordClickHandler(new RecordClickHandler() {
	        
        	
			@SuppressWarnings("deprecation")
			public void onRecordClick(RecordClickEvent event) {
				selectionne = Grid.getSelection();
				
				
            }
        });
		supprimerLigne(selectionne());
	}
}
	
