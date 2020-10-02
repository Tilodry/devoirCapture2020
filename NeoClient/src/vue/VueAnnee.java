package vue;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurAnnee;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class VueAnnee extends Vue {

	protected ControleurAnnee controleur;
	protected static VueAnnee instance = null; 
	public static VueAnnee getInstance() {if(null==instance)instance = new VueAnnee();return VueAnnee.instance;}; 
	
	private VueAnnee() 
	{
		super("annee.fxml"); 
		super.controleur = this.controleur = new ControleurAnnee();
		Logger.logMsg(Logger.INFO, "new VueAnnee()");
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
		
		Button actionNaviguerJournee = (Button) lookup("#action-naviguer-journee");
		actionNaviguerJournee.setOnAction(new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	Logger.logMsg(Logger.INFO, "Bouton Journee activé");
            	controleur.actionNaviguerJournee();
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
		

	}
}
