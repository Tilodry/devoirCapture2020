package vue;

import java.text.DecimalFormat;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurAnnee;
import donnee.AnneeDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Annee_Modele;
import modele.Annee_MoisModele;



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
		AnneeDAO test = new AnneeDAO();
		afficherEtudiants(test.lister().getListe());
		
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
	public void afficherEtudiants(List<Annee_MoisModele> mois)
	{	
		DecimalFormat df = new DecimalFormat("##.##");
		AnneeDAO anneeDao = new AnneeDAO();
		Annee_Modele anneeObjet = anneeDao.lister();
		
		Label anemi = (Label)lookup("#annee-minimum");
		anemi.setText( String.valueOf(df.format(anneeObjet.getDistanceMinimumAnnee()))+" LD");
		
		Label anema = (Label)lookup("#annee-maximum");
		anema.setText( String.valueOf(df.format(anneeObjet.getDistanceMaximumAnnee()))+" LD");
		
		Label anemoy = (Label)lookup("#annee-moyenne");
		anemoy.setText( String.valueOf(df.format(anneeObjet.getDistanceMoyenneAnnee()))+" LD");
		
		
		
		// RÃ©cupÃ©ration de l'objet dans lequel afficher
	
		TableView tableau = (TableView)lookup("#mois-tableau");
	
		
		// Association des champs de l'objet avec les colonnes du tableau	
		
		TableColumn colonneMois = (TableColumn) tableau.getColumns().get(0);
		TableColumn colonneDistMin = (TableColumn) tableau.getColumns().get(1);
		TableColumn colonneDistMoy = (TableColumn) tableau.getColumns().get(2);
		TableColumn colonneDistMax = (TableColumn) tableau.getColumns().get(3);
		colonneMois.setCellValueFactory(new PropertyValueFactory<>("dateMois"));
		colonneDistMin.setCellValueFactory(new PropertyValueFactory<>("distanceMinimumMois"));
		colonneDistMoy.setCellValueFactory(new PropertyValueFactory<>("distanceMoyenneMois"));
		colonneDistMax.setCellValueFactory(new PropertyValueFactory<>("distanceMaximumMois"));
		
		for(Annee_MoisModele annees : anneeObjet.getListe())
		{
			System.out.println("Date du mois : " + annees.getDateMois() );
			System.out.println("Distance minimum du mois : " + annees.getDistanceMinimumMois() );
			System.out.println("Distance moyenne du mois : " + annees.getDistanceMoyenneMois() );
			System.out.println("Distance maximum du mois : " + annees.getDistanceMaximumMois() );
			tableau.getItems().add(annees);
		}
		
	}
}
