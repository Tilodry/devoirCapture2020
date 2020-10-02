package donnee.Jour;

public class NeoModele {
	protected int id;
	protected float distance;
	protected String dateApproche;
	public NeoModele(int id, float distance, String dateApproche) {
		super();
		this.id = id;
		this.distance = distance;
		this.dateApproche = dateApproche;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public String getDateApproche() {
		return dateApproche;
	}
	public void setDateApproche(String dateApproche) {
		this.dateApproche = dateApproche;
	}

}
