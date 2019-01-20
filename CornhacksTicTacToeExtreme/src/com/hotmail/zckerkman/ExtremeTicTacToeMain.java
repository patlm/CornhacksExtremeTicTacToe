package com.hotmail.zckerkman;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Controls the game-flow for Extreme Tic-Tac-Toe.
 * 
 * @author AntonioSSD, LukeAVanDrie
 */
public class ExtremeTicTacToeMain {
	
	/**
	 * State that controls the turn order.
	 */
	public static State turnState = State.X;
	/**
	 * The master board.
	 */
	public static MasterBoard mb;
	/**
	 * Contains the GUI.
	 */
	public static JFrame frame;

	public static void main(String[] args) {
		// Creates master board.
		mb = new MasterBoard();
		
		// Creates an array of the tile states in String form.
		String[][] nestedStringArray = new String[9][9];

		// Iterates through all boards in the master board.
		Board[] boards = mb.getBoards();
		for (int i = 0; i < boards.length; i++) {
			ArrayList<String> stringArrayList = new ArrayList<String>();

			// Iterates through the states of each board in the master board and
			// adds their String representations to an ArrayList.
			State[] boxes = boards[i].getTileStates();
			for (int j = 0; j < boxes.length; j++) {
				stringArrayList.add(State.convertToString(boxes[j]));
			}

			// Adds a board's states represented as Strings to the array of the states of all
			// of the boards in the master board.
			String[] stringArray = new String[9];
			for (int j = 0; j < stringArrayList.size(); j++) {
				stringArray[j] = stringArrayList.get(j);
			}

			nestedStringArray[i] = stringArray;
		}

		// Creates master board GUI from saved values.
		MasterBoardGUI masterBoardGui = new MasterBoardGUI(nestedStringArray);
		JPanel panel = masterBoardGui.iterateThroughBoardValues();
		

		// Sets the initial board's tile backgrounds to a playable color indicator.
		BoardGUI boardGUI = MasterBoardGUI.boards[4];
		Tile[] tiles = boardGUI.tiles;
		for (int i = 0; i < tiles.length; i++) {
			tiles[i].setBackground(Color.GREEN);
		}

		// Handles frame creation.
		frame = new JFrame("Extreme Tic-Tac-Toe!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(900, 900);
		frame.add(panel);
		frame.setVisible(true);
	}
}