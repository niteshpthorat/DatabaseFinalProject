package pojo;

public class Performance {
    private int idPerformance;
    private int idSong;  
    private String musSSN;
	/**
	 * @return the idPerformance
	 */
	public int getIdPerformance() {
		return idPerformance;
	}
	/**
	 * @param idPerformance the idPerformance to set
	 */
	public void setIdPerformance(int idPerformance) {
		this.idPerformance = idPerformance;
	}
	/**
	 * @return the idSong
	 */
	public int getIdSong() {
		return idSong;
	}
	/**
	 * @param idSong the idSong to set
	 */
	public void setIdSong(int idSong) {
		this.idSong = idSong;
	}
	/**
	 * @return the musSSN
	 */
	public String getMusSSN() {
		return musSSN;
	}
	/**
	 * @param musSSN the musSSN to set
	 */
	public void setMusSSN(String musSSN) {
		this.musSSN = musSSN;
	}
	public Performance() {
		super();
	}  


}
