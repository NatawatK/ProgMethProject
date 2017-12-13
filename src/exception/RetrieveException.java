package exception;

public class RetrieveException extends Exception{
	public String getErrorMessage() {
		return "Can't retrieve when not shooted.";
	}
}
