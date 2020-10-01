package com.floorisjava.chess;

public class ChessPiece {
	
	private PieceColor pieceColor;
	
	private PieceType pieceType;
	
	private String imagePath;

	public PieceType getPieceType() {
		return pieceType;
	}

	public void setPieceType(PieceType pieceType) {
		this.pieceType = pieceType;
	}

	public PieceColor getPieceColor() {
		return pieceColor;
	}

	public void setPieceColor(PieceColor pieceColor) {
		this.pieceColor = pieceColor;
	}
	

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public ChessPiece(PieceType pieceType, PieceColor pieceColor) {
		this.pieceType = pieceType;
		this.pieceColor = pieceColor;

		this.imagePath = "img/" + pieceColor.name().toLowerCase() + "_" + pieceType.name().toLowerCase() + "_big.png";
		
		System.out.println(this.imagePath);
	}

	
}
