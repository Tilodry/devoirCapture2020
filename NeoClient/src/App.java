
import donnee.Annee.AnneeDAO;
import donnee.Jour.JourDAO;
import donnee.Mois.MoisDAO;
import vue.Fenetre;

public class App {

	public static void main(String[] parametres) {
		AnneeDAO anneeDao = new AnneeDAO();
		anneeDao.lister();
		MoisDAO moisDao = new MoisDAO();
		moisDao.lister();
		JourDAO jourDao = new JourDAO();
		jourDao.lister();
		Fenetre.launch(Fenetre.class, parametres);	
	}

}
