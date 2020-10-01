package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import vue.*;

public class ControleurMois extends Controleur {
	
	public ControleurMois()
	{
		Logger.logMsg(Logger.INFO, "new ControleurMois()");
	}
	
	public void actionNaviguerAccueil() 
	{
		Logger.logMsg(Logger.INFO, "ControleurMois.actionNaviguerAccueil()");
		Navigateur.getInstance().afficherVue(VueAccueil.getInstance());
	}
	
	public void actionNaviguerJournee() 
	{
		Logger.logMsg(Logger.INFO, "ControleurMois.actionNaviguerJournee()");
		Navigateur.getInstance().afficherVue(VueJournee.getInstance());
	}
	
	public void actionNaviguerAnnee() 
	{
		Logger.logMsg(Logger.INFO, "ControleurMois.actionNaviguerAnnee()");
		Navigateur.getInstance().afficherVue(VueAnnee.getInstance());
	}


}
