package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import vue.*;

public class ControleurAnnee extends Controleur {
	
	public ControleurAnnee()
	{
		Logger.logMsg(Logger.INFO, "new ControleurAnnee()");
	}
	
	public void actionNaviguerAccueil() 
	{
		Logger.logMsg(Logger.INFO, "ControleurAnnee.actionNaviguerAccueil()");
		Navigateur.getInstance().afficherVue(VueAccueil.getInstance());
	}
	
	public void actionNaviguerJournee() 
	{
		Logger.logMsg(Logger.INFO, "ControleurAnnee.actionNaviguerJournee()");
		Navigateur.getInstance().afficherVue(VueJournee.getInstance());
	}
	
	public void actionNaviguerMois() 
	{
		Logger.logMsg(Logger.INFO, "ControleurAnnee.actionNaviguerMois()");
		Navigateur.getInstance().afficherVue(VueMois.getInstance());
	}

}
