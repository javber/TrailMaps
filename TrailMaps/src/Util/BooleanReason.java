package Util;

/**
 * Class of store the Reason with the string and boolean
 * 
 * @author J.Bermudez
 *
 */
public class BooleanReason {

	/**
	 * Boolean Reason
	 */
	private Boolean bReason;
	/**
	 * String Reason
	 */
	private String tReason;

	public BooleanReason() {
		this.bReason = false;
		this.tReason = "";
	}
	
	public BooleanReason(Boolean bReason, String tReason) {
		this.bReason = bReason;
		this.tReason = tReason;
	}
	
	/**
	 * Get bReason
	 * 
	 * @return bReason
	 */
	public Boolean getbReason() {
		return bReason;
	}

	/**
	 * Get bReason
	 * 
	 * @return bReason
	 */
	public void setbReason(Boolean bReason) {
		this.bReason = bReason;
	}

	/**
	 * Get tReason
	 * 
	 * @return tReason
	 */
	public String gettReason() {
		return tReason;
	}

	/**
	 * Get tReason
	 * 
	 * @return tReason
	 */
	public void settReason(String tReason) {
		this.tReason = tReason;
	}
}
