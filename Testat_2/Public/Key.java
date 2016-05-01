package Public;
/**
 * @author Jens Windisch (1526760)
 * @author Markus Cöllen()
 */
public class Key<T extends String> {
	
	private T key;
	/**
	 * Erstellt einen Key
	 * @param key
	 */
	public Key(T key){
		key = (T) key.toUpperCase();
		this.key=key;
	}
	/**
	 * Gibt erstellten Key zurück
	 * @return
	 */
	public T getKey() {
		return key;
	}
	
}
