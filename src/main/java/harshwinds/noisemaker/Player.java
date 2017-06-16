package harshwinds.noisemaker;

import java.util.List;

/**
 * Represents a player of sounds with an indicator of the index of the
 * order the sounds are being played in relation to other sounds being
 * played
 * 
 * @author harshwinds
 */
@FunctionalInterface
interface Player {
	void play(final int index, List<Sound> sounds);
}
