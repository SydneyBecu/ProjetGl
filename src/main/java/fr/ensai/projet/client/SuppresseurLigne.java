package fr.ensai.projet.client;

import com.google.gwt.user.client.Window;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.BooleanCallback;  
import com.smartgwt.client.util.SC;  
import com.smartgwt.client.util.ValueCallback;  
import com.smartgwt.client.widgets.Canvas;  
import com.smartgwt.client.widgets.Dialog;  
import com.smartgwt.client.widgets.IButton;  
import com.smartgwt.client.widgets.Label;  
import com.smartgwt.client.widgets.events.ClickEvent;  
import com.smartgwt.client.widgets.events.ClickHandler; 
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.Dialog;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.layout.HLayout;

public class SuppresseurLigne extends HLayout {
	
	//ComboBoxItem Suppression = new ComboBoxItem();
	IButton Valider = new IButton("Valider"); 
	final Label labelAnswer = new Label("Your answer here");
    PanneauMatrice panneauMatrice;
    
    
    public PanneauMatrice getPanneauMatrice() {
		return panneauMatrice;
	}


	public void setPanneauMatrice(PanneauMatrice panneauMatrice) {
		this.panneauMatrice = panneauMatrice;
	}
	
	
    public SuppresseurLigne(){
    //Boutons déroulants pour suppression de ligne et de colonne.
    
    //DynamicForm formSupp = new DynamicForm();
    //Suppression.setTitle("Supprimer cette ligne");  
    //Suppression.setType("comboBox");  
    //Suppression.setValueMap("Yolo", "Swag");  

    	
    //formSupp.setFields(Suppression);
    
    Valider.addClickHandler(new ClickHandler() {  
        public void onClick(ClickEvent event) {  
                        if(panneauMatrice.selectionne() != null) {  

                            panneauMatrice.supprimerLigneSelectionnee();  
                            Window.alert("Select a record before performing this action YOLO");  

                        } else {  
                            Window.alert("Select a record before performing this action");  
                        }  
                       
             
        }  
    });  
    
     
    

    //this.addMember(formSupp);
    this.addMember(Valider);
    
}

}
