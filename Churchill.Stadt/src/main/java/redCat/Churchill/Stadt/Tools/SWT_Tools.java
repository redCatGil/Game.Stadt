package redCat.Churchill.Stadt.Tools;

import java.util.HashMap;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class SWT_Tools {

	public SWT_Tools() {
		// TODO Auto-generated constructor stub
	}
	
	/**
     * Maps RGB values to colors
     */
    private static HashMap<RGB, Color> m_ColorMap = new HashMap<RGB, Color>();

	
	 /**
     * Returns the system color matching the specific ID
     * @param systemColorID int The ID value for the color
     * @return Color The system color matching the specific ID
     */
    public static Color getColor(int systemColorID) {
        Display display = Display.getCurrent();
        return display.getSystemColor(systemColorID);
    }
    
    /**
     * Returns a color given its RGB value
     * @param rgb RGB The RGB value of the color
     * @return Color The color matching the RGB value
     */
    public static Color getColor(RGB rgb) {
        Color color = m_ColorMap.get(rgb);
        if (color == null) {
            Display display = Display.getCurrent();
            color = new Color(display, rgb);
            m_ColorMap.put(rgb, color);
        }
        return color;
    }
	
	 /**
     * Returns a color given its red, green and blue component values
     * @param r int The red component of the color
     * @param g int The green component of the color
     * @param b int The blue component of the color
     * @return Color The color matching the given red, green and blue componet values
     */
    public static Color getColor(int r, int g, int b) {
        return getColor(new RGB(r, g, b));
    }

}
