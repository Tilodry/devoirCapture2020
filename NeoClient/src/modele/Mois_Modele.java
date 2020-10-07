/************************************************
* Auteur : Tilodry                              *
* Nom prog : NEO                                *
* Nom du fichier : Mois_Modele.java             *
* Role : Stocker les données relatives aux mois *
* renvoyées par l'API                           *
* Version : Finale                              *
* Date :  07/10/2020                            *
*************************************************/

package modele;

import java.util.ArrayList;
import java.util.List;

public class Mois_Modele 
{
	// ######################################## Attributs #########################################
	protected String mois;
	protected float minimum;
	protected float moyenne;
	protected float maximum;
	protected int nombreDeJour;
	protected List<Mois_JourModele> listeJour;
	// ############################################################################################

	// ###################################### Constructeurs #######################################
	public Mois_Modele(String mois, float minimum, float moyenne, float maximum) {
		super();
		this.mois = mois;
		this.minimum = minimum;
		this.moyenne = moyenne;
		this.maximum = maximum;
		this.nombreDeJour = 0;
		listeJour = new ArrayList<Mois_JourModele>();
	}
	public Mois_Modele()
	{
		super();
		this.nombreDeJour = 0;
		listeJour = new ArrayList<Mois_JourModele>();
	}
	// ############################################################################################

	// ################################## Fonctions utilisateurs ##################################
	public Mois_JourModele getJour(int i)
	{
		Mois_JourModele jour = new Mois_JourModele("Valeur incorrect", -1, -1, -1);
		try {
			jour = this.listeJour.get(i);
		}
		catch (IndexOutOfBoundsException exception) {
			System.out.println("Erreur : L'index de jour demandée est trop grande");
		}
		return jour;
	}
	public List<Mois_JourModele> getListe()
	{
		return this.listeJour;
	}
	public int getNombreDeJour() 
	{
		return nombreDeJour;
	}
	public String getMois() {
		return mois;
	}
	public float getDistanceMinimumMois() {
		return minimum;
	}
	public float getDistanceMoyenneMois() {
		return moyenne;
	}
	public float getDistanceMaximumMois() {
		return maximum;
	}
	// ############################################################################################
	
	// ##############################Fonctions pour ajout dans la liste############################
	public void addJour(Mois_JourModele jour)
	{
		this.listeJour.add(jour);
		this.nombreDeJour = this.listeJour.size();
	}
	// ############################################################################################
	
	// ########################################## Setters #########################################
	public void setMois(String mois) {
		this.mois = mois;
	}

	public void setMinimum(float minimum) {
		this.minimum = minimum;
	}

	public void setMoyenne(float moyenne) {
		this.moyenne = moyenne;
	}

	public void setMaximum(float maximum) {
		this.maximum = maximum;
	}
	// ############################################################################################
}
