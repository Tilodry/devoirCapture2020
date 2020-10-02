package donnee.Mois;

public class MoisModele 
{
	protected String mois;
	protected float minimum;
	protected float moyenne;
	protected float maximum;
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
	public MoisModele(String mois) {
		super();
		this.mois = mois;
	}
	public MoisModele(String mois, float minimum, float moyenne, float maximum) {
		super();
		this.mois = mois;
		this.minimum = minimum;
		this.moyenne = moyenne;
		this.maximum = maximum;
	}
	public void debugPrint()
	{
		System.out.println(" Mois : " + mois + "\n Minimum : " + minimum + "\n Moyenne : " + moyenne + "\n Maximum : " + maximum);
	}
}
