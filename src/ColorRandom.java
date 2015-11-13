import java.awt.Color;
import java.util.Random;


public class ColorRandom {// Random color generator from four colors in defined in array
	Random rand;
	Color[] colors = new Color[] { Color.BLUE, Color.GREEN, Color.RED,
			Color.YELLOW };
	

	public Color getRandColor() {
		rand = new Random();
		//Random rand = new Random();
		int randomNum = rand.nextInt(4);
		return colors[randomNum];

	}


}