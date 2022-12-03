package pojo;

public class Song {
    private int idSong; 
    private String title;
    private String author;
    private int idAlbum;
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
	 * 
	 */
	public Song() {
		super();
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
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the idAlbum
	 */
	public int getIdAlbum() {
		return idAlbum;
	}
	/**
	 * @param idAlbum the idAlbum to set
	 */
	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
	} 


}

