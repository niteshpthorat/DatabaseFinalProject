package pojo;

import java.sql.Date;

public class Album {
    private int albumId;
    private String title;
	public Album() {
		super();
	}
	private Date dateCopyRight;
    private String format;
    private String musSSN;
	/**
	 * @return the albumId
	 */
	public int getAlbumId() {
		return albumId;
	}
	/**
	 * @param albumId the albumId to set
	 */
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the dateCopyRight
	 */
	public Date getDateCopyRight() {
		return dateCopyRight;
	}
	/**
	 * @param dateCopyRight the dateCopyRight to set
	 */
	public void setDateCopyRight(Date dateCopyRight) {
		this.dateCopyRight = dateCopyRight;
	}
	/**
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}
	/**
	 * @param format the format to set
	 */
	public void setFormat(String format) {
		this.format = format;
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

}
