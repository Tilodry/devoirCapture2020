package donnee.Mois;
import java.io.IOException;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class MoisDAO {

	
	@SuppressWarnings("deprecation")
	public MoisModele lister()
	{
		
		String BALISEJour = "jour";
		String BALISEMois = "mois";
		MoisModele moisObjet = new MoisModele();
		try {
			
			String xml = "<mois>\r\n"
					+ "	<date-mois>2020-01</date-mois>\r\n"
					+ "	<distance-minimum-mois>39.9785482853</distance-minimum-mois>\r\n"
					+ "	<distance-moyenne-mois>71.894683299825</distance-moyenne-mois>\r\n"
					+ "	<distance-maximum-mois>101.2522503457</distance-maximum-mois>\r\n"
					+ "	<liste-jours>\r\n"
					+ "		<jour>\r\n"
					+ "			<date-jour>2020-01-01</date-jour>\r\n"
					+ "			<distance-minimum-jour>39.9785482853</distance-minimum-jour>\r\n"
					+ "			<distance-moyenne-jour>70.6153993155</distance-moyenne-jour>\r\n"
					+ "			<distance-maximum-jour>101.2522503457</distance-maximum-jour>\r\n"
					+ "		</jour>\r\n"
					+ "		<jour>\r\n"
					+ "			<date-jour>2020-01-02</date-jour>\r\n"
					+ "			<distance-minimum-jour>68.1753672872</distance-minimum-jour>\r\n"
					+ "			<distance-moyenne-jour>73.17396728415</distance-moyenne-jour>\r\n"
					+ "			<distance-maximum-jour>78.1725672811</distance-maximum-jour>\r\n"
					+ "		</jour>\r\n"
					+ "	</liste-jours>\r\n"
					+ "</mois>";
			
			DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = parseur.parse(new StringBufferInputStream(xml));
			
			
			// Affichage des données relatives au mois
			NodeList listeAnnee = document.getElementsByTagName(BALISEMois); 
			Element noeudAnnee = (Element)listeAnnee.item(0);
			String mois = noeudAnnee.getElementsByTagName("date-mois").item(0).getTextContent();
			String minimumMois = noeudAnnee.getElementsByTagName("distance-minimum-mois").item(0).getTextContent();
			String moyenneMois = noeudAnnee.getElementsByTagName("distance-moyenne-mois").item(0).getTextContent();
			String maximumMois = noeudAnnee.getElementsByTagName("distance-maximum-mois").item(0).getTextContent();			
			/*System.out.println("\n\n\n##########################Affichage des données de MoisDAO.java :##########################\n"
					+ "\nMois : " + mois
					+ "\nDistance minimum du mois : " + minimumMois
					+ "\nDistance moyenne du mois : " + moyenneMois
					+ "\nDistance maximum du mois : " + maximumMois);*/
			moisObjet.setMois(mois);
			moisObjet.setMinimum(Float.parseFloat(minimumMois));
			moisObjet.setMoyenne(Float.parseFloat(moyenneMois));
			moisObjet.setMaximum(Float.parseFloat(maximumMois));
			
			//Affichage et enregistrement des données relatives aux jours
			NodeList listeMois = document.getElementsByTagName(BALISEJour);
			for(int position = 0; position < listeMois.getLength(); position++)
			{
				Element noeud = (Element)listeMois.item(position);
				
				String jour = noeud.getElementsByTagName("date-jour").item(0).getTextContent();
				String minimumJour = noeud.getElementsByTagName("distance-minimum-jour").item(0).getTextContent();
				String moyenneJour = noeud.getElementsByTagName("distance-moyenne-jour").item(0).getTextContent();
				String maximumJour = noeud.getElementsByTagName("distance-maximum-jour").item(0).getTextContent();
				
				/*System.out.println("\nDate du jour : " + jour
						+ "\nDistance minimum du jour: " + minimumJour
						+ "\nDistance moyenne du jour: " + moyenneJour
						+ "\nDistance maximum du jour: " + maximumJour);*/
				MoisJourModele jourObjet = new MoisJourModele(
						jour,
						Float.parseFloat(minimumJour),
						Float.parseFloat(moyenneJour),
						Float.parseFloat(maximumJour));
				moisObjet.addJour(jourObjet);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("###########################################################################################\n");
		return moisObjet;
	}
}
