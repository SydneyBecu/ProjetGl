package fr.ensai.projet.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Chargement")
public interface Chargement extends RemoteService {
	public String charger(String nomAuteur);
}
