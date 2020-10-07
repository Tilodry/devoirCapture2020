package vue;

import java.text.DecimalFormat;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurJournee;
import donnee.AnneeDAO;
import donnee.JourDAO;
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
		
		JourDAO test = new JourDAO();
		afficherJournees(test.lister().getListe());
		
		
		
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
	
	
	public void afficherJournees(List<Jour_NeoModele> jour)
	{	
		DecimalFormat df = new DecimalFormat("##.##");
		JourDAO jourDao = new JourDAO();
		Jour_Modele jourObjet = jourDao.lister();
		
		
		
		
		Label joumi = (Label)lookup("#journee-minimum");
		joumi.setText( String.valueOf(df.format(jourObjet.getDistanceMinimumJour()))+" LD");
		
		Label jouma = (Label)lookup("#journee-maximum");
		jouma.setText( String.valueOf(df.format(jourObjet.getDistanceMaximumJour()))+" LD");
		
		Label joumoy = (Label)lookup("#journee-moyenne");
		joumoy.setText( String.valueOf(df.format(jourObjet.getDistanceMoyenneJour()))+" LD");
		
		
		
		// RÃ©cupÃ©ration de l'objet dans lequel afficher
		TableView tableau = (TableView)lookup("#journee-tableau");
		
		// Association des champs de l'objet avec les colonnes du tableau		
		TableColumn colonneDateApproche = (TableColumn) tableau.getColumns().get(2);
		TableColumn colonneDistance = (TableColumn) tableau.getColumns().get(1);
		TableColumn colonneId = (TableColumn) tableau.getColumns().get(0);
		colonneDateApproche.setCellValueFactory(new PropertyValueFactory<>("dateApproche"));
		colonneDistance.setCellValueFactory(new PropertyValueFactory<>("distance"));
		colonneId.setCellValueFactory(new PropertyValueFactory<>("id"));
	
		
		for(Jour_NeoModele journees : jourObjet.getListe())
		{
			System.out.println("Date du mois : " + journees.getDateApproche() );
			System.out.println("Distance minimum du mois : " + journees.getDistance());
			System.out.println("Distance moyenne du mois : " + journees.getId()  );
			
			tableau.getItems().add(journees);
		}
		
	}
}

