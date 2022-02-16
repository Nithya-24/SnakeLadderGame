package snakeLadderGame;

public class SnakeLadderGame {

	int winningPos = 100;
	int playerPos = 0;
	int dieRolls = 0;
	int newPos = 0;
	String playerName = "";
	
	int getPlayerPos() {
		return playerPos;
	}

	int getWinningPos() {
		return winningPos;
	}
	
	int getdieRolls() {
		return dieRolls;
	}
	
	SnakeLadderGame(String name){
		playerName = name;
	}
	
	String getPlayerName() {
		return playerName;
	}
	
	int diceRoll() {
		int number = (int) ((Math.random() * 100) % 6) + 1;
		dieRolls += 1;
		System.out.println("Dice Value: " + number);
		newPos = checkOptions(number);
		return newPos;
	}
	
	
	int checkOptions(int diceValue) {
		int option = (int) ((Math.random() * 100) % 3) + 1;
		switch(option) {
		case 1:
			//ladder
			System.out.println(playerName + " took a ladder");
			playerPos = playerPos + diceValue;
			break;
		case 2:
			//snake
			System.out.println(playerName + " bitten by snake");
			playerPos = playerPos - diceValue;
			break;
		case 3:
			//no move
			System.out.println(playerName + " has no move.");
			break;
		}
		
		if(playerPos < 0) {
			playerPos = 0;
		}
		else if(playerPos > 100) {
			playerPos = playerPos - diceValue;
		}
		if(option == 1)
			diceRoll();
		
		
		return playerPos;
	}
	
	boolean checkWinning() {
		if(getPlayerPos() == 100) {
			System.out.println("Congragulations " + getPlayerName() + " finished the game");
			return true;
		}
		return false;
	}
	

		public static void main(String[] args) {
			
			SnakeLadderGame player1 = new SnakeLadderGame("Player1");
			SnakeLadderGame player2 = new SnakeLadderGame("Player2");
			
			String player1Name = player1.getPlayerName();
			String player2Name = player2.getPlayerName();
			
			System.out.println(player1Name + " started playing at position: " + player1.getPlayerPos() + ".\n");
			System.out.println(player1Name + " started playing at position: " + player2.getPlayerPos() + ".\n");
			
			
			while ( true ) {	
				
				System.out.println(player1Name + "'s turn");
				player1.diceRoll();
				System.out.println(player1Name + " reached position " + player1.getPlayerPos() + ".\n");
				if(player1.checkWinning()) 
					break;
				
				System.out.println(player2Name + "'s turn");
				player2.diceRoll();
				System.out.println(player2Name + " reached position " + player2.getPlayerPos() + ".\n");
				if(player2.checkWinning()) 
					break;
				
			}
			
		}

	
}