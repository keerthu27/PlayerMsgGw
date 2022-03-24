package com.java.PlayerMsgGW;

/**
 * Message.java class is the bean class message 
 * 
 */
public class Message {
	private String strContent;
	private String strSenderName;

	/**
	 * This is the constructor for Initiator message format
	 * 
	 * @param strContent      is the message content
	 * @param strSenderName is Message Sender Name
	 */
	public Message(String strContent, String strSenderName) {
		this.strContent = strContent;
		this.strSenderName = strSenderName;
	}

	/**
	 * @return the strContent
	 */
	public String getStrContent() {
		return strContent;
	}

	/**
	 * @param strContent the strContent to set
	 */
	public void setStrContent(String strContent) {
		this.strContent = strContent;
	}

	/**
	 * @return the strSenderName
	 */
	public String getStrSenderName() {
		return strSenderName;
	}

}
