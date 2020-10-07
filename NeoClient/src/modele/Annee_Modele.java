/************************************************
* Auteur : Tilodry                              *
* Nom prog : NEO                                *
* Nom du fichier : Annee_Modele.java            *
* Role : Stocker les données relatives a l'année*
* renvoyées par l'API                           *
* Version : Finale                              *
* Date :  07/10/2020                            *
*************************************************/

package modele;

import java.util.ArrayList;
import java.util.List;

public class Annee_Modele 
{
	// ######################################## Attributs #########################################
	protected String annee;
	protected float distanceMinimumAnnee;
	protected float distanceMoyenneAnnee;
	protected float distanceMaximumAnnee;
	protected int nombreDeJour;
	protected List<Annee_MoisModele> listeMois;
	// ############################################################################################


	// ###################################### Constructeurs #######################################
	public Annee_Modele(String annee, float distanceMinimumAnnee, float distanceMoyenneAnnee,
			float distanceMaximumAnnee) {
		super();
		this.annee = annee;
		this.distanceMinimumAnnee = distanceMinimumAnnee;
		this.distanceMoyenneAnnee = distanceMoyenneAnnee;
		this.distanceMaximumAnnee = distanceMaximumAnnee;
		this.nombreDeJour = 0;
		listeMois = new ArrayList<>();
	}
	public Annee_Modele() {
		super();
		this.nombreDeJour = 0;
		this.listeMois = new ArrayList<>();
	}
	// ############################################################################################

	
	// ################################## Fonctions utilisateurs ##################################
	public Annee_MoisModele getMois(int i)
	{
		Annee_MoisModele  mois = new Annee_MoisModele("Valeur incorrect", -1, -1, -1);
		try {
			mois = this.listeMois.get(i);
		}
		catch (IndexOutOfBoundsException exception) {
			System.out.println("Erreur : L'index de mois demandé est trop grand");
		}
		return mois;
	}
	public List<Annee_MoisModele> getListe()
	{
		return this.listeMois;
	}
	public int getNombreDeJour() 
	{
		return this.nombreDeJour;
	}
	public String getAnnee() {
		return annee;
	}
	public float getDistanceMinimumAnnee() {
		return distanceMinimumAnnee;
	}
	public float getDistanceMoyenneAnnee() {
		return distanceMoyenneAnnee;
	}
	public float getDistanceMaximumAnnee() {
		return distanceMaximumAnnee;
	}
	// ############################################################################################
	
	// ############################# Fonctions pour ajout dans la liste ###########################
	public void AddMois(Annee_MoisModele mois)
	{
		this.listeMois.add(mois);
		this.nombreDeJour = this.listeMois.size();
	}
	// ############################################################################################
	
	// ######################################### Setters ##########################################
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	public void setDistanceMinimumAnnee(float distanceMinimumAnnee) {
		this.distanceMinimumAnnee = distanceMinimumAnnee;
	}

	public void setDistanceMoyenneAnnee(float distanceMoyenneAnnee) {
		this.distanceMoyenneAnnee = distanceMoyenneAnnee;
	}

	public void setDistanceMaximumAnnee(float distanceMaximumAnnee) {
		this.distanceMaximumAnnee = distanceMaximumAnnee;
	}
	// ############################################################################################
}
