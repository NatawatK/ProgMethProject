package exception;

public class ShootException extends Exception{
	public String getErrorMessage() {
		return "Can't shoot now!!!";
	}
}
