package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	// FIXME: Add missing pieces to turn this class a singleton
	/* 
	 * The singleton pattern limits the number objects to only one
	 * and it allows only one entry point to create the new instance of the class.
	 * In the code below by making the constructor private it prevented other 
	 * classes from creating a new instance of the class and instead and the 
	 * getInstance method only allows for a single entry to create the new instance of the class.
	*/
	private static GameService instance = new GameService();
	private GameService(){}
	public static GameService getInstance(){
		return instance;
	}
	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;
		// FIXME: Use iterator to look for existing game with same name
		// if found, simply return the existing instance
		/*
		 * The iterator pattern is used to traverse through the collection
		 * of games and it isolates the user from the structure. 
		 * While it iterates through the collection we check
		 * if there's a game with the same name and return it.
		 */
		ListIterator<Game> nameIterator= games.listIterator();
		while(nameIterator.hasNext()){
			 int i = nameIterator.nextIndex();
	        if (nameIterator.next().getName().equals(name)) {
				return GameService.getInstance().getGame(i);
	        }
		}	
		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;
		// FIXME: Use iterator to look for existing game with same id
		// if found, simply assign that instance to the local variable
		/*
		 * The iterator pattern is used to traverse through the collection
		 * of games. While it iterates through the collection we check
		 * if there's a game with the same id and assign that instance to the local variable.
		 */
		ListIterator<Game> idIterator = games.listIterator();
		while(idIterator.hasNext()) {
			int i = idIterator.nextIndex();
			if (idIterator.next().getId() == id) {
			game = GameService.getInstance().getGame(i);
	        }
		}
		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;
		// FIXME: Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
		/*
		 * The iterator pattern is used to traverse through the collection
		 * of games. While it iterates through the collection we check
		 * if there's a game with the same name and assign that instance to the local variable.
		 */
		ListIterator<Game> nameIterator2 = games.listIterator();
		while(nameIterator2.hasNext()) {
			int i = nameIterator2.nextIndex();
			if (nameIterator2.next().getName().equals(name)) {
				game = GameService.getInstance().getGame(i);
			}
		}		
		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
}
