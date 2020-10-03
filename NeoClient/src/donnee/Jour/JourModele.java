package donnee.Jour;

import java.util.ArrayList;
import java.util.List;

public class JourModele 
{
	protected String dateJour;
	protected float distanceMinimumJour;
	protected float distanceMoyenneJour;
	protected float distanceMaximumJour;
	protected int nombreDeNeo;
	protected List<NeoModele> listeNeo;
	public JourModele() {
		super();
		listeNeo = new ArrayList<>();
	}
	public JourModele(String dateJour, float distanceMinimumJour, float distanceMoyenneJour, float distanceMaximumJour) {
		super();
		this.dateJour = dateJour;
		this.distanceMinimumJour = distanceMinimumJour;
		this.distanceMoyenneJour = distanceMoyenneJour;
		this.distanceMaximumJour = distanceMaximumJour;
		listeNeo = new ArrayList<>();
	}
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
	public int getNombreDeNeo() {
		return nombreDeNeo;
	}
	public void AddNEO(NeoModele neo)
	{
		this.listeNeo.add(neo);
		this.nombreDeNeo = this.listeNeo.size();
	}
	public NeoModele getNEO(int i)
	{
		NeoModele neo = new NeoModele(-1, -1, "-1");
		try {
			neo = this.listeNeo.get(i);
		}
		catch (IndexOutOfBoundsException exception) {
			System.out.println("Erreur : L'index de NEO demandée est trop grande");
		}
		return neo;
	}
}
