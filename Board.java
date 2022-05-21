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
- boardStatus [][] : char                   //add boardStatus here
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
	/*char startX;
	char endX;
	int startY;
	int endY;*/
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
		/*startX = ' ';
		endX = ' ';
		startY = 0;
		endY = 0;
		boardStatus;*/
		numberOfHits = 0;
		numberOfShipSpots = 0;
		//numberOfShipSpots = 0;
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
	* @param
	*/
	public void setNumbers(int[][] numbers) {
		this.numbers = numbers;
	}
	/**
	* sets number of hits to parameter of calling object
	*
	*
	*/
	public void setNumberOfHits(int numberOfHits) {
		this.numberOfHits = numberOfHits;
	}
	/**
	* sets number of ship spots to parameter of calling object
	*
	*
	*/
	public void setNumberOfShipSpots(int numberOfShipSpots) {
		this.numberOfShipSpots = numberOfShipSpots;
	}


	/***** OTHER REQUIRED METHODS *****/

	public String toString()
	{
		return ; //come back to fix this later!!!
	}

	public boolean equals(Board other)
	{
		return this.numbers.equals(other.numbers) && this.boardStatus.equals(other.boardStatus) && this.numberOfHits == other.numberOfHits && this.numberOfShipSpots == other.numberOfShipSpots;
	}

	void setAll()
	{

	}
	/***** HELPER METHODS *****/

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

	public void placeShip(char startX, int startY, char endX, int endY) //add parameters for startX and startY, and endX and endY
	{
		/*int lower = 0;
		int upper = 9;*/

		int letter = 0;
		int number = 0;

		//String prompt = "Please enter an x coordinate for the start of the ship: ";
		//String validChars = "A, B, C, D, E, F, G, H, I, J";

		//replace with readString method, use charat to get row and column

		//char startX = UtilityBelt.readChar(/*"Please enter an x coordinate for the start of the ship: ",*/ prompt, validChars);
		//int startY = UtilityBelt.readInt("Please enter an y coordinate for the start of the ship: ", lower, upper);
		//char endX = UtilityBelt.readChar(/*"Please enter an x coordinate for the start of the ship: ",*/ prompt, validChars);
		//int endY = UtilityBelt.readInt("Please enter an y coordinate for the end of the ship: ", lower, upper);

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
	public void fillShip(char startX, char endX, int startY, int endY)
	{
		int shipLengthVertical = ((endX - 65) - (startX - 65)) + 1;

		int shipLengthHorizontal = ((endY) - (startY)) + 1;
		//System.out.print(shipLengthHorizontal + " " +  shipLengthVertical);

		if (shipLengthHorizontal > 2)
		{
			for (int i = 0; i < shipLengthHorizontal; i++)
			{
				numbers[endX - 65][i] = 1;
			}
			//NumberOfShipSpots += shipLengthHorizontal
			numberOfShipSpots += shipLengthHorizontal;
		}
		else if (shipLengthVertical > 2)
		{

			for (int i = 0; i < shipLengthVertical; i++)
			{
				numbers[i][endY] = 1;
			}
			//NumberOfShipSpots += shipLengthVertical
			numberOfShipSpots += shipLengthVertical;
		}

	}

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
