package objectOrientedPrograms;

import java.util.ArrayList;
import java.util.List;

public class JigsawPuzzle {
	List<Tile> tiles;
	List<Edge> exposedEdges;
	List<Edge> inners, outers, flats;
	
	public JigsawPuzzle(List<Tile> tiles) {
		this.tiles = tiles;
		exposedEdges = new ArrayList<Edge>();
		inners = new ArrayList<Edge>();
		outers = new ArrayList<Edge>();
		flats = new ArrayList<Edge>();
	}
	
	public void join(Edge e1, Edge e2) {
		// Join both edges
	}
	
	public void sort() {
		for(Tile tile : tiles) {
			Edge[] edges = {tile.top, tile.bottom, tile.left, tile.right};
			for(Edge e : edges) {
				if(e.edgeType == EdgeType.Inner) { inners.add(e); exposedEdges.add(e);}
				else if(e.edgeType == EdgeType.Inner) { outers.add(e); exposedEdges.add(e);}
				else { flats.add(e);}
			}
		}
	}
	
	public boolean solve() {
		// Assumption: Each edge fits only with one other edge
		for(Edge e1 : exposedEdges) {
			if(e1.edgeType == EdgeType.Inner) {
				for(Edge e2 : outers) {
					if(e1.fitsWith(e2)) { 
						join(e1, e2);
						exposedEdges.remove(e1);
						inners.remove(e1);
						exposedEdges.remove(e2);
						outers.remove(e2);
					}
				}
			} else if(e1.edgeType == EdgeType.Outer) {
				for(Edge e2 : inners) {
					if(e1.fitsWith(e2)) { 
						join(e1, e2);
						exposedEdges.remove(e1);
						outers.remove(e1);
						exposedEdges.remove(e2);
						inners.remove(e2);
					}
				}
			}
			// No possible matches
			if( inners.size() == 0 ^ outers.size() == 0 ) { return false;}
		}
		return true;
	}
}

class Tile {
	Edge top, bottom, left, right;
	Orientation orient;
	
	public Tile(Edge top, Edge bottom, Edge left, Edge right) {
		this.top = top;
		this.bottom = bottom;
		this.left = left;
		this.right = right;
		this.orient = Orientation.Deg0;
	}
	
	enum Orientation {
		Deg0, Deg90, Deg180, Deg270;
	}
}

class Edge {
	
	EdgeType edgeType;
	Tile parent;
	
	public Edge(EdgeType type, Tile parentTile) {
		this.edgeType = type;
		this.parent = parentTile;
	}
	
	public boolean fitsWith(Edge edge) {
		boolean isFit = false;
		// Check whether the two edges fit together and return true or false accordingly
		return isFit;
	}
}

enum EdgeType {
	Inner, Outer, Flat;
}