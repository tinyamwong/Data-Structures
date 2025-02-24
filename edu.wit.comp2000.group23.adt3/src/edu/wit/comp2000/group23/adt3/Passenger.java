package edu.wit.comp2000.group23.adt3;

public class Passenger {
	private Station destination;
	private Station currentStation;
	private Platform currentPlatform;
	private Train currentTrain;
	private boolean onTrain;
	private int passengerID;

	// constructors
	/**
	 * Default constructor.
	 * 
	 * @param logger
	 *            1
	 */
	public Passenger() {
		this(null, null, null, -1);
	}

	/**
	 * Constructor, takes in logger, destination, currentPlatform,
	 * currentStation, pID
	 * 
	 * @param l
	 * @param destination
	 * @param currentPlatform
	 * @param currentStation
	 * @param pID
	 */
	public Passenger(Station destination, Platform currentPlatform, Station currentStation, int pID) {
		this.onTrain = false;
		this.destination = destination;
		this.currentPlatform = currentPlatform;
		this.currentStation = currentStation;
		this.passengerID = pID;
		this.currentTrain = null;
	}

	// passenger methods (core methods)

	/**
	 * Disembarks the train and add itself to the list of arrived passengers
	 */
	public void disembarkTrain() {
		this.setTrain(null);
		this.currentPlatform.getStation().addArrivingPassenger(this);
	}

	// accessor methods

	/**
	 * accessor method, gets the station of the passenger
	 * 
	 * @return
	 */
	public Station getStation() {
		return this.currentStation;
	}

	/**
	 * accessor method, gets the platform of the passenger
	 * 
	 * @return
	 */
	public Platform getPlatform() {
		return this.currentPlatform;
	}

	/**
	 * accessor method, gets the destination of the passenger
	 * 
	 * @return Station
	 */
	public Station getDestination() {
		return this.destination;
	}

	/**
	 * accessor method, gets the current station of the passenger
	 * 
	 * @return Station
	 */
	public Station getCurrentStation() {
		return this.currentStation;
	}

	/**
	 * accessor method, gets if passenger is on current platform
	 * 
	 * @return Platform
	 */
	public Platform getCurrentPlatform() {
		return this.currentPlatform;
	}

	/**
	 * accessor method, gets if passenger is on train
	 * 
	 * @return boolean
	 */
	public boolean getOnTrain() {
		return this.onTrain;
	}

	/**
	 * accessor method, sets passenger id
	 * 
	 * @return int
	 */
	public int getPassengerID() {
		return this.passengerID;
	}

	// mutator method

	/**
	 * mutator method, sets passenger id
	 * 
	 * @param int
	 *            passengerID
	 */
	public void setPassengerID(int passengerID) {
		this.passengerID = passengerID;
	}

	/**
	 * mutator method, sets the train the passenger is currently on
	 * 
	 * @param Train
	 *            t
	 */
	public void setTrain(Train t) {
		this.currentTrain = t;
		if (t.equals(null)) {
			this.onTrain = false;
		} else {
			this.onTrain = true;
		}
	}

	/**
	 * mutator method, sets the station the passenger is currently on
	 * 
	 * @param Station
	 *            s
	 */
	public void setStation(Station s) {
		this.currentStation = s;
	}

	/**
	 * mutator method, sets the platform the passenger is currently on
	 * 
	 * @param Platform
	 * 
	 */
	public void setPlatform(Platform p) {
		this.currentPlatform = p;
	}

	/**
	 * toString method
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Passenger info: " + "\nPassenger ID: " + this.getPassengerID() + "\nDestination: "
				+ this.getDestination() + "\nCurrent Station: " + this.getCurrentStation() + "\nPlatform: "
				+ this.getCurrentPlatform() + "\nOn train: " + this.getOnTrain();
	}

}
