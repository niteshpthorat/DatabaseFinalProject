package pojo;

public class Musician {
    private int musicianId;  
    private String ssn;  
    private String name;
    private String phoneNo;
    
    public Musician() {
		super();
	}
    
	/**
	 * @return the musicianId
	 */
	public int getMusicianId() {
		return musicianId;
	}
	/**
	 * @param musicianId the musicianId to set
	 */
	public void setMusicianId(int musicianId) {
		this.musicianId = musicianId;
	}
	/**
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}
	/**
	 * @param ssn the ssn to set
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}
	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	} 


}
