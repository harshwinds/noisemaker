package harshwinds.noisemaker;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import harshwinds.noisemaker.NoiseMaker;
import harshwinds.noisemaker.Player;
import harshwinds.noisemaker.Sound;

public class NoiseMakerTest {
	
    abstract class CountingPlayer implements Player {
    	List<Integer> fizzInstances = new ArrayList<Integer>();
    	List<Integer> buzzInstances = new ArrayList<Integer>();
    	List<Integer> fizzBuzzInstances = new ArrayList<Integer>();
    	List<Integer> otherInstances = new ArrayList<Integer>();
    	
		public List<Integer> getFizzInstances() {
			return fizzInstances;
		}
		public List<Integer> getBuzzInstances() {
			return buzzInstances;
		}
		public List<Integer> getFizzBuzzInstances() {
			return fizzBuzzInstances;
		}
		public List<Integer> getOtherInstances() {
			return otherInstances;
		}
    };
	
	/**
	 * - "fizz" at multiples of 3, 
	 * - "buzz" at multiples of 5 and 
	 * - "fizzbuzz" at multiples of 3 and 5
	 */
	@Test
	public void test() {
		int fizzInterval = 3;
		Sound fizz = new Sound(fizzInterval, "fizz");
		
		int buzzInterval = 5;
		Sound buzz = new Sound(buzzInterval, "buzz");
		
        List<Sound> sounds = Arrays.asList(fizz, buzz);
        
        CountingPlayer countingPlayer = new CountingPlayer() {
    		@Override
    		public void play(int index, List<Sound> soundsToPlay) {
    			if (soundsToPlay.containsAll(sounds)) {
    				fizzBuzzInstances.add(index);
    			} else if (soundsToPlay.size() == 1 && soundsToPlay.contains(fizz)) {
    				fizzInstances.add(index);
    			} else if (soundsToPlay.size() == 1 && soundsToPlay.contains(buzz)) {
    				buzzInstances.add(index);
    			} else {
    				otherInstances.add(index);
    			}
    		}
        };
        
        NoiseMaker noiseMaker = new NoiseMaker(sounds);
        noiseMaker.makeNoise(countingPlayer);
        
		int expectedFizzBuzzSounds = NoiseMaker.ITERATIONS / (fizzInterval * buzzInterval);
		assertEquals(expectedFizzBuzzSounds, countingPlayer.getFizzBuzzInstances().size());
		for (Integer iteration : countingPlayer.getFizzBuzzInstances()) {
			assertTrue(iteration % fizz.getInterval() == 0 && iteration % buzz.getInterval() == 0);
		}
		
		int expectedFizzSounds = NoiseMaker.ITERATIONS / fizzInterval - expectedFizzBuzzSounds;
		assertEquals(expectedFizzSounds, countingPlayer.getFizzInstances().size());
		for (Integer iteration : countingPlayer.getFizzInstances()) {
			assertTrue(iteration % fizz.getInterval() == 0 && iteration % buzz.getInterval() != 0);
		}
		
		int expectedBuzzSounds = NoiseMaker.ITERATIONS / buzzInterval - expectedFizzBuzzSounds;
        assertEquals(expectedBuzzSounds, countingPlayer.getBuzzInstances().size());
		for (Integer iteration : countingPlayer.getBuzzInstances()) {
			assertTrue(iteration % fizz.getInterval() != 0 && iteration % buzz.getInterval() == 0);
		}
        
        assertEquals(0, countingPlayer.getOtherInstances().size());
	}

}
