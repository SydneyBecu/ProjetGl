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
	static ComboBoxItem Suppression = new ComboBoxItem();
	IButton Valider = new IButton("Valider"); 
	final Label labelAnswer = new Label("Your answer here");
	static PanneauMatrice panneaumatrice;
	static String[] nomsColonnes = new String[100];
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
                    	
                    	MAJListeCol();
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
	
	private static int nombreCol(){
		return panneaumatrice.Grid.getFields().length;
	}
	public void MAJListeCol(){
		int nombre= nombreCol();
		nomsColonnes= new String[nombre];		
		for (int i=0;i<nombre;i++){
			if(panneaumatrice.Grid.getFieldName(i)!="$61b" && panneaumatrice.Grid.getFieldName(i)!="$74y"){				
			String nomCol=panneaumatrice.Grid.getFields()[i].getName();
			nomsColonnes[i]=nomCol;

		}}
		Suppression.setValueMap(nomsColonnes);
	}
	
}