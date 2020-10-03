package donnee.Annee;

public class AnneeMoisModele {
	protected String dateMois;
	protected float distanceMinimumMois;
	protected float distanceMoyenneMois;
	protected float distanceMaximumMois;
	public AnneeMoisModele(String dateJour, float distanceMinimumJour, float distanceMoyenneJour,
			float distanceMaximumJour) {
		super();
		this.dateMois = dateJour;
		this.distanceMinimumMois = distanceMinimumJour;
		this.distanceMoyenneMois = distanceMoyenneJour;
		this.distanceMaximumMois = distanceMaximumJour;
	}	
	public String getDateMois() {
		return dateMois;
	}
	public void setDateMois(String dateMois) {
		this.dateMois = dateMois;
	}
	public float getDistanceMinimumMois() {
		return distanceMinimumMois;
	}
	public void setDistanceMinimumMois(float distanceMinimumMois) {
		this.distanceMinimumMois = distanceMinimumMois;
	}
	public float getDistanceMoyenneMois() {
		return distanceMoyenneMois;
	}
	public void setDistanceMoyenneMois(float distanceMoyenneMois) {
		this.distanceMoyenneMois = distanceMoyenneMois;
	}
	public float getDistanceMaximumMois() {
		return distanceMaximumMois;
	}
	public void setDistanceMaximumMois(float distanceMaximumMois) {
		this.distanceMaximumMois = distanceMaximumMois;
	}
}
