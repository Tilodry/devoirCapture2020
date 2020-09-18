package vue;

import javafx.stage.Stage;
//import javafx.stage.StageStyle;

public class Fenetre extends Navigateur {

	@Override
	public void start(Stage stade) throws Exception {
		//stade.initStyle(StageStyle.UNDECORATED);
		stade.setScene(VueAccueil.getInstance());
		stade.show();
		this.stade = stade;
	}

}
