package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import trees.EqualTrees;

/**
 * Imagine a touch surface mapped to a matrix of pixels. 0 = no touch, 1 = touch
 * Design a way to transmit the touched pixels using minimum space.
 * 
 * I have designed this keeping in mind that touches on a surface are basically going to come in connected clusters.
 * The space will be minimum if only the boundaries of each touched area are represented by the cluster.
 * This assumes that every pixel inside these boundaries are also 'touched'.
 * @author Tahir
 *
 */
public class TouchSparseMatrixTransmission {

	private static final int[][] touchedSurface = {{0,0,0,0,1},
													{0,0,1,1,1},
													{0,0,0,0,0},
													{0,1,1,0,0},
													{0,1,1,0,0}};
	public static void main(String[] args) {

		List<Cluster> clusters = getTouchedPixels(touchedSurface);
		System.out.println();

	}
	
	public static List<Cluster> getTouchedPixels(int[][] pixels) {
		Set<Pixel> explored = new HashSet<Pixel>();
		List<Cluster> clusters = new ArrayList<Cluster>();
		
		for(int i=0;i<pixels.length;i++) {
			for(int j=0;j<pixels[0].length;j++) {
				Pixel p = new Pixel(i, j);
				if(!explored.contains(p) && pixels[i][j] == 1) {
					Cluster c = new Cluster(p);
					exploreCluster(pixels, p, explored, c);
					clusters.add(c);
				}
			}
		}
		return clusters;
	}
	
	public static void exploreCluster(int[][] pixels, Pixel p, Set<Pixel> explored, Cluster c) {
		if(p.x < 0 || p.y < 0 || p.x >= pixels.length || p.y >= pixels[0].length || explored.contains(p)) { return;}
		if(pixels[p.x][p.y] == 0) { return;}
		explored.add(p);
		c.addPixel(p);
		// Explore in all directions
		exploreCluster(pixels, new Pixel(p.x, p.y+1), explored, c);
		exploreCluster(pixels, new Pixel(p.x, p.y-1), explored, c);
		exploreCluster(pixels, new Pixel(p.x+1, p.y), explored, c);
		exploreCluster(pixels, new Pixel(p.x-1, p.y), explored, c);
		exploreCluster(pixels, new Pixel(p.x+1, p.y+1), explored, c);
		exploreCluster(pixels, new Pixel(p.x+1, p.y-1), explored, c);
		exploreCluster(pixels, new Pixel(p.x-1, p.y+1), explored, c);
		exploreCluster(pixels, new Pixel(p.x-1, p.y-1), explored, c);
	}
}

class Pixel {
	int x;
	int y;
	
	public Pixel(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == this) { return true;}
		if(! (o instanceof Pixel)) { return false;}
		Pixel p = (Pixel) o;
		return (this.x == p.x && this.y == p.y);
	}
	
	// This method is needed for the .contains()/ .containsKey() method of HashMap or HashSet
	@Override
	public int hashCode() {
		String str = "x:"+this.x+",y:"+this.y;
		return str.hashCode();
	}
}

class Cluster {
	Map<Integer, MinMaxCol> map;
	
	Cluster(Pixel p) {
		map = new HashMap<Integer, MinMaxCol>();
		map.put(p.x, new MinMaxCol(p.y, p.y));
	}
	
	public void addPixel(Pixel p) {
		if(!map.containsKey(p.x)) {
			map.put(p.x, new MinMaxCol(p.y, p.y));
		} else {
			MinMaxCol mmCol = map.get(p.x);
			int minCol = p.y < mmCol.min ? p.y : mmCol.min; 
			int maxCol = p.y > mmCol.max ? p.y : mmCol.max;
			map.put(p.x, new MinMaxCol(minCol, maxCol));
		}
	}
}

class MinMaxCol {
	int min;
	int max;
	
	public MinMaxCol(int min, int max) {
		this.min = min;
		this.max = max;
	}
}