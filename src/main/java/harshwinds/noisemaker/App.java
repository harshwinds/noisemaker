package harshwinds.noisemaker;

import java.util.Arrays;
import java.util.List;

public class App {
	/**
	 * Create a for loop that iterates up to 100 while outputting:
	 * - "fizz" at multiples of 3, 
	 * - "buzz" at multiples of 5 and 
	 * - "fizzbuzz" at multiples of 3 and 5
	 */
    public static void main(String[] args) {
        List<Sound> sounds = Arrays.asList(new Sound(3, "fizz"), new Sound(5, "buzz"));
        
    	class PrintingPlayer implements Player {
    		@Override
    		public void play(int index, List<Sound> sounds) {
    			StringBuilder sb = new StringBuilder();
    			
    			for (Sound sound : sounds) {
    				sb.append(sound);
    			}
    			
				System.out.println(sb);
    		}
    	}
        
        NoiseMaker noiseMaker = new NoiseMaker(sounds);
        noiseMaker.makeNoise(new PrintingPlayer());
    }
}
