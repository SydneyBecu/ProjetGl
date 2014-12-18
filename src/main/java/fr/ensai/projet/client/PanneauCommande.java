package fr.ensai.projet.client;

import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.VLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Button;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.MultipleAppearance;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.Dialog;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;


public class PanneauCommande extends VLayout {
	//Largeur du panneau
	private final static int LARGEUR=300;
	
	final Label labelAnswer = new Label("Your answer here");
	//Bouton permettant d'ajouter une ligne
	IButton AjoutLigne = new IButton("Ajouter une ligne"); 
	// Un créateur de colonne 
	CreateurColonne CreaCol= new CreateurColonne();
	SuppresseurColonne supCol = new SuppresseurColonne();
	
	IButton SupprLigne = new IButton("Supprimer ligne"); 

    //Bouton permettant de sauvegarder la matrice
    IButton Sauvegarder = new IButton("Sauver"); 
    //bouton permettant de charger une matrice
    IButton Charger = new IButton("Charger"); 
    // Le panneau matrice qui contient le pcm
	PanneauMatrice panneauMatrice;

    

	//Constructeur du panneauCommande
	PanneauCommande(){
		super();
		//Paramètres du panneau
		this.setWidth(LARGEUR);
		this.setShowEdges(true);
		this.setBackgroundColor("#C3D9FF");
		this.setShowResizeBar(true);
		this.setResizeBarTarget("next");
		/*
		Label panneau = new Label();
		panneau.setContents("Panneau de commande");
		panneau.setAlign(Alignment.CENTER);
		
		this.addMember(panneau);
		
		*/
	
	
	
	 //On rajoute les boutons:
	  
    AjoutLigne.setLeft(300);  
    AjoutLigne.addClickHandler(new ClickHandler() {  
        public void onClick(ClickEvent event) {  
             
            panneauMatrice.ajouterLigne();
            
        }  
    });  
    
    //Boutons permettant de supprimer une ligne
    SupprLigne.addClickHandler(new ClickHandler() {  
        public void onClick(ClickEvent event) {  
            final Dialog dialogProperties = new Dialog();  
            dialogProperties.setWidth(300);  
            SC.askforValue("Numéro de ligne à supprimer", "Numéro", "", new ValueCallback() {  
                  
                public void execute(String value) {  
                    if (value != null) {  
                    	int numero = Integer.parseInt(value);
                    	if(panneauMatrice.Grid.getRecord(numero-1)!=null){
                    		panneauMatrice.Grid.removeRecordClick(numero-1);
                    		panneauMatrice.panneauCom.supprimerLigne(numero-1);
                    	}
                    } else {  
                        labelAnswer.setContents("Cancel");  
                    }  
                }  
            }, dialogProperties);  
        }  
    });  
    
	//On ajoute les éléments au panneau
    this.addMember(AjoutLigne);
    this.addMember(SupprLigne);
    //supCol.setPanneaumatrice(panneauMatrice);
    
    //On rajoute le créateur de colonne
    //CreaCol.setPanneauMatrice(panneauMatrice);

    this.addMember(CreaCol);
    this.addMember(supCol);

    CreaCol.setSuppresseur(supCol);
    
    //Boutons Sauvegarder/Charger A changer en trouvant comment appeler un file system
    
    this.addMember(Sauvegarder);
    this.addMember(Charger);


}
	
	
	
	// Getters and setters
	public CreateurColonne getCreaCol() {
		return CreaCol;
	}




	public void setCreaCol(CreateurColonne creaCol) {
		CreaCol = creaCol;
	}



	public SuppresseurColonne getSupCol() {
		return supCol;
	}




	public void setSupCol(SuppresseurColonne supCol) {
		this.supCol = supCol;
		
	}

   
    public PanneauMatrice getPanneauMatrice() {
		return panneauMatrice;
	}




	public void setPanneauMatrice(PanneauMatrice panneauMatrice) {
		this.panneauMatrice = panneauMatrice;
		this.getCreaCol().setPanneauMatrice(panneauMatrice);
		this.getSupCol().setPanneaumatrice(panneauMatrice);
	}


}