package exception;

public class MinDegreeExceedException extends Exception{
	public String getError() {
		return "Min degree exceeded! Please aim higher.";
	}
}
