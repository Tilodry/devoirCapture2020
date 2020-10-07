package vue;

import java.text.DecimalFormat;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurMois;
import donnee.AnneeDAO;
import donnee.JourDAO;
import donnee.MoisDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Annee_Modele;
import modele.Annee_MoisModele;
import modele.Jour_Modele;
import modele.Jour_NeoModele;
import modele.Mois_JourModele;
import modele.Mois_Modele;

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
		
		MoisDAO test = new MoisDAO();
		afficherMoiss(test.lister().getListe());
		
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
	
	
	public void afficherMoiss(List<Mois_JourModele> mois)
	{	
		DecimalFormat df = new DecimalFormat("##.##");
		MoisDAO moisDao = new MoisDAO();
		Mois_Modele moisObjet = moisDao.lister();
		
		Label moisTitre = (Label)lookup("#mois-titre");
		moisTitre.setText("Mois : " + moisObjet.getMois());
		
		Label moimi = (Label)lookup("#mois-minimum");
		moimi.setText( String.valueOf(df.format(moisObjet.getDistanceMinimumMois()))+" LD");
		
		Label moima = (Label)lookup("#mois-maximum");
		moima.setText( String.valueOf(df.format(moisObjet.getDistanceMaximumMois()))+" LD");
		
		Label moimoy = (Label)lookup("#mois-moyenne");
		moimoy.setText( String.valueOf(df.format(moisObjet.getDistanceMoyenneMois()))+" LD");
		
		
		
		// RÃ©cupÃ©ration de l'objet dans lequel afficher
		TableView tableau = (TableView)lookup("#mois-tableau");
		
		// Association des champs de l'objet avec les colonnes du tableau		
		TableColumn colonneMois = (TableColumn) tableau.getColumns().get(0);
		TableColumn colonneDistMin = (TableColumn) tableau.getColumns().get(1);
		TableColumn colonneDistMoy = (TableColumn) tableau.getColumns().get(2);
		TableColumn colonneDistMax = (TableColumn) tableau.getColumns().get(3);
		colonneMois.setCellValueFactory(new PropertyValueFactory<>("dateJour"));
		colonneDistMin.setCellValueFactory(new PropertyValueFactory<>("distanceMinimumJour"));
		colonneDistMoy.setCellValueFactory(new PropertyValueFactory<>("distanceMoyenneJour"));
		colonneDistMax.setCellValueFactory(new PropertyValueFactory<>("distanceMaximumJour"));
		
		for(Mois_JourModele jours : moisObjet.getListe())
		{
			tableau.getItems().add(jours);
		}
		
	}
}
