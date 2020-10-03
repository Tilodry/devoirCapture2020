package donnee.Annee;

import java.util.ArrayList;
import java.util.List;

public class AnneeModele 
{
	protected String annee;
	protected float distanceMinimumAnnee;
	protected float distanceMoyenneAnnee;
	protected float distanceMaximumAnnee;
	protected int nombreDeJour;
	protected List<AnneeMoisModele> listeMois;

	public AnneeModele(String annee, float distanceMinimumAnnee, float distanceMoyenneAnnee,
			float distanceMaximumAnnee) {
		super();
		this.annee = annee;
		this.distanceMinimumAnnee = distanceMinimumAnnee;
		this.distanceMoyenneAnnee = distanceMoyenneAnnee;
		this.distanceMaximumAnnee = distanceMaximumAnnee;
		this.nombreDeJour = 0;
		listeMois = new ArrayList<>();
	}
	public AnneeModele() {
		super();
		this.nombreDeJour = 0;
		this.listeMois = new ArrayList<>();
	}
	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	public float getDistanceMinimumAnnee() {
		return distanceMinimumAnnee;
	}
	public void setDistanceMinimumAnnee(float distanceMinimumAnnee) {
		this.distanceMinimumAnnee = distanceMinimumAnnee;
	}
	public float getDistanceMoyenneAnnee() {
		return distanceMoyenneAnnee;
	}
	public void setDistanceMoyenneAnnee(float distanceMoyenneAnnee) {
		this.distanceMoyenneAnnee = distanceMoyenneAnnee;
	}
	public float getDistanceMaximumAnnee() {
		return distanceMaximumAnnee;
	}
	public void setDistanceMaximumAnnee(float distanceMaximumAnnee) {
		this.distanceMaximumAnnee = distanceMaximumAnnee;
	}
	public int getNombreDeJour() {
		return nombreDeJour;
	}
	public void AddMois(AnneeMoisModele mois)
	{
		this.listeMois.add(mois);
		this.nombreDeJour = this.listeMois.size();
	}
	public AnneeMoisModele getMois(int i)
	{
		AnneeMoisModele  mois = new AnneeMoisModele("Valeur incorrect", -1, -1, -1);
		try {
			mois = this.listeMois.get(i);
		}
		catch (IndexOutOfBoundsException exception) {
			System.out.println("Erreur : L'index de mois demandé est trop grand");
		}
		return mois;
	}
}
