package android.tdd.contacts.test;

import com.jayway.android.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;
import android.tdd.contacts.*;

public class HelloAndroidActivityTest extends ActivityInstrumentationTestCase2<HelloAndroidActivity> {
    private Solo solo;

	public HelloAndroidActivityTest() {
        super("android.tdd.contacts", HelloAndroidActivity.class);
    }
    
    public void setUp() {
    	solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testActivity() {
    	assertTrue(solo.searchText(solo.getString(R.string.hello)));
    }
    
    public void tearDown() {
    	try {
    		solo.finalize();
    	} catch (Throwable e) {
    		throw new Error(e);
		}
    }
}

