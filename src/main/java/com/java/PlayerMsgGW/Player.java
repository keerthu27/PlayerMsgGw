package com.java.PlayerMsgGW;

/**
 * Player is interface extends runnable
 * 
 * @author Keerthana
 *
 */
public interface Player extends Runnable {

	/**
	 * This method used by player send and receive message *
	 * 
	 */
	public void messageCommunication();

}
