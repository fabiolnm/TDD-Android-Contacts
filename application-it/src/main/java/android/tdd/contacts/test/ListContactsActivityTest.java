package android.tdd.contacts.test;

import java.util.ArrayList;

import android.tdd.contacts.R;
import android.tdd.contacts.ListContactsActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ProgressBar;

import com.jayway.android.robotium.solo.Solo;

public class ListContactsActivityTest extends ActivityInstrumentationTestCase2<ListContactsActivity> {
    private Solo solo;

	public ListContactsActivityTest() {
        super("android.tdd.contacts", ListContactsActivity.class);
    }
    
    public void setUp() {
    	solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testShowsLoadingDialogUntilServiceReturnsNoContacts() {
    	ArrayList<ProgressBar> progressBars = solo.getCurrentProgressBars();
    	assertEquals("Should display Loading Contacts progress dialog", 1, progressBars.size());
    	
    	String loadingMsg = solo.getString(R.string.loading_contacts);
    	assertTrue("Progress bar should display loading contacts message", solo.searchText(loadingMsg));
    	
    	String noContactsFound = solo.getString(R.string.no_contacts_found);
    	assertTrue("Should display 'No contacts found'", solo.waitForText(noContactsFound, 1, 3000));
    }
    
    public void tearDown() {
    	try {
    		solo.finalize();
    	} catch (Throwable e) {
    		throw new Error(e);
		}
    }
}

