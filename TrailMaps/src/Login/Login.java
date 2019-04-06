package Login;

import javafx.stage.Stage;

/**
 * Class login with all functionality associated to the logi
 * @author J.Bermudez
 *
 */
public class Login {

	/**
	 * Crontoller Login
	 */
	private  Contoller controller;
	
	public Login(Stage stage) {
		
		controller = new Contoller(stage);
	}
	
	public void initView() {
		controller.initView();
	}
	
	
}
