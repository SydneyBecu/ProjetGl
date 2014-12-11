package fr.ensai.projet.client;


import java.util.ArrayList;
import java.util.List;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;

public class PanneauMatrice extends HLayout {
	private final static int Hauteur=400;
	ListGrid Grid = new ListGrid();  

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
	        Grid.setEmptyMessage("Ajoutez des lignes ou des colonnes");
	        ListGridField Nom = new ListGridField("Bière");
	        ListGridField Prix = new ListGridField("Prix");
	        ListGridField Qualité = new ListGridField("Qualité");
	        
	        Grid.setFields(Nom,Prix,Qualité);
	        
	        Grid.setCanSelectCells(true);
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
	// Récupérer le nom des lignes
	//public ArrayList<String> recupHeaderLigne(){
		//ArrayList<String> liste = new ArrayList<String>();
		//Grid.get
	//}
	
	
	public void ajouterLigne(){
		Grid.startEditingNew();
	}

}
