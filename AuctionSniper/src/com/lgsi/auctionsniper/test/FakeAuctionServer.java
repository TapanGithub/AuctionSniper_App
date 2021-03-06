package com.lgsi.auctionsniper.test;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.ChatManagerListener;

public class FakeAuctionServer {
	public static final String ITEM_ID_AS_LOGIN = "item-54321";
	public static final String AUCTION_RESOURCE = "Auction";
	public static final String XMPP_HOSTNAME = "localhost";
	
	//private static final String AUCTION_PORT = "9090";
	
	private final String itemId;
	private final XMPPConnection connection;
	private Chat currentChat;
	public FakeAuctionServer(String itemId) {
	this.itemId = itemId;
	this.connection = new XMPPConnection(XMPP_HOSTNAME);
	}
	
	private final SingleMessageListener messageListener = new SingleMessageListener();
	
	public void startSellingItem() throws XMPPException {
		connection.connect();
		connection.login(ApplicationRunner.USERID,ApplicationRunner.USERPASSWORD, AUCTION_RESOURCE);
		connection.getChatManager().addChatListener(new ChatManagerListener() {
					public void chatCreated(Chat chat, boolean createdLocally) {
						currentChat = chat;
						chat.addMessageListener(messageListener);
					}
				});
	}
	public void hasReceivedJoinRequestFrom(String bidder_id) throws InterruptedException {
		messageListener.receivesAMessage();
	}
	
	public void announceClosed() throws XMPPException {
		currentChat.sendMessage(new Message());
	}
	
	public void stop() {
		connection.disconnect();
	}
	
}
	
