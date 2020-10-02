package vue;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurJournee;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class VueJournee extends Vue {

	protected ControleurJournee controleur;
	protected static VueJournee instance = null; 
	public static VueJournee getInstance() {if(null==instance)instance = new VueJournee();return VueJournee.instance;}; 
	
	private VueJournee() 
	{
		super("journee.fxml"); 
		super.controleur = this.controleur = new ControleurJournee();
		Logger.logMsg(Logger.INFO, "new VueJournee()");
	}
		
	public void activerControles()
	{
		super.activerControles();
		
		Button actionNaviguerAccueil = (Button) lookup("#action-naviguer-accueil");
		actionNaviguerAccueil.setOnAction(new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	Logger.logMsg(Logger.INFO, "Bouton Accueil activé");
            	controleur.actionNaviguerAccueil();
            }
        });
		
		Button actionNaviguerMois = (Button) lookup("#action-naviguer-mois");
		actionNaviguerMois.setOnAction(new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	Logger.logMsg(Logger.INFO, "Bouton Mois activé");
            	controleur.actionNaviguerMois();
            }
        });
		
		Button actionNaviguerAnnee = (Button) lookup("#action-naviguer-annee");
		actionNaviguerAnnee.setOnAction(new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	Logger.logMsg(Logger.INFO, "Bouton Annee activé");
            	controleur.actionNaviguerAnnee();
            }
        });

	}
}

