
import donnee.AnneeDAO;
import donnee.JourDAO;
import donnee.MoisDAO;
import modele.Annee_Modele;
import modele.Annee_MoisModele;
import modele.Jour_Modele;
import modele.Mois_Modele;
import vue.Fenetre;

public class App {

	public static void main(String[] parametres) {
		AnneeDAO anneeDao = new AnneeDAO();
		Annee_Modele anneeObjet = anneeDao.lister();
		
		System.out.println("Ann�e : " + anneeObjet.getAnnee() );
		System.out.println("Minimum ann�e : " + anneeObjet.getDistanceMinimumAnnee() );
		System.out.println("Moyenne ann�e : " + anneeObjet.getDistanceMoyenneAnnee() );
		System.out.println("Maximum ann�e : " + anneeObjet.getDistanceMaximumAnnee() );

		for(Annee_MoisModele mois : anneeObjet.getListe())
		{
			System.out.println("Date du mois : " + mois.getDateMois() );
			System.out.println("Distance minimum du mois : " + mois.getDistanceMinimumMois() );
			System.out.println("Distance moyenne du mois : " + mois.getDistanceMoyenneMois() );
			System.out.println("Distance maximum du mois : " + mois.getDistanceMaximumMois() );
		}
		Fenetre.launch(Fenetre.class, parametres);	
	}

}
