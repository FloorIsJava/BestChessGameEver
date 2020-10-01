package com.floorisjava.chess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class ChessGameWindow {
	
	public static void create(ChessGame game) {
		JFrame frame = new JFrame("Chess Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		JLabel textLabel = new JLabel("Black", SwingConstants.CENTER); 
		textLabel.setPreferredSize(new Dimension(200, 100));
		frame.getContentPane().add(textLabel, BorderLayout.NORTH);
		
		frame.getContentPane().add(createChessGrid(game), BorderLayout.CENTER);
		
		JLabel textLabel2 = new JLabel("White", SwingConstants.CENTER); 
		textLabel2.setPreferredSize(new Dimension(200, 100));
		frame.getContentPane().add(textLabel2, BorderLayout.SOUTH);
		
		JLabel paddingLeftLabel = new JLabel("", SwingConstants.CENTER); 
		paddingLeftLabel.setPreferredSize(new Dimension(100, 200));
		frame.getContentPane().add(paddingLeftLabel, BorderLayout.WEST);
		
		JLabel paddingRightLabel = new JLabel("", SwingConstants.CENTER); 
		paddingRightLabel.setPreferredSize(new Dimension(100, 200));
		frame.getContentPane().add(paddingRightLabel, BorderLayout.EAST);
		
		frame.pack();
		
	    
	    frame.setSize(800, 800);
		
		frame.setLocationRelativeTo(null);
		
		frame.setVisible(true);
	}
	
	private static String getCharForNumber(int i) {
	    return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
	}

	private static JPanel createChessGrid(ChessGame game) {
		GridLayout grid = new GridLayout(8, 8);
		
		JPanel panel = new JPanel();				
		panel.setLayout(grid);
		
		
		boolean isAlternate = false;
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		
		for (int i = 8; i >= 1; i--) {
			for (int j = 1; j <= 8; j++) {
				
				JPanel cell = new JPanel();
				cell.setLayout(new BorderLayout());
				cell.setBorder(blackline);			
				cell.setPreferredSize(new Dimension(100, 100));
				
				// Set background
				cell.setOpaque(true);
				if (isAlternate) {
					cell.setBackground(Color.LIGHT_GRAY);	
				}
				else {
					cell.setBackground(Color.WHITE);
				}
				isAlternate = !isAlternate;				
				
				
				// Add cell reference labels
				JLabel leftLabel = new JLabel("", SwingConstants.CENTER);
				cell.add(leftLabel, BorderLayout.WEST);
				
				JLabel bottomLabel = new JLabel("", SwingConstants.RIGHT);
				cell.add(bottomLabel, BorderLayout.SOUTH);
				
				JLabel rightLabel = new JLabel("");
				cell.add(rightLabel, BorderLayout.EAST);
				
				JLabel topLabel = new JLabel("", SwingConstants.LEFT);
				cell.add(topLabel, BorderLayout.NORTH);
				
				leftLabel.setPreferredSize(new Dimension(12, 100));
				bottomLabel.setPreferredSize(new Dimension(100, 12));
				rightLabel.setPreferredSize(new Dimension(12, 100));
				topLabel.setPreferredSize(new Dimension(100, 12));
				
				if (j == 1) {
					topLabel.setText(i + "");
					topLabel.setVerticalAlignment(SwingConstants.TOP);					
				}
				
				
				if (i == 1) {					
					bottomLabel.setText(getCharForNumber(j));
					bottomLabel.setVerticalAlignment(SwingConstants.BOTTOM);					
				}
				
				// Add chess piece if on this square
				if (game.getGrid().get(i-1).get(j-1) != null) {
					ChessPiece piece = game.getGrid().get(i-1).get(j-1);
					
					try {
						BufferedImage myPicture = ImageIO.read(new File(piece.getImagePath()));
						JLabel picLabel = new JLabel(new ImageIcon(myPicture.getScaledInstance(55, 55, Image.SCALE_DEFAULT)));
						cell.add(picLabel, BorderLayout.CENTER);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				
				panel.add(cell);
			}
			isAlternate = !isAlternate;
		}
		
		return panel;
	}
}
