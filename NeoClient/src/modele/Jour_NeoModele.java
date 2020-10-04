package modele;

public class Jour_NeoModele {
	protected int id;
	protected float distance;
	protected String dateApproche;
	public Jour_NeoModele(int id, float distance, String dateApproche) {
		super();
		this.id = id;
		this.distance = distance;
		this.dateApproche = dateApproche;
	}
	// ####################################Fonctions pour LUCAS (getters)####################################
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
	// ######################################################################################################
	
	// ############################################### Setters ##############################################
	public void setDistance(float distance) {
		this.distance = distance;
	}

	public void setDateApproche(String dateApproche) {
		this.dateApproche = dateApproche;
	}
	public void setId(int id) {
		this.id = id;
	}
	// ######################################################################################################
}
