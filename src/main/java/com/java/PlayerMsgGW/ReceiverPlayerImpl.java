package com.java.PlayerMsgGW;

import java.util.List;

/**
 * ReceiverPlayerImpl.java class is implementation for Receiver player.
 * Check if there is message from initiator and then sending message acknowledge
 * with message counter to initiator
 * @author Keerthana
 *
 */
public class ReceiverPlayerImpl implements Player {

	// Type of the Player
	private PlayerEnum typeofPlayer;
	// Message Queue Object
	private MessageQueue messageQueue;

	/**
	 * This is constructor for PLayer implementation class
	 * 
	 * @param typeofPlayer     is the type of the player
	 * @param intTotalMsgLimit Total message Limit
	 * @param messageQueue     is the MessageQueue object
	 */
	public ReceiverPlayerImpl(PlayerEnum typeofPlayer, int intTotalMsgLimit, MessageQueue messageQueue) {

		this.typeofPlayer = typeofPlayer;
		this.messageQueue = messageQueue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		System.out.println("Thread : " + typeofPlayer + " is started");

		while (true) {
			synchronized (messageQueue) {
				try {
					Thread.sleep(500);
					// Waiting till Initiator thread to read response from queue and put new message
					// in message queue
					messageQueue.notify();
					messageQueue.wait();
				} catch (InterruptedException e) {
					System.err.println(e);
					System.exit(0);
				}
			}
			// Check if there is message and then sending message acknowledge to initiator
			messageCommunication();
		}

	}

	/**
	 * Check if there is message from initiator and then sending message acknowledge
	 * with message counter to initiator
	 */
	@Override
	public void messageCommunication() {
		
		
		if (messageQueue != null) {
			// Get the current message counter
			int intMsgCounter = messageQueue.getIntMsgCounter();
			

			// Get the Message
			List<Message> messageList = messageQueue.getMessage();
			//Check if message in the message queue
			if(messageList !=null) {
				// Increase the Message counter
				intMsgCounter++;

				String strMsgContent = "";
				for (Message message : messageList) {

					// concatenated message with Current counter
					strMsgContent = "" + message.getStrContent() + "" + intMsgCounter;
					
					// Print the Message
					System.out.println("" + getClass().getName() + ".log ::Sender is ::" + typeofPlayer
							+ " -- ACK Message : " + strMsgContent);
				}

				// Creating new message
				Message messageAck = new Message(strMsgContent, typeofPlayer.toString());
				messageQueue.clearMessage();
				//Set current message counter
				messageQueue.setIntMsgCounter(intMsgCounter);
				messageQueue.addMessage(messageAck);
			}
		}
	}
}
