package com.floorisjava.chess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class ChessGameWindow {
	
	public static void create() {
		JFrame frame = new JFrame("Chess Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		JLabel textLabel = new JLabel("Black", SwingConstants.CENTER); 
		textLabel.setPreferredSize(new Dimension(200, 100));
		frame.getContentPane().add(textLabel, BorderLayout.NORTH);
		
		frame.getContentPane().add(createChessGrid(), BorderLayout.CENTER);
		
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

	private static JPanel createChessGrid() {
		GridLayout grid = new GridLayout(8, 8);
		
		JPanel panel = new JPanel();				
		panel.setLayout(grid);
		
		
		boolean isAlternate = false;
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		
		for (int i = 8; i >= 1; i--) {
			for (int j = 1; j <= 8; j++) {
				JLabel label = new JLabel(getCharForNumber(i)+ j, SwingConstants.CENTER);
				
				label.setBorder(blackline);
				
				label.setOpaque(true);
				if (isAlternate) {
					label.setBackground(Color.DARK_GRAY);	
				}
				else {
					label.setBackground(Color.WHITE);
				}
				isAlternate = !isAlternate;
				
				label.setSize(new Dimension(100, 100));
				
				panel.add(label);
			}
			isAlternate = !isAlternate;
		}
		
		return panel;
	}
}
