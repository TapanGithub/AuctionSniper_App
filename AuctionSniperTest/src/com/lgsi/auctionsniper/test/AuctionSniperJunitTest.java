package com.lgsi.auctionsniper.test;

import com.jayway.android.robotium.solo.Solo;
import com.lgsi.auctionsniper.MainActivity;
import android.test.ActivityInstrumentationTestCase2;
//import junit.framework.TestCase;

public class AuctionSniperJunitTest extends
		ActivityInstrumentationTestCase2<MainActivity> {
	private final FakeAuctionServer auction = new FakeAuctionServer("item-54321");

	public AuctionSniperJunitTest() {
		super(MainActivity.class);
	}

	public void testServerConnection() throws Exception {
		auction.startSellingItem();
		//Solo solo = new Solo(getInstrumentation(), getActivity());
		
		auction.hasReceivedJoinRequestFrom(ApplicationRunner.USERID);
		
	}
}
