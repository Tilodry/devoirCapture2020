package vue;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurMois;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class VueMois extends Vue {

	protected ControleurMois controleur;
	protected static VueMois instance = null; 
	public static VueMois getInstance() {if(null==instance)instance = new VueMois();return VueMois.instance;}; 
	
	private VueMois() 
	{
		super("mois.fxml"); 
		super.controleur = this.controleur = new ControleurMois();
		Logger.logMsg(Logger.INFO, "new VueMois()");
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
