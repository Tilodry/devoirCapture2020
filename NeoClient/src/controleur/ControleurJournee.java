package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import vue.*;

public class ControleurJournee extends Controleur {
	
	public ControleurJournee()
	{
		Logger.logMsg(Logger.INFO, "new ControleurJournee()");
	}
	
	public void actionNaviguerAccueil() 
	{
		Logger.logMsg(Logger.INFO, "ControleurJournee.actionNaviguerAccueil()");
		Navigateur.getInstance().afficherVue(VueAccueil.getInstance());
	}
	
	public void actionNaviguerMois() 
	{
		Logger.logMsg(Logger.INFO, "ControleurJournee.actionNaviguerMois()");
		Navigateur.getInstance().afficherVue(VueMois.getInstance());
	}
	
	public void actionNaviguerAnnee() 
	{
		Logger.logMsg(Logger.INFO, "ControleurJournee.actionNaviguerAnnee()");
		Navigateur.getInstance().afficherVue(VueAnnee.getInstance());
	}

}
