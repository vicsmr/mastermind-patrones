package mastermind.views;

import mastermind.types.Color;

public class ColorView {
	
	public static final char[] INITIALS = {'r', 'b', 'y', 'g', 'o', 'p'};

	private Color color;

	protected ColorView(Color color) {
		this.color = color;
	}

	protected static String allInitials() {
		String result = "";
		for(char character: ColorView.INITIALS) {
			result += character;
		}
		return result;
	}
	
	protected char getInitial() {
		return ColorView.INITIALS[this.color.ordinal()];
	}

	protected static Color getInstance(char character) {
		for (int i = 0; i < ColorView.INITIALS.length; i++) {
			if (ColorView.INITIALS[i] == character) {
				return Color.values()[i];
			}
		}
		return null;
	}

}
