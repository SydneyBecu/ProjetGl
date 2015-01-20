package fr.ensai.projet.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.xml.client.Document;

@RemoteServiceRelativePath("EssaiSauvegarde")
public interface EssaiSauvegarde extends RemoteService {
	public  String sauvegarde(String xml);
}
