/*************************************************************************
 *  Compilation:  javac Sierpinski.java
 *  Execution:    java Sierpinski
 *
 *  @author: Sam Friedman, smf252, smf252@scarletmail.rutgers.edu
 *
 *************************************************************************/

public class Sierpinski {

    // Height of an equilateral triangle whose sides are of the specified length. 
    public static double height(double length) {
        double height = Math.sqrt(Math.pow(length, 2) - Math.pow((length/2), 2));
        if (length < 0) height = -height;
        return height;
    }

    // Draws a filled equilateral triangle whose bottom vertex is (x, y) 
    // of the specified side length. 
    public static void filledTriangle(double x, double y, double length) {
        double deltaY = height(length);
        double halfLen = length / 2;
        double[] a = {x, (x - halfLen), (x + halfLen)};
        double[] b = {y, y + deltaY, y + deltaY};
        StdDraw.filledPolygon(a,b);
    }

    // Draws a Sierpinski triangle of order n, such that the largest filled 
    // triangle has bottom vertex (x, y) and sides of the specified length. 
    public static void sierpinski(int n, double x, double y, double length) {
        if (n == 0) return;
        filledTriangle(x, y, length);
        double newY = height(length);
        double halfLen = length / 2;

        sierpinski(n-1, x, y+newY, halfLen);
        sierpinski(n-1, x-(halfLen), y, halfLen);
        sierpinski(n-1, x+(halfLen), y, halfLen);
    }

    // Takes an integer command-line argument n; 
    // draws the outline of an equilateral triangle (pointed upwards) of length 1; 
    // whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and 
    // draws a Sierpinski triangle of order n that fits snugly inside the outline. 
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        double[] x = {0, 1, 0.5};
        double[] y = {0, 0, Math.sqrt(3)/2};
        StdDraw.polygon(x,y);

        sierpinski(n, 0.5, 0, 0.5);
    }
}
