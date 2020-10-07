/************************************************
* Auteur : Tilodry                              *
* Nom prog : NEO                                *
* Nom du fichier : AnneeDAO.java                *
* Role : DAO pour objet Annee_Modele            *
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
				// ############################## Reception du XML et parsage des valeurs ###############################
				String URL_LISTE = "http://51.210.104.114/NeoService/annee/";
				URL_LISTE += java.time.LocalDate.now().getYear() + "/";
				
				String derniereBalise = "</annee>";			
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

				
				// ############################# Enregistrement des données liées à l'année #############################
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
				// ######################################################################################################		
				
				// ######################### Enregistrement des données liées a la liste de NEO #########################
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
				// ######################################################################################################			

			} catch (Exception e) {
				e.printStackTrace();
		}
		
		return anneeObjet;
		
	}
}
