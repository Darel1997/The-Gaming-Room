package com.gamingroom;

/**
 * Application start-up program
 * 
 * @author coce@snhu.edu
 */
public class ProgramDriver {
	
	/**
	 * The one-and-only main() method
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		// FIXME: obtain reference to the singleton instance
		GameService service = GameService.getInstance(); // replace null with ???
		
		System.out.println("\nAbout to test initializing game data...");
		
		// initialize with some game data
		Game game1 = service.addGame("Game #1");
		System.out.println(game1);
		Game game2 = service.addGame("Game #2");
		System.out.println(game2);
		
		// use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();
		System.out.println();
		long id = 1;
		System.out.println("get 1 " + GameService.getInstance().getGame(id));
		id=2;
		System.out.println("get 2 " + GameService.getInstance().getGame(id));
		id=3;
		System.out.println("get 3 " + GameService.getInstance().getGame(id));
		System.out.println("get 3 " + GameService.getInstance().getGame("game 3"));
	}
}