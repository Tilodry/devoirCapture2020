package donnee;
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

import modele.Annee_Modele;
import modele.Annee_MoisModele;


public class AnneeDAO {

	
	@SuppressWarnings("deprecation")
	public Annee_Modele lister()
	{
		
		String BALISEMois = "mois";
		String BALISEAnnee = "annee";
		Annee_Modele anneeObjet = new Annee_Modele();
		try {
			String xml = "<annee>\r\n"
					+ "	<date-annee>2020</date-annee>\r\n"
					+ "	<distance-minimum-annee>10.4730648551</distance-minimum-annee>\r\n"
					+ "	<distance-moyenne-annee>59.61035961088</distance-moyenne-annee>\r\n"
					+ "	<distance-maximum-annee>101.2522503457</distance-maximum-annee>\r\n"
					+ "	<liste-mois>\r\n"
					+ "		<mois>\r\n"
					+ "			<date-mois>2020-01</date-mois>\r\n"
					+ "			<distance-minimum-mois>39.9785482853</distance-minimum-mois>\r\n"
					+ "			<distance-moyenne-mois>71.894683299825</distance-moyenne-mois>\r\n"
					+ "			<distance-maximum-mois>101.2522503457</distance-maximum-mois>\r\n"
					+ "		</mois>\r\n"
					+ "		<mois>\r\n"
					+ "			<date-mois>2020-02</date-mois>\r\n"
					+ "			<distance-minimum-mois>10.4730648551</distance-minimum-mois>\r\n"
					+ "			<distance-moyenne-mois>10.4730648551</distance-moyenne-mois>\r\n"
					+ "			<distance-maximum-mois>10.4730648551</distance-maximum-mois>\r\n"
					+ "		</mois>\r\n"
					+ "	</liste-mois>\r\n"
					+ "</annee>";
			
			DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = parseur.parse(new StringBufferInputStream(xml));
			
			//Enregistrement des données relatives à l'année
			NodeList listeAnnee = document.getElementsByTagName(BALISEAnnee); 
			Element noeudAnnee = (Element)listeAnnee.item(0);
			
			String annee = noeudAnnee.getElementsByTagName("date-annee").item(0).getTextContent();
			String minimumAnnee = noeudAnnee.getElementsByTagName("distance-minimum-annee").item(0).getTextContent();
			String moyenneAnnee = noeudAnnee.getElementsByTagName("distance-moyenne-annee").item(0).getTextContent();
			String maximumAnnee = noeudAnnee.getElementsByTagName("distance-maximum-annee").item(0).getTextContent();
			
			anneeObjet.setAnnee(annee);
			anneeObjet.setDistanceMinimumAnnee(Float.parseFloat(minimumAnnee));
			anneeObjet.setDistanceMoyenneAnnee(Float.parseFloat(moyenneAnnee));
			anneeObjet.setDistanceMaximumAnnee(Float.parseFloat(maximumAnnee));
			
			//Enregistrement des données relatives aux mois
			NodeList listeMois = document.getElementsByTagName(BALISEMois);
			for(int position = 0; position < listeMois.getLength(); position++)
			{
				Element noeud = (Element)listeMois.item(position);
				String mois = noeud.getElementsByTagName("date-mois").item(0).getTextContent();
				String minimum = noeud.getElementsByTagName("distance-minimum-mois").item(0).getTextContent();
				String moyenne = noeud.getElementsByTagName("distance-moyenne-mois").item(0).getTextContent();
				String maximum = noeud.getElementsByTagName("distance-maximum-mois").item(0).getTextContent();
				
				Annee_MoisModele moisObjet = new Annee_MoisModele(mois, 
						Float.parseFloat(minimum),
						Float.parseFloat(moyenne),
						Float.parseFloat(maximum));
				anneeObjet.AddMois(moisObjet);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return anneeObjet;
		
	}
}
