package com.lgsi.auctionsniper.test;
//import com.jayway.android.robotium.solo.Solo;
//import com.jayway.android.robotium.solo.Solo;
import com.lgsi.auctionsniper.MainActivity;

import android.test.ActivityInstrumentationTestCase2;

//import junit.framework.TestCase;

public class AuctionSniperJunitTest extends ActivityInstrumentationTestCase2<MainActivity> {

	public AuctionSniperJunitTest(String name) {
		super(MainActivity.class);
	}
	
	//private Solo solo;
	@Override
	protected void setUp() throws Exception {
	//solo = new Solo(getInstrumentation(),getActivity());
	}
	
	// Need to add the test Cases.
	
	
	@Override
	public void tearDown() throws Exception {
	//solo.finishOpenedActivities();
	}
	
	
}
