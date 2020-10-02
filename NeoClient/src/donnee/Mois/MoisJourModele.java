package donnee.Mois;

public class MoisJourModele {
	protected String dateJour;
	protected float distanceMinimumJour;
	protected float distanceMoyenneJour;
	protected float distanceMaximumJour;
	public MoisJourModele(String dateJour, float distanceMinimumJour, float distanceMoyenneJour,
			float distanceMaximumJour) {
		super();
		this.dateJour = dateJour;
		this.distanceMinimumJour = distanceMinimumJour;
		this.distanceMoyenneJour = distanceMoyenneJour;
		this.distanceMaximumJour = distanceMaximumJour;
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
}
