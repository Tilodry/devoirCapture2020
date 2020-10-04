package modele;

import java.util.ArrayList;
import java.util.List;

public class Mois_Modele 
{
	protected String mois;
	protected float minimum;
	protected float moyenne;
	protected float maximum;
	protected int nombreDeJour;
	protected List<Mois_JourModele> listeJour;
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
	// ####################################Fonctions pour LUCAS####################################
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
	// ############################################################################################
	
	// ##############################Fonctions pour ajout dans la liste############################
	public void addJour(Mois_JourModele jour)
	{
		this.listeJour.add(jour);
		this.nombreDeJour = this.listeJour.size();
	}
	// ############################################################################################
	
	// #################################### Getters et setters ####################################
	public String getMois() {
		return mois;
	}
	public void setMois(String mois) {
		this.mois = mois;
	}
	public float getMinimum() {
		return minimum;
	}
	public void setMinimum(float minimum) {
		this.minimum = minimum;
	}
	public float getMoyenne() {
		return moyenne;
	}
	public void setMoyenne(float moyenne) {
		this.moyenne = moyenne;
	}
	public float getMaximum() {
		return maximum;
	}
	public void setMaximum(float maximum) {
		this.maximum = maximum;
	}
	// ############################################################################################
}
