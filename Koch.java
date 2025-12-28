/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /*
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
         */

//		curve(Integer.parseInt(args[0]),
//			  Double.parseDouble(args[1]), Double.parseDouble(args[2]),
//		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));


		/*
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		 */
		snowFlake(Integer.parseInt(args[0]));
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0) {
			StdDraw.line(x1, y1, x2, y2);
			return;
		}
		// compute the points at 1/3 and 2/3 along the segment
		double xA = x1 + (x2 - x1) / 3.0;
		double yA = y1 + (y2 - y1) / 3.0;

		double xB = x1 + 2.0 * (x2 - x1) / 3.0;
		double yB = y1 + 2.0 * (y2 - y1) / 3.0;

		// find the point at the peak of the curve
		double xPeak = (x1 + x2) / 2.0 - (Math.sqrt(3) * (y2 - y1)) / 6.0;
		double yPeak = (y1 + y2) / 2.0 + (Math.sqrt(3) * (x2 - x1)) / 6.0;

		// recursive subdivision calls
		curve(n - 1, x1, y1, xA, yA);
		curve(n - 1, xA, yA, xPeak, yPeak);
		curve(n - 1, xPeak, yPeak, xB, yB);
		curve(n - 1, xB, yB, x2, y2);
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);

		// Draws a Koch snowflake of depth n
		curve(n, 0.1, 0.8, 1.0, 0.8);
		curve(n,1.0, 0.8, 0.55, 0.1);
		curve(n,0.55, 0.1, 0.1, 0.8);
	}
}
