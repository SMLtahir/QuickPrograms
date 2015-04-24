package objectOrientedPrograms;

import java.util.ArrayList;
import java.util.List;

/**
 * Design a chess game.
 * @author Tahir
 * Add getter and setter methods to private fields instead of having public fields in classes
 */
public class ChessGame {

    public Board board = new Board();
    public Player white;
    public Player black;
    
    // Constructor
    public ChessGame() {
        super();
    }
    
    public boolean initializeBoard() {
    
        if(this.black == null || this.white == null) { return false;}
        this.board = new Board();
        for(int i=0; i<black.pieces.size(); i++){
            board.getSpot(black.pieces.get(i).x, black.pieces.get(i).y).occupySpot(black.pieces.get(i));
        }
        for(int i=0; i<white.pieces.size(); i++){
            board.getSpot(white.pieces.get(i).x, white.pieces.get(i).y).occupySpot(white.pieces.get(i));
        }
        return true;
    }
}

class Player {
	public final int PAWNS = 8;
	public final int ROOKS = 2;
	public final int BISHOPS = 2;
	public final int KNIGHTS = 2;
	public final int KINGS = 1;
	public final int QUEENS = 1;
	
	public boolean isWhite;
	
	public List<Piece> pieces = new ArrayList<Piece>();
	public Player(boolean isWhite) {
		super();
		this.isWhite = isWhite;
	}
	
	public void initializePieces() {
		// Initialize white
		if(this.isWhite == true) {
			for(int i=0; i< PAWNS; i++) {
				pieces.add(new Pawn(true, i, 1));
			}
			pieces.add(new Rook(true, 0, 0));
            pieces.add(new Rook(true, 7, 0));
            pieces.add(new Bishop(true, 2, 0));
            pieces.add(new Bishop(true, 5, 0));
            pieces.add(new Knight(true, 1, 0));
            pieces.add(new Knight(true, 6, 0));
            pieces.add(new Queen(true, 3, 0));
            pieces.add(new King(true, 4, 0));
		}
		// Initialize black
		else {
			for(int i=0; i<PAWNS; i++){ // draw pawns
                pieces.add(new Pawn(true,i,6));
            }
            pieces.add(new Rook(true, 0, 7));
            pieces.add(new Rook(true, 7, 7));
            pieces.add(new Bishop(true, 2, 7));
            pieces.add(new Bishop(true, 5, 7));
            pieces.add(new Knight(true, 1, 7));
            pieces.add(new Knight(true, 6, 7));
            pieces.add(new Queen(true, 3, 7));
            pieces.add(new King(true, 4, 7));
		}
		
	}
}

class Board {
	private Spot[][] spots = new Spot[8][8];
	
	public Board() {
		super();
		for(int x =0; x< spots.length; x++) {
			for(int y =0; y< spots.length; y++) {
				this.spots[x][y] = new Spot(x, y);
			}
		}
	}
	
	public Spot getSpot(int x, int y) {
		return spots[x][y];
	}
}

class Spot {
	public int x;
	public int y;
	Piece piece;
	
	public Spot(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.piece = null;
	}
	
	public void occupySpot(Piece piece) {
		if(this.piece != null)	{ this.piece.isAlive = false;}	// Kill piece
		// If no piece is occupying
		this.piece = piece;
	}
	
	public boolean isOccupied() {
		if(this.piece != null)
			return true;
		else
			return false;
	}
	
	public Piece releaseSpot() {
		Piece releasedPiece = this.piece;
		this.piece = null;
		return releasedPiece;
	}
}

class Piece {
	public boolean isAlive;
	public int x;
	public int y;
	
	public Piece(boolean isAlive, int x, int y) {
		this.isAlive = isAlive;
		this.x = x;
		this.y = y;
	}
	
	public boolean isValid(Board board, int fromX, int fromY, int toX, int toY){
        if(toX == fromX && toY == fromY)
            return false; //cannot move nothing
        if(toX < 0 || toX > 7 || fromX < 0 || fromX > 7 || toY < 0 || toY > 7 || fromY <0 || fromY > 7)
            return false;
        return true;
    }
}

class King extends Piece{

    public King(boolean isAlive, int x, int y) {
        super(isAlive, x, y);
    }

    @Override
    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
        if(super.isValid(board, fromX, fromY, toX, toY) == false)
            return false;
        if(Math.sqrt(Math.pow(Math.abs((toX - fromX)),2)) + Math.pow(Math.abs((toY - fromY)), 2) != Math.sqrt(2)){
            return false;
        }
        return false;
    }
}

class Queen extends Piece{

    public Queen(boolean isAlive, int x, int y) {
        super(isAlive, x, y);
    }

    @Override
    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
        if(super.isValid(board, fromX, fromY, toX, toY) == false)
            return false;
        //diagonal
        if(toX - fromX == toY - fromY)
            return true;
        if(toX == fromX)
            return true;
        if(toY == fromY)
            return true;

        return false;
    }
}

class Rook extends Piece{

    public Rook(boolean available, int x, int y) {
        super(available, x, y);
        // TODO Auto-generated constructor stub
    }


    @Override
    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
        if(super.isValid(board, fromX, fromY, toX, toY) == false)
            return false;
        if(toX == fromX)
            return true;
        if(toY == fromY)
            return true;
        return false;
    }
}

class Bishop extends Piece{

    public Bishop(boolean available, int x, int y) {
        super(available, x, y);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
        if(super.isValid(board, fromX, fromY, toX, toY) == false)
            return false;

        if(toX - fromX == toY - fromY)
            return true;

        return false;
    }

}

class Knight extends Piece{

    public Knight(boolean available, int x, int y) {
        super(available, x, y);
    }

    @Override
    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
        if(super.isValid(board, fromX, fromY, toX, toY) == false)
            return false;

        if(toX != fromX - 1 && toX != fromX + 1 && toX != fromX + 2 && toX != fromX - 2)
            return false;
        if(toY != fromY - 2 && toY != fromY + 2 && toY != fromY - 1 && toY != fromY + 1)
            return false;

        return true;
    }

}

class Pawn extends Piece{

    public Pawn(boolean available, int x, int y) {
        super(available, x, y);
    }

    @Override
    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
        if(super.isValid(board, fromX, fromY, toX, toY) == false)
            return false;

        if(Math.abs(toX - fromX) > 1 || Math.abs(toY - fromY) > 1)
            return false;

        return true;
    }

}