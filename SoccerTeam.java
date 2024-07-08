package lab4;

import java.util.Arrays;

/**
 * This class implements a simple soccer team
 * 
 */
public class SoccerTeam {
	private Player[] players;
	private Coach coach;

	

	/**
	 * This is the default constructors. At most 11 player can play in this team. At
	 * most there are 4 roles players can have.
	 */
	private SoccerTeam() {
		this.players = new Player[0];
		this.coach = Coach.getInstance();
		
	}

	/**
	 * This is the overloaded constructor for this class
	 * 
	 * @param player is an array containing all the players who entered the team.
	 * @param coach  is the coach that trains the team's players.
	 */

	private SoccerTeam(Player[] players, Coach coach) {
		
		this.players = Arrays.copyOf(players, players.length);
		this.coach = Coach.getInstance(coach);
		

	}

	/**
	 * This is the copy constructor for this class
	 * 
	 * @param team is an object of SoccerTeam, whose component is deeply copied into
	 *             the component of this object.
	 */
	
    private SoccerTeam(SoccerTeam team) {
    	this.players = Arrays.copyOf(team.players, team.players.length);
    	this.coach = Coach.getInstance(team.coach);
		

	}

	/**
	 * This is a static factory method
	 * 
	 * @return It returns an object of SoccerTeam
	 */
	public static SoccerTeam getInstance() {
		return new SoccerTeam();
		
	}

	/**
	 * This is a static factory method
	 * 
	 * @param player is an array that contains players.
	 * @param coach  is a coach of the team
	 * @return It returns an object of SoccerTeam made using the input parameters.
	 */
	public static SoccerTeam getInstance(Player[] players, Coach coach) {
		//SoccerTeam soccerteam = new SoccerTeam (player, coach);
		//return soccerteam;
		return new SoccerTeam(players, coach);
		
	}

	/**
	 * This is a static factory method
	 * 
	 * @param team is an object of SoccerTeam
	 * @return it returns an object of SoccerTeam made using the input parameter.
	 */
	public static SoccerTeam getInstance(SoccerTeam team) {
		return new SoccerTeam(team);
		
	}

	/**
	 * This is the getter method for the player list.
	 * 
	 * @return returns an array containing all the players of this team.
	 */
	public Player[] getPlayers() {
		return Arrays.copyOf(players, players.length);
	
	}

	/**
	 * This is the getter method for the coach attribute.
	 * 
	 * @return Returns an object of Coach containing all the info of this team's
	 *         coach.
	 */

	public Coach getCoach() {
		return Coach.getInstance(coach);
		
	}

	/**
	 * This is the setter method for the player attribute, which deeply copies the
	 * input parameter into the player attribute of this object.
	 * 
	 * @param player is an array of Player, whose elements are copied in the player
	 *               attribute of this object.
	 */

	public void setPlayers(Player[] players) {
		this.players = Arrays.copyOf(players, players.length);

	}

	/**
	 * This is the setter method for the coach attribute, which deeply copies the
	 * input parameter into the coach attribute of this object.
	 * 
	 * @param coach is an object of Coach, whose attributes are copied in the coach
	 *              attribute of this object.
	 */
	public void setCoach(Coach coach) {
		this.coach = Coach.getInstance(coach);		
	}

}

/**
 * 
 * This class represent each player required to play in this team. A player has
 * a number, a name, and a role. A role can be either defense, central, striker,
 * or goal keeper. these roles can be represented by the characters 'd', 'c',
 * 's', or 'g'
 *
 */
class Player {
	
	private int number;
	private String name;
	private char role;


	
	
	/**
	 * This is the overloaded constructor for this class
	 * Constructs a new Player instance with the specified attributes.
	 *
	 * @param num  The jersey number of the player.
	 * @param name The name of the player.
	 * @param role The role of the player (use 'D' for defense, 'C' for center, 'S' for striker, 'G' for goalkeeper).
	 */
	private Player(int number, String name, char role) {
		this.number = number;
		this.name = name;
		this.role = role;
	   
	}


	/**
	 * This is the copy constructor for this class
	 * Constructs a new Player instance by copying the attributes from an existing Player object.
	 *
	 * @param player The Player object from which to copy attributes.
	 */
	private Player(Player player) {
		this(player.number ,player.name, player.role);
	}

	/**
	 * This is a static factory method.
	 * 
	 * @return It returns an object of Player
	 */
	public static Player getInstance() {
		
		return new Player(0,"",' ');
		
	}

