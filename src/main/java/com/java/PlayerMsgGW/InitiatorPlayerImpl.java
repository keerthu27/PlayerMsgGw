package com.java.PlayerMsgGW;

import java.util.List;

/**
 * 
 * @author keerthana
 * 
 *         InitiatorPlayerImpl.java is the implementation for Initiator player
 *         interface Initiator player send first message to 2nd player
 */
public class InitiatorPlayerImpl implements Player {

	private int intTotalMsgLimit;
	private PlayerEnum typeofPlayer;
	private MessageQueue messageQueue;

	/**
	 * This is constructor for PLayer implementation class
	 * 
	 * @param typeofPlayer     is the type of the player
	 * @param intTotalMsgLimit is the total message limit
	 * @param messageQueue     is the MessageQueue object
	 */
	public InitiatorPlayerImpl(PlayerEnum typeofPlayer, int intTotalMsgLimit, MessageQueue messageQueue) {
		// TODO Auto-generated constructor stub
		this.typeofPlayer = typeofPlayer;
		this.intTotalMsgLimit = intTotalMsgLimit;
		this.messageQueue = messageQueue;
	}

	/**
	 * initiator First send message to player 2. Then read the message acknowledge
	 * from receiver thread. Check the current message count, if its equal to ten
	 * then call System.exit(0) for graceful exit.
	 */
	@Override
	public void run() {

		System.out.println("Thread : " + typeofPlayer + " is started");

		// Send the Message to Player 2
		messageCommunication();

		while (true) {
			// Check the current message count, if its equal to ten then call System.exit(0)
			// for graceful exit.
			if (messageQueue.getIntMsgCounter() >= intTotalMsgLimit) {
				System.exit(0);
			}
			synchronized (messageQueue) {
				messageCommunication();
				try {
					Thread.sleep(500);
					// After sending message, Initiator thread sleep, until receiver thread read
					// message and send message acknowledge
					messageQueue.notify();
					messageQueue.wait();

				} catch (InterruptedException e) {
					System.err.println(e);
					System.exit(0);
				}
			}
		}
	}

	/**
	 * initiator First send message to player 2. Then read the message acknowledge
	 * from receiver thread.
	 */
	@Override
	public void messageCommunication() {
		// TODO Auto-generated method stub

		String strMsgContent = "";
		int intCurrentMsgCount = messageQueue.getIntMsgCounter();
		// FirstTime initiator sending message
		if (intCurrentMsgCount == 0) {
			strMsgContent = "Hello - ";
		}
	

		// Get the List of the Messages
		List<Message> messageList = messageQueue.getMessage();
		// Checking if Receiver sent Response
		if (messageList != null) {

			// Print the Response from Receiver
			for (Message message : messageList) {
				strMsgContent = "" + message.getStrContent() + "" + messageQueue.getIntMsgCounter();
				System.out.println("" + getClass().getName() + ".log :: Sender is ::" + typeofPlayer + " -- Message : "
						+ strMsgContent);
			}

		}
		Message message = new Message(strMsgContent, typeofPlayer.toString());
		// Clear the existing message queue
		messageQueue.clearMessage();
		// Add new message to message queue
		messageQueue.addMessage(message);

	}

}