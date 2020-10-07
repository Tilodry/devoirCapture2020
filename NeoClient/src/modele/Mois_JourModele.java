/************************************************
* Auteur : Tilodry                              *
* Nom prog : NEO                                *
* Nom du fichier : Mois_JourModele.java         *
* Role : Stocker les données relatives a un jour*
* d'un mois                                     *
* Version : Finale                              *
* Date :  07/10/2020                            *
*************************************************/

package modele;

public class Mois_JourModele 
{
	// ######################################## Attributs #########################################
	protected String dateJour;
	protected float distanceMinimumJour;
	protected float distanceMoyenneJour;
	protected float distanceMaximumJour;
	// ############################################################################################

	// ###################################### Constructeurs #######################################
	public Mois_JourModele(String dateJour, float distanceMinimumJour, float distanceMoyenneJour,
			float distanceMaximumJour) {
		super();
		this.dateJour = dateJour;
		this.distanceMinimumJour = distanceMinimumJour;
		this.distanceMoyenneJour = distanceMoyenneJour;
		this.distanceMaximumJour = distanceMaximumJour;
	}
	// ############################################################################################

	// ################################## Fonctions utilisateurs ##################################
	public String getDateJour() {
		return dateJour;
	}
	public float getDistanceMinimumJour() {
		return distanceMinimumJour;
	}
	public float getDistanceMoyenneJour() {
		return distanceMoyenneJour;
	}
	public float getDistanceMaximumJour() {
		return distanceMaximumJour;
	}
	// ############################################################################################
	
	// ########################################## Setters #########################################
	public void setDateJour(String dateJour) {
		this.dateJour = dateJour;
	}
	public void setDistanceMinimumJour(float distanceMinimumJour) {
		this.distanceMinimumJour = distanceMinimumJour;
	}
	public void setDistanceMoyenneJour(float distanceMoyenneJour) {
		this.distanceMoyenneJour = distanceMoyenneJour;
	}
	public void setDistanceMaximumJour(float distanceMaximumJour) {
		this.distanceMaximumJour = distanceMaximumJour;
	}
	// ############################################################################################
}