	/**
	 * This is a static factory method
	 * 
	 * @param num  is the player number
	 * @param name is the name of player
	 * @param role is the role of the player in the team
	 * @return It returns an object of player, which is built using the three input
	 *         variables.
	 */
	public static Player getInstance(int num, String name, char role) {
		Player player = new Player(num, name, role);
		return new Player(player);
		
	}

	/**
	 * This is a static factory method
	 * 
	 * @param player is an object of Player
	 * @return it returns an object of Player that is built using the input
	 *         parameter.
	 */
	public static Player getInstance(Player player) {
		 return new Player(player.number, player.name, player.role);
		
	}

	/**
	 * This is the getter method for attribute name
	 * 
	 * @return returns the value of attribute name
	 */
	public String getName() {
		return name;
		
	}

	/**
	 * This is the getter method for attribute role
	 * 
	 * @return returns the value of the attribute role.
	 */
	public char getRole() {
		return role;
		
	}
	
	public int getNumber() {
		return number;
	}

	/**
	 * This is the setter method for attribute name
	 * 
	 * @param name is the value that is used to initialize name attribute
	 */
	public void setName(String name) {
		this.name =  name;
		
	}

	/**
	 * This is the setter method for attribute role
	 * 
	 * @param role is a character to initialize attribute role.
	 */
	public void setRole(char role) {
		this.role = role;
		
	}
	public void setNumber(int number) {
		this.number = number;
	}

}

/**
 * This class represent the coach that trains the team's players. A coach has a
 * name, a number of years of experience, and a level of expertise. The level of
 * expertise can be represented by one of the strings: "high", "average", or
 * "beginner".
 */
class Coach {
	
	private String name;
	private int yearsExp;
	private String Level;


	/**
	 * This is a static factory method
	 * 
	 * @param name     is the name of the coach.
	 * @param yearsExp is the number of years of experience as int.
	 * @param level    is a string that indicate the level of experience.
	 */
	private Coach(String name, int yearsExp, String Level) {
		this.name = name;
		this.yearsExp = yearsExp;
		this.Level = Level;

	}

	/**
	 * This is a static factory method that initializes the attributes to their
	 * default values.
	 * 
	 * @return It returns an object of Coach
	 */
	public static Coach getInstance() {
		return new Coach ("", 0, "");
		
	}

	/**
	 * This is a static factory method
	 * 
	 * @param name     is the name of the coach.
	 * @param yearsExp is the number of years of experience as int.
	 * @param level    is a string that indicate the level of experience.
	 * @return it returns a Coach object.
	 */
	public static Coach getInstance(String name, int yearsExp, String Level) {
		return new Coach(name, yearsExp, Level);
		//Coach coach1 = new Coach("Benni", 10, "beginner");
		//return coach1;
		
		
	
	}

	/**
	 * This is the copy constructor.
	 * 
	 * @param coach is an object of Coach that is used to initialize this object.
	 */
	private Coach(Coach coach) {
		this(coach.name, coach.yearsExp, coach.Level);
	}

	/**
	 * Constructs a new Coach instance by copying the attributes from an existing
	 * Coach object.
	 * 
	 * @param coach The Coach object from which to copy attributes.
	 * @return a new Coach instance by copying the attributes from an existing Coach
	 *         object
	 */
	public static Coach getInstance(Coach coach) {
		return new Coach(coach.name, coach.yearsExp, coach.Level);
		
	}

	/**
	 * Retrieves the name of the coach.
	 * 
	 * @return The name of the coach.
	 */
	public String getName() {
		return name;
	
	}

	/**
	 * Retrieves the number of years of coaching experience.
	 * 
	 * @return The number of years of coaching experience.
	 */
	public int getYearsExp() {
		return yearsExp;
		
	}

	/**
	 * Retrieves the coaching level of the coach.
	 * 
	 * @return The coaching level of the coach
	 */
	public String getLevel() {
		return Level;
		
	}

	/**
	 * Sets the name of the coach.
	 *
	 * @param name The new name for the coach.
	 */
	public void setName(String name) {
		this.name = name;
	   
	}

	/**
	 * Sets the number of years of coaching experience for the coach.
	 *
	 * @param yearsExp The new number of years of coaching experience.
	 */
	public void setYearsExp(int yearsExp) {
		this.yearsExp = yearsExp;
	
	}

	/**
	 * Sets the coaching level of the coach.
	 *
	 * @param level The new coaching level for the coach ("beginner", "average", or "high").
	 */
	public void setLevel(String Level) {
		this.Level = Level;
	  
	}
	
	
	

}
