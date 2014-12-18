package fr.ensai.projet.client;

import java.util.ArrayList;

import com.google.gwt.user.client.Window;
import com.smartgwt.client.widgets.layout.HLayout;
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

public class SuppresseurColonne extends HLayout {
	ComboBoxItem Suppression = new ComboBoxItem();
	IButton Valider = new IButton("Valider"); 
	final Label labelAnswer = new Label("Your answer here");
	PanneauMatrice panneaumatrice;
	String[] nomsColonnes = new String[100];
    public PanneauMatrice getPanneaumatrice() {
		return panneaumatrice;
	}

	public void setPanneaumatrice(PanneauMatrice panneaumatrice) {
		this.panneaumatrice = panneaumatrice;
	}

	public SuppresseurColonne(){
    //Boutons déroulants pour suppression de ligne et de colonne.
    
    DynamicForm formSupp = new DynamicForm();
    Suppression.setTitle("Supprimer cette colonne");  
    Suppression.setType("comboBox");  
    	
    formSupp.setFields(Suppression);
    
    Valider.addClickHandler(new ClickHandler() {  
        public void onClick(ClickEvent event) {  
            SC.confirm("Supprimer ces Colonnes?", new BooleanCallback() {  
                public void execute(Boolean value) {  
                    if (value != null && value) {  
                    	Window.alert("entree");
                    	panneaumatrice.supprimerField((String) Suppression.getValue());
                        labelAnswer.setContents("OK");  
                    } else {  
                        labelAnswer.setContents("Cancel");  
                    }  
                }  
            });  
        }  
    });  
    
     
    

    this.addMember(formSupp);
    this.addMember(Valider);
    


}
	
	private int nombreCol(){
		return panneaumatrice.Grid.getFields().length;
	}
	public void MAJListeCol(){

		int nombre= nombreCol();

		for (int i=0;i<nombre-2;i++){

			String nomCol=panneaumatrice.Grid.getFields()[i+2].getName();
			nomsColonnes[i]=nomCol;

		}
		Suppression.setValueMap(nomsColonnes);
	}
}