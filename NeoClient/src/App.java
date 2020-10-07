
import donnee.AnneeDAO;
import donnee.JourDAO;
import donnee.MoisDAO;
import modele.Annee_Modele;
import modele.Annee_MoisModele;
import modele.Jour_Modele;
import modele.Jour_NeoModele;
import modele.Mois_JourModele;
import modele.Mois_Modele;
import vue.Fenetre;

public class App {

	public static void main(String[] parametres) {
		/*AnneeDAO anneeDao = new AnneeDAO();
		Annee_Modele anneeObjet = anneeDao.lister();
		
		System.out.println("Année : " + anneeObjet.getAnnee() );
		System.out.println("Minimum année : " + anneeObjet.getDistanceMinimumAnnee() );
		System.out.println("Moyenne année : " + anneeObjet.getDistanceMoyenneAnnee() );
		System.out.println("Maximum année : " + anneeObjet.getDistanceMaximumAnnee() );

		for(Annee_MoisModele mois : anneeObjet.getListe())
		{
			System.out.println("Date du mois : " + mois.getDateMois() );
			System.out.println("Distance minimum du mois : " + mois.getDistanceMinimumMois() );
			System.out.println("Distance moyenne du mois : " + mois.getDistanceMoyenneMois() );
			System.out.println("Distance maximum du mois : " + mois.getDistanceMaximumMois() );
		}*/
		
		/*JourDAO jourDao = new JourDAO();
		Jour_Modele jourObjet = jourDao.lister();
		
		System.out.println("Jour : " + jourObjet.getDateJour() );
		System.out.println("Minimum jour : " + jourObjet.getDistanceMinimumJour() );
		System.out.println("Moyenne jour : " + jourObjet.getDistanceMoyenneJour() );
		System.out.println("Maximum jour : " + jourObjet.getDistanceMaximumJour() );

		for(Jour_NeoModele neo : jourObjet.getListe())
		{
			System.out.println("ID du NEO : " + neo.getId() );
			System.out.println("Date d'approche : " + neo.getDateApproche() );
			System.out.println("Distance d'approche : " + neo.getDistance() );
		}*/
		
		MoisDAO moisDao = new MoisDAO();
		Mois_Modele moisObjet = moisDao.lister();
		
		System.out.println("Année : " + moisObjet.getMois() );
		System.out.println("Minimum année : " + moisObjet.getDistanceMaximumMois() );
		System.out.println("Moyenne année : " + moisObjet.getDistanceMoyenneMois() );
		System.out.println("Maximum année : " + moisObjet.getDistanceMinimumMois() );

		for(Mois_JourModele jour : moisObjet.getListe())
		{
			System.out.println("Date du jour : " + jour.getDateJour() );
			System.out.println("Distance minimum du jour : " + jour.getDistanceMinimumJour() );
			System.out.println("Distance moyenne du jour : " + jour.getDistanceMoyenneJour() );
			System.out.println("Distance maximum du jour : " + jour.getDistanceMaximumJour() );
		}
		Fenetre.launch(Fenetre.class, parametres);	
	}

}
