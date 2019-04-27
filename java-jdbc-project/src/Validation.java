public class Validation {

	// Calling this method will give back a true / false identifying whether the
	// String input was convertible to an integer
	
	public boolean checkNum(String str) {

		try {
			long num = Long.parseLong(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
