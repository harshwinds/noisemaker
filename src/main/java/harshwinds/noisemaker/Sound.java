package harshwinds.noisemaker;

/**
 * Immuatable bean representing a sound.
 * 
 * @author harshwinds
 */
public class Sound {
	private final int interval;
	private final String name;
	
	public Sound(int interval, String name) {
		this.interval = interval;
		this.name = name;
	}

	public int getInterval() {
		return interval;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Sound)) {
			return false;
		}
		
		Sound that = (Sound) o;
		
		return this.interval == that.interval &&
				this.name != null && this.name.equals(that.name);
	}
	
	@Override
	public int hashCode() {
		return (interval * 42) +
				(this.name == null ? 0 : this.name.hashCode());
	}
	
	@Override
	public String toString() {
		return name;
	}
}
