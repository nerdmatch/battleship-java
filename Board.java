import java.util.Arrays;
/**
 * Represents <what is this class?> the properties of a single battleship.
 *
 * @author <name> Aaron Siegman
 *
 **/

/* UML CLASS DIAGRAM:
-----------------------------------------
<class name> Board // Use Board
-----------------------------------------
<data, i.e. variables>
//don't use  startx, starty, endX, endy as instance variables.

- numbers [][] : int
- boardStatus [][] : char           //add boardStatus here
- numberOfHits : int     // need a third instance variable
- numberOfShipSpots : int
-----------------------------------------
<actions, i.e. methods>

+ getNumbers() : int
+ getBoardStatus() : char
+ getNumberOfHits() : int
+ getNumberOfShipSpots() : int


+ setNumbers(numbers: int) : void
+ setBoardStatus(boardStatus : char) : void
+ setNumberOfHits(numberOfHits : int) : void
+ setNumberOfShipSpots(numberOfShipSpots : int) : void


+setAll(numbers : int, boardStatus: char, numberOfHits : int, numberOfShipSpots : int)
-----------------------------------------
*/

public class Board // Board //TODO: don't forget to rename here and rename the file too!
{
	/***** STATIC VARIABLES *****/

	/***** INSTANCE VARIABLES *****/
	private int[][]numbers;
	private char [][] boardStatus = {
			{'O','O','O','O','O','O','O','O','O','O'},
			{'O','O','O','O','O','O','O','O','O','O'},
			{'O','O','O','O','O','O','O','O','O','O'},
			{'O','O','O','O','O','O','O','O','O','O'},
			{'O','O','O','O','O','O','O','O','O','O'},
			{'O','O','O','O','O','O','O','O','O','O'},
			{'O','O','O','O','O','O','O','O','O','O'},
			{'O','O','O','O','O','O','O','O','O','O'},
			{'O','O','O','O','O','O','O','O','O','O'},
			{'O','O','O','O','O','O','O','O','O','O'}
		};
	private int numberOfHits;
	private int numberOfShipSpots;

	//Mark all instance variables as private.
	/***** CONSTRUCTORS *****/
	public Board()
	{
		numbers = new int [10][10];
		/*boardStatus;*/
		numberOfHits = 0;
		numberOfShipSpots = 0;

	}

	public Board(int[][]numbers, char[][]boardStatus, int numberOfHits, int numberOfShipSpots)
	{
		this.numbers = numbers;
		this.boardStatus = boardStatus;
		this.numberOfHits = numberOfHits;
		this.numberOfShipSpots = numberOfShipSpots;

	}

	/***** ACCESSORS *****/
	/**
	*Returns current status of the board
	*
	*@return array representing the state of the board
	*/
	public char[][] getBoardStatus() {
		return boardStatus;
	}
	/**
	*Returns rows and columns for the game board
	*
	*@return array representing the rows and columns of the game board
	*/
	public int[][] getNumbers() {
		return numbers;
	}
	/**
	*Returns the number of times hits have successfully landed
	*
	*@return int representing the amount of times a ship has been struck on either the player or opponenent board
	*/
	public int getNumberOfHits() {
		return numberOfHits;
	}
	/**
	*Returns the number of places that a ship is occupying on the board
	*
	*@return int representing the spaces that have been converted from open water to ship present
	*/
	public int getNumberOfShipSpots() {
		return numberOfShipSpots;
	}

	/***** MUTATORS *****/
	/**
	* sets boardStatus to parameter value of calling object
	*
	* @param char boardStatus representing the distribution of chars on the game board
	*/
	public void setBoardStatus(char[][] boardStatus) {
		this.boardStatus = boardStatus;
	}
	/**
	* sets numbers to parameter value of calling object
	*
	* @param int numbers representing the rows and columns on the game board
	*/
	public void setNumbers(int[][] numbers) {
		this.numbers = numbers;
	}
	/**
	* sets number of hits to parameter of calling object
	*
	* @param int numberOfHits representing the number of times a ship that has been placed on the game board has been hit.
	*/
	public void setNumberOfHits(int numberOfHits) {
		this.numberOfHits = numberOfHits;
	}
	/**
	* sets number of ship spots to parameter of calling object
	*
	* @param int numberOfShipSpots representing the number of coordinates on the game board that have been converted to shipPresent.
	*/
	public void setNumberOfShipSpots(int numberOfShipSpots) {
		this.numberOfShipSpots = numberOfShipSpots;
	}


