
import donnee.Annee.AnneeDAO;
import donnee.Annee.AnneeModele;
import donnee.Jour.JourDAO;
import donnee.Jour.JourModele;
import donnee.Mois.MoisDAO;
import donnee.Mois.MoisModele;
import vue.Fenetre;

public class App {

	public static void main(String[] parametres) {
		/*AnneeDAO anneeDao = new AnneeDAO();
		AnneeModele anneeObjet = anneeDao.lister();
		MoisDAO moisDao = new MoisDAO();
		MoisModele moisObjet = moisDao.lister();
		JourDAO jourDao = new JourDAO();
		JourModele jourObjet = jourDao.lister();
		System.out.println("Date d'approche NEO 1 : " + jourObjet.getNEO(1).getDateApproche());
		System.out.println("Distance Moyenne Jour : " + moisObjet.getJour(1).getDistanceMoyenneJour());
		System.out.println("Date du mois : " + anneeObjet.getMois(1).getDateMois() );*/

		Fenetre.launch(Fenetre.class, parametres);	
	}

}
