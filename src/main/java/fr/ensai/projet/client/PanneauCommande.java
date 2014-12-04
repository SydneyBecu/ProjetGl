package fr.ensai.projet.client;

import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.layout.VLayout;
import com.google.gwt.core.client.GWT;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.MultipleAppearance;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.Dialog;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;


public class PanneauCommande extends VLayout {
	private final static int LARGEUR=300;
	final Label labelAnswer = new Label("Your answer here");
	IButton AjoutLigne = new IButton("Ajouter une ligne"); 
	IButton AjoutColonne = new IButton("Ajouter une colonne");
	ComboBoxItem SuppressionLigne = new ComboBoxItem();
	ComboBoxItem SuppressionColonne = new ComboBoxItem();
    final SelectItem MasquerLigne = new SelectItem();  
    final SelectItem MasquerColonne = new SelectItem();  

	public PanneauCommande(){
		super();
		this.setWidth(LARGEUR);
		this.setShowEdges(true);
		this.setBackgroundColor("#C3D9FF");
		this.setShowResizeBar(true);
		this.setResizeBarTarget("next");	
		Label panneau = new Label();
		panneau.setContents("Panneau de commande");
		panneau.setAlign(Alignment.CENTER);
		
		this.addMember(panneau);
		
		
	
	
	
	 //On rajoute les boutons:
	  
    AjoutLigne.setLeft(300);  
    AjoutLigne.addClickHandler(new ClickHandler() {  
        public void onClick(ClickEvent event) {  
            final Dialog dialogProperties = new Dialog();  
            dialogProperties.setWidth(300);  
            SC.askforValue("Ajout de ligne", "Nom de la ligne", "", new ValueCallback() {  
                  
                public void execute(String value) {  
                    if (value != null) {  
                        labelAnswer.setContents(value);  
                    } else {  
                        labelAnswer.setContents("Cancel");  
                    }  
                }  
            }, dialogProperties);  
        }  
    });  
    
    AjoutLigne.setLeft(300);  
    AjoutLigne.addClickHandler(new ClickHandler() {  
        public void onClick(ClickEvent event) {  
            final Dialog dialogProperties = new Dialog();  
            dialogProperties.setWidth(300);  
            SC.askforValue("Ajout de colonne", "Nom de la colonne", "", new ValueCallback() {  
                  
                public void execute(String value) {  
                    if (value != null) {  
                        labelAnswer.setContents(value);  
                    } else {  
                        labelAnswer.setContents("Cancel");  
                    }  
                }  
            }, dialogProperties);  
        }  
    });  
    
	
    this.addMember(AjoutLigne);
    this.addMember(AjoutColonne);
    
    //Boutons déroulants pour suppression de ligne et de colonne.
    
    DynamicForm formSupp = new DynamicForm();
    SuppressionLigne.setTitle("Supprimer une ligne");  
    SuppressionLigne.setType("comboBox");  
    SuppressionLigne.setValueMap("Yolo", "Swag");  

    
     
    SuppressionColonne.setTitle("Supprimer une colonne");  
    SuppressionColonne.setType("comboBox");  
    SuppressionColonne.setValueMap("Cat", "Dog");  
    formSupp.setFields(SuppressionLigne,SuppressionColonne);

    this.addMember(formSupp);
    
    
   // Multi select pour Masquer
    
    DynamicForm formMasq = new DynamicForm();

    MasquerLigne.setTitle("Masquer ligne");  
    MasquerLigne.setMultiple(true);  
    MasquerLigne.setMultipleAppearance(MultipleAppearance.PICKLIST);  
    MasquerLigne.setValueMap("Cat", "Dog", "Giraffe", "Goat", "Marmoset", "Mouse");  

    MasquerColonne.setTitle("Masquer colonne");  
    MasquerColonne.setMultiple(true);  
    MasquerColonne.setMultipleAppearance(MultipleAppearance.PICKLIST);  
    MasquerColonne.setValueMap("Cat", "Dog", "Giraffe", "Goat", "y", "Mouse");
    
    formMasq.setItems(MasquerLigne,MasquerColonne);
    this.addMember(formMasq);
    

}
}