	/***** OTHER REQUIRED METHODS *****/
	/**
	* Convert Board into String representation of all data
	*
	* @return String containing all of Board objects data, separated by newlines. No newline at end.
	*/
	public String toString()
	{
		return "Numbers: " + this.numbers + "\nBoard Status: " + this.boardStatus + "\nNumber Of Hits: " + this.numberOfHits + "\nNumber Of Ship Spots: " + this.numberOfShipSpots;
	}
	/**
	* Checking Board object equality (all instance variables), case-sensitive
	*
	* @param other Board object that is being compared against
	*
	* @return boolean representing equality of two objects, true if exactly the same (case-sensitive)
	*/
	public boolean equals(Board other)
	{
		return this.numbers.equals(other.numbers) && this.boardStatus.equals(other.boardStatus) && this.numberOfHits == other.numberOfHits && this.numberOfShipSpots == other.numberOfShipSpots;
	}
	/**
	* Sets all instance variable data (4) at once.
	*
	* @param numbers rows and columns of game board
	* @param boardStatus intial appearance of board
	* @param numberOfHits successful hits on opposing players' ships
	* @param numberOfShipSpots coordinates on the game board that are taken up by any ships that have been placed.
	*
	* @return boolean that represents valid data (non-Strings only, which in this case is everything)
	*/
	public void setAll(int [][] numbers, char [][] boardStatus, int numberOfHits, int numberOfShipSpots) //Saw that using setAll with arrays required import java.util.Arrays and in the parameters for setAll (int [] array, IntUnaryOperator generator). I couldn't figure out how to do that, and I kept getting error messages with my array instance variables, so I didn't use them in the boolean statement. link for source is: https://www.educative.io/edpresso/what-is-arrayssetall-in-java
	{
		//call void setters
		this.numbers = numbers;
		this.boardStatus = boardStatus;
		this.numberOfHits = numberOfHits;
		this.numberOfShipSpots = numberOfShipSpots;

		//call boolean returning (error checking) setters
		// boolean combinedValid = this.numberOfHits(numberOfHits) & this.setNumberOfShipSpots(numberOfShipSpots);

		// return combinedValid;
	}
	/***** HELPER METHODS *****/
	/**
	* Prints the game board with any alterations that have been made by the player
	*
	* Displays the board in the console with any alterations made by other methods such as placeShip, fillShip, and guessShipLocation.
	*/
	public void printBoard()
	{
		//print 0 through 9 separated by a space
		System.out.println("col:    0 1 2 3 4 5 6 7 8 9");
		System.out.println(" ");
		for(int row = 0; row < numbers.length; row++)
		{
		//Go to OLI
			char letter = (char)(row + 'A');
			System.out.print("row: " + letter + "\t");
			for(int col = 0; col < numbers.length; col++)
			{
				//System.out.print("col: " + col);
				//int value = numbers[row][col];
				//System.out.print("value: " + value);
				char openWater = 'O'; //0 = Water
				char shipPresent = 'P'; //1 = Ship Present
				char shipHit = 'H'; //2 = Ship Hit


				if (numbers[row][col] == 0)
				{
					System.out.print(openWater);
				}
				else if (numbers[row][col] == 1)
				{
					System.out.print(shipPresent);
				}
				else if (numbers[row][col] == 2)
				{
					System.out.print(shipHit);
				}
				System.out.print(" ");
			}

			System.out.println();
		}

	}
	/**
	* Prints the game board in its initial state without any alterations made by the player.
	*
	* Displays the board in the console with only the character for open water, 'O', in each coordinate position.
	*/
	public void fillBoard()
	{
		System.out.println("col:    0 1 2 3 4 5 6 7 8 9");
		System.out.println(" ");
		for (int i = 0; i < 10; i++) //row
		{
			char letter = (char)(i + 'A');
			System.out.print("row: " + letter + "\t");
			for (int j = 0; j < 10; j++) //column
			{
				System.out.print(numbers[i][j]);
				if (j != 9)
				{
					System.out.print(' '); // this is a space to separate columns.
				}
			}
			System.out.println();
		}
	}
	/**
	* Places ships in the starting and ending coordinates as dicatated by user input.
	*
	* Parameters used are startX, a char, startY, an int, endX, a char, and endY, an int. These represent the horizontal and vertical values for the start and end points.
	*
	* Converts the open water char 'O' to the ship present char 'P', indicating that a ship, or part of a ship, is occupying that coordinate.
	*/
	public void placeShip(char startX, int startY, char endX, int endY) //add parameters for startX and startY, and endX and endY
	{
		// int lower = 0;
		// int upper = 9;

		int letter = 0;
		int number = 0;

	// 	String prompt = "Please enter an x coordinate for the start of the ship: ";
	// 	String validChars = "A, B, C, D, E, F, G, H, I, J";

	// 	/*replace with readString method, use charat to get row and column*/

	// /*char*/startX = UtilityBelt.readChar(/*"Please enter an x coordinate for the start of the ship: ",*/ prompt, validChars);
	// /*int*/	startY = UtilityBelt.readInt("Please enter an y coordinate for the start of the ship: ", lower, upper);
	// /*char*/endX = UtilityBelt.readChar(/*"Please enter an x coordinate for the start of the ship: ",*/ prompt, validChars);
	//  /*int*/ endY = UtilityBelt.readInt("Please enter an y coordinate for the end of the ship: ", lower, upper);

		//error check for ship placement; one must be purely horizontal or purely vertical
		if (!(startX == endX || startY == endY))
		{
			System.out.println("Error : either x coordinates or y cordinates must be equal to each other in order for a ship to be placed; retry.");
			return;
		}

		//convert char to int
		letter = startX - 65; //represents place on board; new x coordinate
		number = startY; // represents place on board; new y coordinate

		numbers[letter][number] = 1; //shipPresent

		letter = endX - 65; //represents place on board; new x coordinate
		number = endY; // represents place on board; new y coordinate
		/*char openWater = 'O'; //0 = Water
		char shipPresent = 'P'; //1 Ship Present
		char shipHit = 'X'; //2 Ship Hit*/

		numbers[letter][number] = 1; //shipPresent

		fillShip(startX, endX, startY, endY);
	}

