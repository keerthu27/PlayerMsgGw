package com.java.PlayerMsgGW;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Keerthana
 * PlayerMsgGwMain.java is the main class of the PlayerMsgGW project
 * 2 Player thread is started
 *  
 * */
public class PlayerMsgGwMain {

	// Initiator message limit
	private final static int INITIATOR_MESSAGE_LIMIT = 10;

	// Number of player
	private final static int NUMBER_OF_PLAYER = 2;

	// Message counter
	private int intMsgCounter = 0;

	// Main method
	public static void main(String[] args) {
		PlayerMsgGwMain gameMain = new PlayerMsgGwMain();
		gameMain.startGame();
	}

	/**
	 * This method 2 Player instance is created.
	 * 2 player thread started. 
	 */
	private void startGame() {

		// Graceful shutdown invoking shutdownhook
		Runtime.getRuntime().addShutdownHook(
				new Thread(() -> System.out.println("Shutdown Hook is running, Application Terminating")));

		// Common message queue object for Player threads to use
		MessageQueue messageQueue = new MessageQueue(intMsgCounter);

		// Initiator player thread by setting initiator true
		Player initiatorPlayer = new InitiatorPlayerImpl(PlayerEnum.PLAYER1, INITIATOR_MESSAGE_LIMIT, messageQueue);

		// Receiver player thread by setting initiator false
		Player reciverPlayer = new ReceiverPlayerImpl(PlayerEnum.PLAYER2, INITIATOR_MESSAGE_LIMIT, messageQueue);

		// We create an executor service, which runs our Player thread.
		ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_PLAYER);
		executorService.submit(initiatorPlayer);
		executorService.submit(reciverPlayer);

		/*
		 * Interrupts the other threads for shutdown. You can also shutdown threads more
		 * gracefully with shutdown() and awaitTermination(), but here just want them to
		 * exit immediately.
		 */
		executorService.shutdown();

	}

}
