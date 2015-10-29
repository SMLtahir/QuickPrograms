package graphs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Boggle {
	
	public Set<String> set = new HashSet<String>();
	public Set<String> solveBoggle(char[][] board, TrieNode root) {
		for(int i=0; i< board.length; i++) {
			for(int j=0; j< board[0].length; j++) {
				StringBuilder sb = new StringBuilder();
				boolean[][] exploredCells = new boolean[board.length][board[0].length];
				checkBoard(board, i, j, root, sb, exploredCells);
			}
		}
		return set;
	}
	
	public void checkBoard(char[][] board, int i , int j, TrieNode root, StringBuilder sb, boolean[][] explored) {
		if(!isValid(board, i, j) || explored[i][j]) { return;}
		sb.append(board[i][j]);
		explored[i][j] = true; 
		if(root.children.size() == 0) { 
			set.add(sb.toString());
			return;
		} 
		TrieNode child = root.getChild(board[i][j]);
		if(child != null) {
			// Search next character
			checkBoard(board, i+1, j, child, sb, explored);
			checkBoard(board, i+1, j+1, child, sb, explored);
			checkBoard(board, i+1, j-1, child, sb, explored);
			checkBoard(board, i, j+1, child, sb, explored);
			checkBoard(board, i, j-1, child, sb, explored);
			checkBoard(board, i-1, j-1, child, sb, explored);
			checkBoard(board, i-1, j+1, child, sb, explored);
			checkBoard(board, i-1, j, child, sb, explored);
		}
	}
	
	public boolean isValid(char[][] board, int i, int j) {
		return (i>=0 && i< board.length && j>= 0 && j< board[0].length);
	}
	
	class TrieNode {
		List<TrieNode> children;
		char val;
		
		public TrieNode(char val, List<TrieNode> children) {
			this.val = val;
			this.children = children;
		}
		
		public TrieNode getChild(char c) {
			for(TrieNode child : children) {
				if(child.val == c) { return child;}
			}
			return null;
		}
	}
}
