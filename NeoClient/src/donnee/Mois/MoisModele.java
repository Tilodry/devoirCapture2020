package donnee.Mois;

import java.util.ArrayList;
import java.util.List;

import donnee.Jour.NeoModele;

public class MoisModele 
{
	protected String mois;
	protected float minimum;
	protected float moyenne;
	protected float maximum;
	protected int nombreDeJour;
	protected List<MoisJourModele> listeJour;
	public MoisModele(String mois, float minimum, float moyenne, float maximum) {
		super();
		this.mois = mois;
		this.minimum = minimum;
		this.moyenne = moyenne;
		this.maximum = maximum;
		this.nombreDeJour = 0;
		listeJour = new ArrayList<MoisJourModele>();
	}
	public MoisModele()
	{
		super();
		this.nombreDeJour = 0;
		listeJour = new ArrayList<MoisJourModele>();
	}
	public int getNombreDeJour() {
		return nombreDeJour;
	}
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
	public void addJour(MoisJourModele jour)
	{
		this.listeJour.add(jour);
		this.nombreDeJour = this.listeJour.size();
	}
	public MoisJourModele getJour(int i)
	{
		MoisJourModele jour = new MoisJourModele("Valeur incorrect", -1, -1, -1);
		try {
			jour = this.listeJour.get(i);
		}
		catch (IndexOutOfBoundsException exception) {
			System.out.println("Erreur : L'index de jour demandée est trop grande");
		}
		return jour;
	}
}
