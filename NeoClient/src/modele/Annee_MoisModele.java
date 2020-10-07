/************************************************
* Auteur : Tilodry                              *
* Nom prog : NEO                                *
* Nom du fichier : Annee_MoisModele.java        *
* Role : Stocker les données relatives a un mois*
* d'une annee                                   *
* Version : Finale                              *
* Date :  07/10/2020                            *
*************************************************/
package modele;

public class Annee_MoisModele 
{
	// ######################################## Attributs #########################################
	protected String dateMois;
	protected float distanceMinimumMois;
	protected float distanceMoyenneMois;
	protected float distanceMaximumMois;
	// ############################################################################################

	// ###################################### Constructeurs #######################################
	public Annee_MoisModele(String dateJour, float distanceMinimumJour, float distanceMoyenneJour,
			float distanceMaximumJour) {
		super();
		this.dateMois = dateJour;
		this.distanceMinimumMois = distanceMinimumJour;
		this.distanceMoyenneMois = distanceMoyenneJour;
		this.distanceMaximumMois = distanceMaximumJour;
	}	
	// ############################################################################################

	// ################################## Fonctions utilisateurs ##################################
	public String getDateMois() {
		return dateMois;
	}
	public float getDistanceMaximumMois() {
		return distanceMaximumMois;
	}
	public float getDistanceMoyenneMois() {
		return distanceMoyenneMois;
	}
	public float getDistanceMinimumMois() {
		return distanceMinimumMois;
	}
	// ############################################################################################
	
	// ########################################## Setters #########################################
	public void setDateMois(String dateMois) {
		this.dateMois = dateMois;
	}
	public void setDistanceMinimumMois(float distanceMinimumMois) {
		this.distanceMinimumMois = distanceMinimumMois;
	}
	public void setDistanceMoyenneMois(float distanceMoyenneMois) {
		this.distanceMoyenneMois = distanceMoyenneMois;
	}
	public void setDistanceMaximumMois(float distanceMaximumMois) {
		this.distanceMaximumMois = distanceMaximumMois;
	}
	// ############################################################################################
}
