package vue;
import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurAccueil;

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
		
		/*
		Button actionCalculatrice = (Button) lookup("#action-calculatrice");
		actionCalculatrice.setOnAction(new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	Logger.logMsg(Logger.INFO, "Bouton Calculatrice activé");
            	controleur.notifierEvenement(ActionNavigation.CALCULATRICE);
            }
        });
		*/

	}
}
