package serviceconsumer;

import serviceproducer.ILoginService;

/**
 * LoginSystem class that interacts with ILoginService for user authentication
 * This class uses the ILoginService interface to handle login requests from users.
 */

public class LoginSystem {
	
	//An instance of ILoginService to perform the login operation
	private ILoginService loginService;
	
	/**
	 * Constructor that initializes the LoginSyatem with the provided ILoginService
	 * @param loginService the ILoginService implementation to be used for authentication.
	 */
	public LoginSystem(ILoginService loginService) {
		this.loginService = loginService;
	}
	
	public boolean login(String username, String password) {
		//Call the login method from the provided ILoginService to authenticate the user
		return loginService.login(username, password);
		
	}
	
}
