package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import vue.Navigateur;
import vue.*;

public class ControleurAccueil extends Controleur{

	public ControleurAccueil()
	{
		Logger.logMsg(Logger.INFO, "new ControleurAccueil()");
	}
	
	public void actionNaviguerJournee() 
	{
		Logger.logMsg(Logger.INFO, "ControleurAccueil.actionNaviguerJournee()");
		Navigateur.getInstance().afficherVue(VueJournee.getInstance());
	}
	
	public void actionNaviguerMois() 
	{
		Logger.logMsg(Logger.INFO, "ControleurAccueil.actionNaviguerMois()");
		Navigateur.getInstance().afficherVue(VueMois.getInstance());
	}
	
	public void actionNaviguerAnnee() 
	{
		Logger.logMsg(Logger.INFO, "ControleurAccueil.actionNaviguerAnnee()");
		Navigateur.getInstance().afficherVue(VueAnnee.getInstance());
	}

}
