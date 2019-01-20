package com.hotmail.zckerkman;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * Creates the GUI for the master board.
 * 
 * @author AntonioSSD
 */
public class MasterBoardGUI {
	
	/**
	 * A 2D array of Strings representing the states of the tiles throughout the
	 * master board.
	 */
	private String[][] nestedBoardValues;
	
	/**
	 * An array of all BoardGUIs in the master board.
	 */
	public static BoardGUI[] boards = new BoardGUI[9];
	
	public MasterBoardGUI(String[][] nestedBoardValues) {
		this.nestedBoardValues = nestedBoardValues;
	}
	/**
	 * Creates a board of boards.
	 * @return the master board panel
	 */
	public JPanel iterateThroughBoardValues() {
		JPanel masterBoard = new JPanel();
		masterBoard.setLayout(new GridLayout(3, 3));
		
		// Converts the board values to tiles, adds the tiles to boards, and
		// adds the boards to the master board.
		for(int i = 0; i < nestedBoardValues.length; i++) {
			BoardGUI singleBoard = new BoardGUI(nestedBoardValues[i]);
			boards[i] = singleBoard;
			JPanel tileBoard = singleBoard.iterateThroughBoardValues();
			tileBoard.setBorder(BorderFactory.createLineBorder(Color.BLACK, 7));
			masterBoard.add(tileBoard);
		}
		return masterBoard;
	}
}