Given a Player class - an instance of which can communicate with other Players.

The requirements are as follows:

1. create 2 Player instances
2. one of the players should send a message to second player (let's call this player "initiator")
3. when a player receives a message, it should reply with a message that contains the received message concatenated with the value of a counter holding the number of messages this player already sent.
4. finalize the program (gracefully) after the initiator sent 10 messages and received back 10 messages (stop condition)
5. both players should run in the same java process (strong requirement)
6. document for every class the responsibilities it has.
7. additional challenge (nice to have) opposite to 5: have every player in a separate JAVA process.

Please use core Java as much as possible without additional frameworks like Spring etc; focus on design and not on the technology.
Please include a maven project with the source code to build the jar and a shell script to start the program.
Everything not specified is to be decided by you; everything specified is a hard requirement.


Getting Start

1.Compile the Application
mvn clean install

2. Start the application
Go to cd PlayerMsgGw
./start.sh
or

On command prompt
cd PlayerMsgGw
java -jar target/PlayerMsgGw-0.0.1-SNAPSHOT.jar

3.Result 
Thread : PLAYER2 is started
Thread : PLAYER1 is started
com.java.PlayerMsgGW.InitiatorPlayerImpl.log :: Sender is ::PLAYER1 -- Message : Hello - 0
com.java.PlayerMsgGW.ReceiverPlayerImpl.log ::Sender is ::PLAYER2 -- ACK Message : Hello - 01
com.java.PlayerMsgGW.InitiatorPlayerImpl.log :: Sender is ::PLAYER1 -- Message : Hello - 011
com.java.PlayerMsgGW.ReceiverPlayerImpl.log ::Sender is ::PLAYER2 -- ACK Message : Hello - 0112
com.java.PlayerMsgGW.InitiatorPlayerImpl.log :: Sender is ::PLAYER1 -- Message : Hello - 01122
com.java.PlayerMsgGW.ReceiverPlayerImpl.log ::Sender is ::PLAYER2 -- ACK Message : Hello - 011223
com.java.PlayerMsgGW.InitiatorPlayerImpl.log :: Sender is ::PLAYER1 -- Message : Hello - 0112233
com.java.PlayerMsgGW.ReceiverPlayerImpl.log ::Sender is ::PLAYER2 -- ACK Message : Hello - 01122334
com.java.PlayerMsgGW.InitiatorPlayerImpl.log :: Sender is ::PLAYER1 -- Message : Hello - 011223344
com.java.PlayerMsgGW.ReceiverPlayerImpl.log ::Sender is ::PLAYER2 -- ACK Message : Hello - 0112233445
com.java.PlayerMsgGW.InitiatorPlayerImpl.log :: Sender is ::PLAYER1 -- Message : Hello - 01122334455
com.java.PlayerMsgGW.ReceiverPlayerImpl.log ::Sender is ::PLAYER2 -- ACK Message : Hello - 011223344556
com.java.PlayerMsgGW.InitiatorPlayerImpl.log :: Sender is ::PLAYER1 -- Message : Hello - 0112233445566
com.java.PlayerMsgGW.ReceiverPlayerImpl.log ::Sender is ::PLAYER2 -- ACK Message : Hello - 01122334455667
com.java.PlayerMsgGW.InitiatorPlayerImpl.log :: Sender is ::PLAYER1 -- Message : Hello - 011223344556677
com.java.PlayerMsgGW.ReceiverPlayerImpl.log ::Sender is ::PLAYER2 -- ACK Message : Hello - 0112233445566778
com.java.PlayerMsgGW.InitiatorPlayerImpl.log :: Sender is ::PLAYER1 -- Message : Hello - 01122334455667788
com.java.PlayerMsgGW.ReceiverPlayerImpl.log ::Sender is ::PLAYER2 -- ACK Message : Hello - 011223344556677889
com.java.PlayerMsgGW.InitiatorPlayerImpl.log :: Sender is ::PLAYER1 -- Message : Hello - 0112233445566778899
com.java.PlayerMsgGW.ReceiverPlayerImpl.log ::Sender is ::PLAYER2 -- ACK Message : Hello - 011223344556677889910
Shutdown Hook is running, Application Terminating


