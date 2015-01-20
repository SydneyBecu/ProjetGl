package fr.ensai.projet.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.xml.client.Document;

public interface EssaiSauvegardeAsync {
	public void sauvegarde(String xml,AsyncCallback<String> callback);
}
