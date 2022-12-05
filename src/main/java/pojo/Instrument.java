package pojo;

public class Instrument {
    private int idInstrument; 
    private String name;
    private String keys;
	/**
	 * @return the idInstrument
	 */
	public int getIdInstrument() {
		return idInstrument;
	}
	/**
	 * @param idInstrument the idInstrument to set
	 */
	public void setIdInstrument(int idInstrument) {
		this.idInstrument = idInstrument;
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
	 * @return the keys
	 */
	public String getKeys() {
		return keys;
	}
	/**
	 * @param keys the keys to set
	 */
	public void setKeys(String keys) {
		this.keys = keys;
	}
	public Instrument() {
		super();
	}

}
