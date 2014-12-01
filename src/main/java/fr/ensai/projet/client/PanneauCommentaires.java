package fr.ensai.projet.client;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;

public class PanneauCommentaires extends HLayout {
	public PanneauCommentaires(){
	this.setWidth100();
	this.setShowEdges(true);
	Label panneau = new Label();
	panneau.setContents("Emplacement des commentaires");
	panneau.setAlign(Alignment.CENTER);
	this.addMember(panneau);
	}

}
