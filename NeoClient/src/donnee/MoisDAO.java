/************************************************
* Auteur : Tilodry                              *
* Nom prog : NEO                                *
* Nom du fichier : MoisDAO.java                 *
* Role : DAO pour objet Mois_Modele             *
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
import modele.Mois_JourModele;
import modele.Mois_Modele;


public class MoisDAO {

	
	@SuppressWarnings("deprecation")
	public Mois_Modele lister()
	{
		
		String BALISEJour = "jour";
		String BALISEMois = "mois";
		Mois_Modele moisObjet = new Mois_Modele();
		
		try {
				// ############################## Reception du XML et parsage des valeurs ###############################	
				String URL_LISTE = "http://51.210.104.114/NeoService/annee/";
				URL_LISTE += java.time.LocalDate.now().getYear() + "/mois/" 
				+ java.time.LocalDate.now().getMonthValue() + "/";
				
				String derniereBalise = "</mois>";			
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
				
				// ############################## Enregistrement des données liées au mois ##############################
				NodeList listeAnnee = document.getElementsByTagName(BALISEMois); 
				Element noeudAnnee = (Element)listeAnnee.item(0);
				String mois = noeudAnnee.getElementsByTagName("date-mois").item(0).getTextContent();
				String minimumMois = noeudAnnee.getElementsByTagName("distance-minimum-mois").item(0).getTextContent();
				String moyenneMois = noeudAnnee.getElementsByTagName("distance-moyenne-mois").item(0).getTextContent();
				String maximumMois = noeudAnnee.getElementsByTagName("distance-maximum-mois").item(0).getTextContent();			
	
				moisObjet.setMois(mois);
				moisObjet.setMinimum(Float.parseFloat(minimumMois));
				moisObjet.setMoyenne(Float.parseFloat(moyenneMois));
				moisObjet.setMaximum(Float.parseFloat(maximumMois));
				// ######################################################################################################
	
				// ######################## Enregistrement des données liées a la liste de jours ########################
				NodeList listeMois = document.getElementsByTagName(BALISEJour);
				for(int position = 0; position < listeMois.getLength(); position++)
				{
					Element noeud = (Element)listeMois.item(position);
					
					String jour = noeud.getElementsByTagName("date-jour").item(0).getTextContent();
					String minimumJour = noeud.getElementsByTagName("distance-minimum-jour").item(0).getTextContent();
					String moyenneJour = noeud.getElementsByTagName("distance-moyenne-jour").item(0).getTextContent();
					String maximumJour = noeud.getElementsByTagName("distance-maximum-jour").item(0).getTextContent();
					
					Mois_JourModele jourObjet = new Mois_JourModele(
							jour,
							Float.parseFloat(minimumJour),
							Float.parseFloat(moyenneJour),
							Float.parseFloat(maximumJour));
					moisObjet.addJour(jourObjet);
				}
				// ######################################################################################################			

			} catch (Exception e) {
				e.printStackTrace();
		}
		return moisObjet;
	}
}
