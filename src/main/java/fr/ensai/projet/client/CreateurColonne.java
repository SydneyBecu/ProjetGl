package fr.ensai.projet.client;

import com.google.gwt.user.client.Window;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.Dialog;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.layout.HLayout;

public class CreateurColonne extends HLayout {

	ComboBoxItem Type = new ComboBoxItem();
		IButton NomCol = new IButton("NomColonne"); 
		final Label labelAnswer = new Label("Your answer here");
	    PanneauMatrice panneauMatrice;

	
	    public PanneauMatrice getPanneauMatrice() {
			return panneauMatrice;
		}


		public void setPanneauMatrice(PanneauMatrice panneauMatrice) {
			this.panneauMatrice = panneauMatrice;
		}


		public CreateurColonne(){
	    //Boutons déroulants pour suppression de ligne et de colonne.
	    
	    DynamicForm formSupp = new DynamicForm();
	    Type.setTitle("Créer une colonne");  
	    Type.setType("comboBox");  
	    Type.setValueMap("Numérique", "Booléen","Texte");  
	
	    	
	    formSupp.setFields(Type);
	    
	      
	        NomCol.setLeft(300);  
	        NomCol.addClickHandler(new ClickHandler() {  
	            public void onClick(ClickEvent event) {  
	                final Dialog dialogProperties = new Dialog();  
	                dialogProperties.setWidth(300);  
	                SC.askforValue("Question", "Nom de la colonne", "", new ValueCallback() {  
	                    public void execute(String value) {  
	                        if (value != null) {  
	                           
	                            labelAnswer.setContents(value); 
	                            if(Type.getValue()=="Numérique"){
	                            	panneauMatrice.ajouterHeaderColNumerique(value);
	                            }
	                            else if (Type.getValue()=="Booléen"){
	                            	panneauMatrice.ajouterHeaderColBool(value);
	                            }
	                            else if (Type.getValue()=="Texte"){
	                            	panneauMatrice.ajouterHeaderCol(value);
	                            }
	                            else {
	                            	 Window.alert("Veuillez entrez un type hmhmhmhmhm");
	                            }
	                        } else {  
		                          

	                            labelAnswer.setContents("Cancel");  
	                        }  
	                    }  
	                }, dialogProperties);  
	            }  
	        });  
	     
	    
	
	    this.addMember(formSupp);
	    this.addMember(NomCol);
	    
	
	
	}
	}
	
	


