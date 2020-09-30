package donnee.Jour;
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


public class JourDAO {

	
	@SuppressWarnings("deprecation")
	public void lister()
	{
		
		String BALISENeo = "near-earth-object";
		String BALISEJour = "jour";

		try {
			
			String xml = "<jour>\r\n"
					+ "	<date-jour>2020-01-01</date-jour>\r\n"
					+ "	<distance-minimum-jour>39.9785482853</distance-minimum-jour>\r\n"
					+ "	<distance-moyenne-jour>70.6153993155</distance-moyenne-jour>\r\n"
					+ "	<distance-maximum-jour>101.2522503457</distance-maximum-jour>\r\n"
					+ "	<liste-near-earth-objects>\r\n"
					+ "		<near-earth-object>\r\n"
					+ "			<id>1</id>\r\n"
					+ "			<distance>39.9785482853</distance>\r\n"
					+ "			<date-approche>2020-01-01 09:08:00</date-approche>\r\n"
					+ "		</near-earth-object>\r\n"
					+ "		<near-earth-object>\r\n"
					+ "			<id>2</id>\r\n"
					+ "			<distance>101.2522503457</distance>\r\n"
					+ "			<date-approche>2020-01-01 11:19:00</date-approche>\r\n"
					+ "		</near-earth-object>\r\n"
					+ "	</liste-near-earth-objects>\r\n"
					+ "</jour>";
			
			DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = parseur.parse(new StringBufferInputStream(xml));
			
			
			// Affichage des données relatives à l'année
			NodeList listeAnnee = document.getElementsByTagName(BALISEJour); 
			Element noeudAnnee = (Element)listeAnnee.item(0);
			String jour = noeudAnnee.getElementsByTagName("date-jour").item(0).getTextContent();
			String minimumJour = noeudAnnee.getElementsByTagName("distance-minimum-jour").item(0).getTextContent();
			String moyenneJour = noeudAnnee.getElementsByTagName("distance-moyenne-jour").item(0).getTextContent();
			String maximumJour = noeudAnnee.getElementsByTagName("distance-maximum-jour").item(0).getTextContent();			
			System.out.println("\n\n\n##########################Affichage des données de JourDAO.java :##########################\n"
					+ "\nJour : " + jour
					+ "\nDistance minimum du jour : " + minimumJour
					+ "\nDistance moyenne du jour : " + moyenneJour
					+ "\nDistance maximum du jour : " + maximumJour);
			
			//Affichage et enregistrement des données relatives aux mois
			NodeList listeMois = document.getElementsByTagName(BALISENeo);
			for(int position = 0; position < listeMois.getLength(); position++)
			{
				Element noeud = (Element)listeMois.item(position);
				
				String id = noeud.getElementsByTagName("id").item(0).getTextContent();
				String distance = noeud.getElementsByTagName("distance").item(0).getTextContent();
				String dateApproche = noeud.getElementsByTagName("date-approche").item(0).getTextContent();
				
				System.out.println("\nNEO n°" + id
						+ "\nDistance minimale de: " + distance
						+ "distance Terre-Lune atteinte le : " + dateApproche);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("###########################################################################################\n");
	}
}
