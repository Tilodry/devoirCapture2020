package donnee;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.net.URL;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import modele.Jour_Modele;
import modele.Jour_NeoModele;


public class JourDAO {

	
	@SuppressWarnings("deprecation")
	public Jour_Modele lister()
	{

		String BALISENeo = "near-earth-object";
		String BALISEJour = "jour";
		Jour_Modele jourObjet = new Jour_Modele();
		try {
			
			String URL_LISTE = "http://51.210.104.114/NeoService/annee/2020/mois/1/jour/1/";
			String derniereBalise = "</jour>";			
			URL urlListe = new URL(URL_LISTE);
			InputStream flux;
			flux = urlListe.openConnection().getInputStream();
			Scanner lecteur = new Scanner(flux);
			lecteur.useDelimiter(derniereBalise);
			String xml = lecteur.next() + derniereBalise;
			lecteur.close();
			xml = new String(xml.getBytes("UTF-8"), "ISO-8859-1");
			
			/*String xml = "<jour>\r\n"
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
					*/
			
			DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = parseur.parse(new StringBufferInputStream(xml));
			
			
			//Enregistrement des données relatives à l'année
			NodeList listeAnnee = document.getElementsByTagName(BALISEJour); 
			Element noeudAnnee = (Element)listeAnnee.item(0);
			String jour = noeudAnnee.getElementsByTagName("date-jour").item(0).getTextContent();
			String minimumJour = noeudAnnee.getElementsByTagName("distance-minimum-jour").item(0).getTextContent();
			String moyenneJour = noeudAnnee.getElementsByTagName("distance-moyenne-jour").item(0).getTextContent();
			String maximumJour = noeudAnnee.getElementsByTagName("distance-maximum-jour").item(0).getTextContent();			

			jourObjet.setDateJour(jour);
			jourObjet.setDistanceMinimumJour(Float.parseFloat(minimumJour));
			jourObjet.setDistanceMoyenneJour(Float.parseFloat(moyenneJour));
			jourObjet.setDistanceMaximumJour(Float.parseFloat(maximumJour));

			
			//Enregistrement des données relatives aux mois
			NodeList listeMois = document.getElementsByTagName(BALISENeo);
			for(int position = 0; position < listeMois.getLength(); position++)
			{
				Element noeud = (Element)listeMois.item(position);
				
				String id = noeud.getElementsByTagName("id").item(0).getTextContent();
				String distance = noeud.getElementsByTagName("distance").item(0).getTextContent();
				String dateApproche = noeud.getElementsByTagName("date-approche").item(0).getTextContent();
				
				Jour_NeoModele neo = new Jour_NeoModele(Integer.parseInt(id), Float.parseFloat(distance), dateApproche);
				jourObjet.AddNEO(neo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return jourObjet;
	}
}
