package vue;
import java.text.DecimalFormat;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurAccueil;
import donnee.AnneeDAO;
import donnee.JourDAO;
import donnee.MoisDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import modele.Annee_Modele;
import modele.Jour_Modele;
import modele.Mois_Modele;

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
		
		DecimalFormat df = new DecimalFormat("##.##");
		
		Label accjourmoy = (Label)lookup("#accueil-journee-moyenne");
		Jour_Modele jourModele = new JourDAO().lister();
		accjourmoy.setText(df.format(jourModele.getDistanceMoyenneJour())+"  LD");

		
		
		Label accmoismoy = (Label)lookup("#accueil-mois-moyenne");
		Mois_Modele moisModele = new MoisDAO().lister();
		accmoismoy.setText(df.format(moisModele.getDistanceMoyenneMois())+"  LD");
		
		
		
		Label accanneemoy = (Label)lookup("#accueil-annee-moyenne");
		Annee_Modele anneeModele = new AnneeDAO().lister();	
		accanneemoy.setText(df.format(anneeModele.getDistanceMoyenneAnnee())+"  LD");
		
		
		
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
