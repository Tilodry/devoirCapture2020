/************************************************
* Auteur : Tilodry                              *
* Nom prog : NEO                                *
* Nom du fichier : Jour_Modele.java             *
* Role : Stocker les données relatives aux jours*
* renvoyées par l'API                           *
* Version : Finale                              *
* Date :  07/10/2020                            *
*************************************************/
package modele;

import java.util.ArrayList;
import java.util.List;

public class Jour_Modele 
{
	// ######################################## Attributs #########################################
	protected String dateJour;
	protected float distanceMinimumJour;
	protected float distanceMoyenneJour;
	protected float distanceMaximumJour;
	protected int nombreDeNeo;
	protected List<Jour_NeoModele> listeNeo;
	// ############################################################################################
	
	// ###################################### Constructeurs #######################################
	public Jour_Modele(String dateJour, float distanceMinimumJour, float distanceMoyenneJour, float distanceMaximumJour) {
		super();
		this.dateJour = dateJour;
		this.distanceMinimumJour = distanceMinimumJour;
		this.distanceMoyenneJour = distanceMoyenneJour;
		this.distanceMaximumJour = distanceMaximumJour;
		listeNeo = new ArrayList<>();
	}
	public Jour_Modele() {
		super();
		this.nombreDeNeo = 0;
		listeNeo = new ArrayList<>();
	}
	// ############################################################################################

	// ################################## Fonctions utilisateurs ##################################
	public Jour_NeoModele getNEO(int i) 
	{
		Jour_NeoModele neo = new Jour_NeoModele(-1, -1, "-1");
		try {
			neo = this.listeNeo.get(i);
		}
		catch (IndexOutOfBoundsException exception) {
			System.out.println("Erreur : L'index de NEO demandée est trop grande");
		}
		return neo;
	}
	public List<Jour_NeoModele> getListe()
	{
		return this.listeNeo;
	}
	public int getNombreDeNeo() 
	{
		return this.nombreDeNeo;
	}
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
	
	// ##############################Fonctions pour ajout dans la liste############################
	public void AddNEO(Jour_NeoModele neo) 
	{
		this.listeNeo.add(neo);
		this.nombreDeNeo = this.listeNeo.size();
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
