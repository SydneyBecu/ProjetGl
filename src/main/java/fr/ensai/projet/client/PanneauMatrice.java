package fr.ensai.projet.client;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;

public class PanneauMatrice extends HLayout {
	private final static int Hauteur=400;
	public PanneauMatrice(){
		super();
		this.setHeight(Hauteur);
		this.setWidth100();
		this.setShowEdges(true);
		Label panneau = new Label();
		panneau.setContents("Emplacement de la matrice");
		panneau.setAlign(Alignment.CENTER);
		
		this.addMember(panneau);
	}

}
