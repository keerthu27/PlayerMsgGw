package com.java.PlayerMsgGW;

import java.util.ArrayList;

/***
 * This is MessageQueue class for handling messages between 2 players
 * 
 * @author Keerthana
 *
 */

public class MessageQueue {

	// This message counter
	private int intMsgCounter;
	
	private String stryMsgCounter="0";



/**
	 * @return the messageQueue
	 */
	public ArrayList<Message> getMessageQueue() {
		return messageQueue;
	}

	/**
	 * @param messageQueue the messageQueue to set
	 */
	public void setMessageQueue(ArrayList<Message> messageQueue) {
		this.messageQueue = messageQueue;
	}

	// List of the messages
	private ArrayList<Message> messageQueue = new ArrayList<>();

	public MessageQueue(int intMsgCounter) {
		// TODO Auto-generated constructor stub
		this.intMsgCounter = intMsgCounter;
	}

	/**
	 * This method used to add the messages to ArrayList
	 * 
	 * @param message is the Message object
	 */
	void addMessage(Message message) {
		messageQueue.add(message);
	}

	/**
	 * This method return the ArrayList of messages
	 * 
	 * @return MessageQueue object
	 */

	public ArrayList<Message> getMessage() {
		return messageQueue;
	}

	/**
	 * This message is used to get the current message counter
	 * 
	 * @return the intMsgCounter
	 */
	public int getIntMsgCounter() {
		return intMsgCounter;
	}

	/**
	 * This method is used to set the current message counter
	 * 
	 * @param intMsgCounter the intMsgCounter to set
	 */
	public void setIntMsgCounter(int intMsgCounter) {
		this.intMsgCounter = intMsgCounter;
	}

	/**
	 * This method used to create the new ArrayList
	 */
	public void clearMessage() {
		messageQueue = null;
		messageQueue = new ArrayList<>();
	}
	
	/**
	 * @return the stryMsgCounter
	 */
	public String getStryMsgCounter() {
		return stryMsgCounter;
	}

	/**
	 * @param stryMsgCounter the stryMsgCounter to set
	 */
	public void setStryMsgCounter(String stryMsgCounter) {
		this.stryMsgCounter = stryMsgCounter;
	}
}
