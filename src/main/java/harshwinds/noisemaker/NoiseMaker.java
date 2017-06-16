package harshwinds.noisemaker;

import java.util.Arrays;
import java.util.List;

/**
 * Plays the sounds at the specified intervals using the provided player
 *
 * @author harshwinds
 */
public class NoiseMaker {
	
	static final int ITERATIONS = 100;
	
	private List<Sound> sounds;
	
	public NoiseMaker(List<Sound> sounds) {
		this.sounds = sounds;
	}
	
	public void makeNoise(Player player) {
		for (int i = 1; i <= ITERATIONS; i++) {
			final int count = i;
			Sound[] soundsToPlay = sounds.stream()
				.filter(sound -> count % sound.getInterval() == 0)
				.toArray(Sound[]::new);
			
			if (soundsToPlay.length > 0) {
				player.play(i, Arrays.asList(soundsToPlay));
			}
		}
	}
}
