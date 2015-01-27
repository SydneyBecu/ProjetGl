package fr.ensai.projet.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ChargementAsync {
	public void charger(String nomAuteur,AsyncCallback<String> callback);

}
