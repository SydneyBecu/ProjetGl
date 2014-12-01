package fr.ensai.projet.client;

/**
 * Interface to represent the messages contained in resource bundle:
 * 	/home/sydney/Documents/ProjetGenieLog/smartgwt5maven-master/src/main/resources/fr/ensai/projet/client/Messages.properties'.
 */
public interface Messages extends com.google.gwt.i18n.client.Messages {
  
  /**
   * Translated "Enter your name".
   * 
   * @return translated "Enter your name"
   */
  @DefaultMessage("Enter your name")
  @Key("nameField")
  String nameField();

  /**
   * Translated "Send".
   * 
   * @return translated "Send"
   */
  @DefaultMessage("Send")
  @Key("sendButton")
  String sendButton();
}
