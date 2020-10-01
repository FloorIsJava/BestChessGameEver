package com.floorisjava.chess;

import java.util.ArrayList;
import java.util.List;

public class ChessGame {
	
	private List<List<ChessPiece>> grid = new ArrayList<List<ChessPiece>>();

	public ChessGame() {
		// Create grid
		for (int i = 1; i <= 8; i++) {
			List<ChessPiece> row = new ArrayList<ChessPiece>();
			grid.add(row);
			for (int j = 1; j <= 8; j++) { 
				row.add(null);
			}
		}		
		
		// Create pieces and add to grid		
		grid.get(0).set(0, new ChessPiece(PieceType.Rook, PieceColor.White));
		grid.get(0).set(1, new ChessPiece(PieceType.Knight, PieceColor.White));
		grid.get(0).set(2, new ChessPiece(PieceType.Bishop, PieceColor.White));
		grid.get(0).set(3, new ChessPiece(PieceType.Queen, PieceColor.White));
		grid.get(0).set(4, new ChessPiece(PieceType.King, PieceColor.White));
		grid.get(0).set(5, new ChessPiece(PieceType.Bishop, PieceColor.White));
		grid.get(0).set(6, new ChessPiece(PieceType.Knight, PieceColor.White));
		grid.get(0).set(7, new ChessPiece(PieceType.Rook, PieceColor.White));
		
		grid.get(1).set(0, new ChessPiece(PieceType.Pawn, PieceColor.White));
		grid.get(1).set(1, new ChessPiece(PieceType.Pawn, PieceColor.White));
		grid.get(1).set(2, new ChessPiece(PieceType.Pawn, PieceColor.White));
		grid.get(1).set(3, new ChessPiece(PieceType.Pawn, PieceColor.White));
		grid.get(1).set(4, new ChessPiece(PieceType.Pawn, PieceColor.White));
		grid.get(1).set(5, new ChessPiece(PieceType.Pawn, PieceColor.White));
		grid.get(1).set(6, new ChessPiece(PieceType.Pawn, PieceColor.White));
		grid.get(1).set(7, new ChessPiece(PieceType.Pawn, PieceColor.White));
		
		
		
		grid.get(6).set(0, new ChessPiece(PieceType.Pawn, PieceColor.Black));
		grid.get(6).set(1, new ChessPiece(PieceType.Pawn, PieceColor.Black));
		grid.get(6).set(2, new ChessPiece(PieceType.Pawn, PieceColor.Black));
		grid.get(6).set(3, new ChessPiece(PieceType.Pawn, PieceColor.Black));
		grid.get(6).set(4, new ChessPiece(PieceType.Pawn, PieceColor.Black));
		grid.get(6).set(5, new ChessPiece(PieceType.Pawn, PieceColor.Black));
		grid.get(6).set(6, new ChessPiece(PieceType.Pawn, PieceColor.Black));
		grid.get(6).set(7, new ChessPiece(PieceType.Pawn, PieceColor.Black));
		
		grid.get(7).set(0, new ChessPiece(PieceType.Rook, PieceColor.Black));
		grid.get(7).set(1, new ChessPiece(PieceType.Knight, PieceColor.Black));
		grid.get(7).set(2, new ChessPiece(PieceType.Bishop, PieceColor.Black));
		grid.get(7).set(3, new ChessPiece(PieceType.Queen, PieceColor.Black));
		grid.get(7).set(4, new ChessPiece(PieceType.King, PieceColor.Black));
		grid.get(7).set(5, new ChessPiece(PieceType.Bishop, PieceColor.Black));
		grid.get(7).set(6, new ChessPiece(PieceType.Knight, PieceColor.Black));
		grid.get(7).set(7, new ChessPiece(PieceType.Rook, PieceColor.Black));
		
//		grid.add();
//		grid.add(new ChessPiece(PieceType.Knight, PieceColor.White));
//		grid.add(new ChessPiece(PieceType.Bishop, PieceColor.White));
//		grid.add(new ChessPiece(PieceType.Bishop, PieceColor.White));
	}

	public List<List<ChessPiece>> getGrid() {
		return grid;
	}

}
