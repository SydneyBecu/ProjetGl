package fr.ensai.projet.client;

import fr.ensai.projet.shared.FieldVerifier;

import com.smartgwt.client.widgets.Canvas;  
import com.smartgwt.client.widgets.Dialog;
import com.smartgwt.client.widgets.HTMLFlow;  
  

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.layout.client.Layout.Alignment;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.smartgwt.client.core.KeyIdentifier;
import com.smartgwt.client.util.KeyCallback;
import com.smartgwt.client.util.Page;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class projetgl implements EntryPoint {
  /**
   * The message displayed to the user when the server cannot be reached or
   * returns an error.
   */
  private static final String SERVER_ERROR = "An error occurred while "
      + "attempting to contact the server. Please check your network "
      + "connection and try again.";

  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
  private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

  private final Messages messages = GWT.create(Messages.class);

  private HLayout mainLayout;
  private VLayout layoutDroit;
  private NomAuteur layoutNomAuteur;
  private PanneauCommande panneauCommande;
  private PanneauMatrice panneauMatrice;
  private PanneauCommentaires panneauCommentaires;
  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
	  if (!GWT.isScript()) { 
		    KeyIdentifier debugKey = new KeyIdentifier(); 
		    debugKey.setCtrlKey(true); 
		    debugKey.setKeyName("D"); 
		    Page.registerKey(debugKey, new KeyCallback() { 
		        public void execute(String keyName) { 
		            SC.showConsole(); 
		        }
		    });
		}
	  //On enlève les scroll bars et les marges auto
	  Window.enableScrolling(false);
	  Window.setMargin("0px");
	  
	  //On initialise le mainLayout
	  mainLayout = new HLayout();
	  mainLayout.setWidth100();
	  mainLayout.setHeight100();
	  mainLayout.setMembersMargin(20);
	  
	  layoutDroit= new VLayout();
	  layoutDroit.setHeight100();
	  //On crée un layout nomauteur
	  layoutNomAuteur = new NomAuteur();
	  
	  //On crée un layout panneauCommande
	  panneauCommande = new PanneauCommande();
	  //On crée un layout panneauMatrice ou l'on mettra le pcm
	  panneauMatrice=new PanneauMatrice();
	  //On crée un layout commentaire
	  panneauCommentaires=new PanneauCommentaires();
	  
	  //On attache les layout seconds au layout droit
	  
	  layoutDroit.addMember(layoutNomAuteur);
	  layoutDroit.addMember(panneauMatrice);
	  layoutDroit.addMember(panneauCommentaires);
	  //On rattache les layout au mainLayout
	  
	  mainLayout.addMember(panneauCommande);
	  mainLayout.addMember(layoutDroit);
	  
	  //On rattache le mainLayout au rootPanel
	  RootLayoutPanel.get().add(mainLayout);
	  
	  panneauCommande.setPanneauMatrice(panneauMatrice);
	 
	  
  }
}
