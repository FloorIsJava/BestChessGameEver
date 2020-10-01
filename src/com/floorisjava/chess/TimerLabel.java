package com.floorisjava.chess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class TimerLabel extends JLabel {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
    private Timer timer;
	private long duration;
	private long startTime = -1;
	private ChessGame game;
	private JFrame window;
	private PieceColor color;     

	public TimerLabel(long duration, int alignConstant, ChessGame game, JFrame window, PieceColor color) {
		super(sdf.format(duration), alignConstant);
		this.duration = duration;
		this.game = game;
		this.window = window;
		this.color = color;
		
	}
	
	public void startTimer() {
		
		timer = new Timer(10, new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (startTime < 0) {
	                startTime = System.currentTimeMillis();
	            }
	            long now = System.currentTimeMillis();
	            long clockTime = now - startTime;
	            if (clockTime >= duration) {
	                clockTime = duration;
	                timer.stop();
	                game.lose(window, color);
	            }	            
	            TimerLabel.this.setText(sdf.format(duration - clockTime));
	        }
	    });
		timer.start();
	}
	
	public void stopTimer() {
		 long now = System.currentTimeMillis();
         long clockTime = now - startTime;
         duration -= clockTime;
         
         timer.stop();
         startTime = -1;
	}
	
	

}
