package modele;

import java.util.ArrayList;
import java.util.List;

public class Jour_Modele 
{
	protected String dateJour;
	protected float distanceMinimumJour;
	protected float distanceMoyenneJour;
	protected float distanceMaximumJour;
	protected int nombreDeNeo;
	protected List<Jour_NeoModele> listeNeo;
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
	// ####################################Fonctions pour LUCAS####################################
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
	// ############################################################################################
	
	// ##############################Fonctions pour ajout dans la liste############################
	public void AddNEO(Jour_NeoModele neo) 
	{
		this.listeNeo.add(neo);
		this.nombreDeNeo = this.listeNeo.size();
	}
	// ############################################################################################
	
	// #################################### Getters et setters ####################################
	public String getDateJour() {
		return dateJour;
	}
	public void setDateJour(String dateJour) {
		this.dateJour = dateJour;
	}
	public float getDistanceMinimumJour() {
		return distanceMinimumJour;
	}
	public void setDistanceMinimumJour(float distanceMinimumJour) {
		this.distanceMinimumJour = distanceMinimumJour;
	}
	public float getDistanceMoyenneJour() {
		return distanceMoyenneJour;
	}
	public void setDistanceMoyenneJour(float distanceMoyenneJour) {
		this.distanceMoyenneJour = distanceMoyenneJour;
	}
	public float getDistanceMaximumJour() {
		return distanceMaximumJour;
	}
	public void setDistanceMaximumJour(float distanceMaximumJour) {
		this.distanceMaximumJour = distanceMaximumJour;
	}
	// ############################################################################################
}
