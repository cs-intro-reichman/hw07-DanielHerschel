/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) { sierpinski(Integer.parseInt(args[0])); }
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		StdDraw.setCanvasSize(800, 800);
		StdDraw.setScale(-1.0, 1.0);

		sierpinski(n, 0.0, 1.0, -1.0, -1.0, 1.0, -1.0);
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
								 double y1, double y2, double y3) {
		// break condition
		if (n == 0) {
			StdDraw.line(x1, x2, x3, y1);
			StdDraw.line(x3, y1, y2, y3);
			StdDraw.line(y2, y3, x1, x2);
			return;
		}

		// midpoints of each side
		double x12 = (x1 + x3) / 2.0;
		double y12 = (x2 + y1) / 2.0;
		double x23 = (x3 + y2) / 2.0;
		double y23 = (y1 + y3) / 2.0;
		double x31 = (y2 + x1) / 2.0;
		double y31 = (y3 + x2) / 2.0;

		// recursion calls
		sierpinski(n - 1, x1, x2, x12, y12, x31, y31);
		sierpinski(n - 1, x12, y12, x3, y1, x23, y23);
		sierpinski(n - 1, x31, y31, x23, y23, y2, y3);
	}
}
