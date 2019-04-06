package Login;

import Util.BooleanReason;
import javafx.stage.Stage;

/**
 * Class Controller Login
 * @author J.Bermudez
 *
 */
public class Contoller {

	/**
	 * Module
	 */
	private Module module;
	/**
	 * View Login
	 */
	private View view;
	
	public Contoller(Stage stage) {
		view = new View(stage, this);
		module = new Module(this);
	}
	
	/**
	 * Init View
	 */
	public void initView() {
		view.init();
	}
	
	
	/**
	 * Close the view
	 */
	public void stop() {
		view.stop();
	}
	
	/**
	 * Check the user and password to log in
	 * @param user User 
	 * @param password Password
	 * @return The result and explication
	 */
	public BooleanReason checkLogin(String user, String password) {
		BooleanReason bResult = new BooleanReason();
		
		bResult = module.checkLogin(user, password);
		
		return bResult;
	}
}
