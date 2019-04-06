package Login;

import Util.BooleanReason;

/**
 * Class Module Login
 * @author J.Bermudez
 *
 */
public class Module {

	/**
	 * Controller Login
	 */
	private Contoller controller;
	
	public Module(Contoller controller) {
		this.controller = controller;
	}
	
	/**
	 * Check the user and password to log in
	 * @param user User 
	 * @param password Password
	 * @return The result and explication
	 */
	public BooleanReason checkLogin(String user, String password) {
		BooleanReason bResult = new BooleanReason();
		
		if(user != null && password != null) {
			
			if(user.equals("userjavi") && password.equals("passjavi")) {
				bResult.setbReason(true);
				bResult.settReason("Log in success");
			} else {
				bResult.setbReason(false);
				bResult.settReason("Log in not success");
			}
		} else {
			bResult.setbReason(false);
			bResult.settReason("User or password null");
		}
		
		return bResult;
	}
}