		//fillShip(numbers, startX, endX, startY, endY);
		//Create a loop where the start is (startX, startY) and it iterates through until it hits (endX, endY)
	/**
	* Fills in the open water coordinates between starting and ending coordinates for ships placed with  ships in the starting and ending coordinates as dicatated by user input.
	*
	* Parameters used are startX, a char, startY, an int, endX, a char, and endY, an int. These represent the horizontal and vertical values for the start and end points.
	*
	* Converts any open water char 'O' between the starting and ending points of the ship to the ship present char 'P', indicating that a ship, or part of a ship, is occupying that coordinate.
	*/
	public void fillShip(char startX, char endX, int startY, int endY)
	{
		int shipLengthVertical = ((endX - 65) - (startX - 65)) + 1;

		int shipLengthHorizontal = ((endY) - (startY)) + 1;
		//System.out.print(shipLengthHorizontal + " " +  shipLengthVertical);

		if (shipLengthHorizontal > 2)
		{
			for (int i = 0; i < shipLengthHorizontal; i++)
			{
				System.out.println("horizontal: " + (endX - 65) + "," + (startY + i));
				numbers[endX - 65][startY + i] = 1;
			}
			//NumberOfShipSpots += shipLengthHorizontal
			numberOfShipSpots += shipLengthHorizontal;
		}
		else if (shipLengthVertical > 2)
		{

			for (int i = 0; i < shipLengthVertical; i++)
			{
				System.out.print("veritcal: " + i + "," + endY);
				numbers[(startX - 65) + i][endY] = 1;
			}
			//NumberOfShipSpots += shipLengthVertical
			numberOfShipSpots += shipLengthVertical;
		}

	}
 	/**
	* Simulates a player's ship being attacked by another player. The character for ship present, 'P', is converted to the character for ship hit, 'H', if one player correctly guesses the position of another players ship.
	*
	* User enter a char for the X value and an int for the Y value of the coordinate they believe a ship to be at.
	*
	* Converts the character for ship present, 'P', is converted to the character for ship hit, 'H', and displays a message indicating that a ship has been hit in the console when a player's guess for a ship occupied coordinate is correct. Otherwise, the coordinate guessed does not change and a message indicating that the attack failed is displayed in the console.
	*/
	public void guessShipLocation() //Methods cannot be static when using parameters; alter this for all methods.
	{
		int lower = 0;
		int upper = 9;

		int letter = 0;
		int number = 0;

		String prompt = "Please enter an x coordinate for the start of the ship: ";
		String validChars = "ABCDEFGHIJ";

		char guessX = UtilityBelt.readChar(/*"Please enter an x coordinate for the start of the ship: ",*/ prompt, validChars);
		int guessY = UtilityBelt.readInt("Please enter an y coordinate for the start of the ship: ", lower, upper);

		letter = guessX - 65; //represents place on board; new x coordinate
		number = guessY; // represents place on board; new y coordinate



		if (numbers[letter][number] == 1)  //shipPresent; converted O to P
		{
			numbers[letter][number] = numbers[letter][number] + 1; //or numbers[letter][number]++
			System.out.println("Ship was hit!");
			numberOfHits++;
		}
		else
		{
			System.out.println("Miss!");
		}


	}
	//printBoard(int[][]numbers, boolean enemy). If enemy, print

	//NumberOfShipSpots = total points for ships on the boards

	//Add checkIfWon method that returns a boolean which would be the number of hits = number of ship spots.
	/**
	* Method that checks whether one board has had all ship present coordinates coverted to ship hit coordinates.
	*
	* @returns a boolean statement for true when the number of hits is equal to the number of ship spots, thereby indcating victory for a player. Otherwise it returns false, and the game continues.
	*/
	public boolean checkIfWon()
	{
		if (numberOfHits == numberOfShipSpots) // or return (numberOfHits == numberOfShipSpots)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
