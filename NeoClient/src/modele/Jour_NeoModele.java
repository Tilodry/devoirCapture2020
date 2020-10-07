/************************************************
* Auteur : Tilodry                              *
* Nom prog : NEO                                *
* Nom du fichier : Jour_NeoModele.java          *
* Role : Stocker les données relatives a un NEO *
* d'une journee                                 *
* Version : Finale                              *
* Date :  07/10/2020                            *
*************************************************/

package modele;

public class Jour_NeoModele 
{
	// ######################################## Attributs #########################################
	protected int id;
	protected float distance;
	protected String dateApproche;
	// ############################################################################################

	// ###################################### Constructeurs #######################################
	public Jour_NeoModele(int id, float distance, String dateApproche) {
		super();
		this.id = id;
		this.distance = distance;
		this.dateApproche = dateApproche;
	}
	// ############################################################################################
	
	// ################################## Fonctions utilisateurs ##################################
	public int getId() 
	{
			return id;
	}
	public float getDistance() 
	{
			return distance;
	}
	public String getDateApproche() 
	{
		return dateApproche;
	}
	// ############################################################################################
		
	// ########################################## Setters #########################################
	public void setDistance(float distance) {
		this.distance = distance;
	}
	
	public void setDateApproche(String dateApproche) {
		this.dateApproche = dateApproche;
	}
	public void setId(int id) {
		this.id = id;
	}
	// ############################################################################################
}
