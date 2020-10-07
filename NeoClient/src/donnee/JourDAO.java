/************************************************
* Auteur : Tilodry                              *
* Nom prog : NEO                                *
* Nom du fichier : JourDAO.java                 *
* Role : DAO pour objet Jour_Modele             *
* Version : Finale                              *
* Date :  07/10/2020                            *
*************************************************/

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
				// ############################## Reception du XML et parsage des valeurs ###############################
				String URL_LISTE = "http://51.210.104.114/NeoService/annee/";
				URL_LISTE += java.time.LocalDate.now().getYear() + "/mois/" 
				+ java.time.LocalDate.now().getMonthValue() + "/jour/" 
				+ java.time.LocalDate.now().getDayOfMonth() + "/";
	
				String derniereBalise = "</jour>";			
				URL urlListe = new URL(URL_LISTE);
				InputStream flux;
				flux = urlListe.openConnection().getInputStream();
				Scanner lecteur = new Scanner(flux);
				lecteur.useDelimiter(derniereBalise);
				String xml = lecteur.next() + derniereBalise;
				lecteur.close();
				xml = new String(xml.getBytes("UTF-8"), "ISO-8859-1");
				
				DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				Document document = parseur.parse(new StringBufferInputStream(xml));
				// ######################################################################################################		
	
				// ############################## Enregistrement des données liées au jour ##############################
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
				// ######################################################################################################
	
				// ######################### Enregistrement des données liées a la liste de NEO #########################
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
				// ######################################################################################################
			
			} catch (Exception e) {
				e.printStackTrace();
		}
		return jourObjet;
	}
}
