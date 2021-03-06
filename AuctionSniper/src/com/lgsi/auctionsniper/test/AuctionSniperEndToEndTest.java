package com.lgsi.auctionsniper.test;

//import android.test.ActivityInstrumentationTestCase2;

public class AuctionSniperEndToEndTest {
	private final FakeAuctionServer auction = new FakeAuctionServer(
			"item-54321");
	private final ApplicationRunner application = new ApplicationRunner();

	// @Test
	public void sniperJoinsAuctionUntilAuctionCloses() throws Exception {
		auction.startSellingItem();
		application.startBiddingIn(auction);
		auction.hasReceivedJoinRequestFrom("tapan1");
		auction.announceClosed();
		application.showsSniperHasLostAuction();
	}

	// @After
	public void stopAuction() {
		auction.stop();
	}

	// @After
	public void stopApplication() {
		application.stop();
	}
}