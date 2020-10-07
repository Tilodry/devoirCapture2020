package vue;
import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurAccueil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class VueAccueil extends Vue {

	protected ControleurAccueil controleur;
	protected static VueAccueil instance = null; 
	public static VueAccueil getInstance() {if(null==instance)instance = new VueAccueil();return VueAccueil.instance;}; 
	
	private VueAccueil() 
	{
		super("accueil.fxml"); 
		super.controleur = this.controleur = new ControleurAccueil();
		Logger.logMsg(Logger.INFO, "new VueAccueil()");
	}
		
	public void activerControles()
	{
		super.activerControles();
		
		
		
		Label accjourmoy = (Label)lookup("#accueil-journee-moyenne");

		Label accmoismoy = (Label)lookup("#accueil-mois-moyenne");
		
		Label accannemoy = (Label)lookup("#accueil-annee-moyenne");
		
		
		
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
