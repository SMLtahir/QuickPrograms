package mathematical;

/**
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

____________(C,D)
|			|
|		____|______(G,H)
|		|	|		|
|_______|___|		|
(A,B)	|___________|
	  (E,F)
Assume that the total area is never beyond the maximum possible value of int.
 * @author Tahir
 *
 */
public class RectangleArea {

	public static void main(String[] args) {

		System.out.println("Area: "+ computeArea(-3,0,3,4,0,-1,9,2));

	}
	
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = getRectArea(A, B, C, D);
        int area2 = getRectArea(E, F, G, H);
        int totalArea = area1 + area2;
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);
        if(right > left && top > bottom) {
            totalArea = totalArea - (right-left)*(top-bottom);
        }
        return totalArea;
    }
    
    public static int getRectArea(int x1, int y1, int x2, int y2) {
        return (y2 - y1)*(x2 - x1);
    }
}
