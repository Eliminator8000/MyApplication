package wip.simon.myapplication.activities.main;

        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import wip.simon.myapplication.datastructures.Constants;

        import java.util.ArrayList;
        import java.util.Arrays;

public class Data {

    private Init mActivity;
    private long mValueDisplay1;
    private long mValueDisplay2;
    private int mActiveDisplay;
    private ArrayList<Long> mStorageValues;

    // constants
    private final int DEFAULTVALUEDISPLAY1 = 0;
    private final int DEFAULTVALUEDISPLAY2 = 0;
    private final int DEFAULTACTIVEDISPLAY = 1;


    public Data(Bundle savedInstanceState, Init activity) {
        mActivity = activity;
        mStorageValues = new ArrayList<Long>();

        if ( savedInstanceState == null ) {
            readIntentParametersOrSetDefaultValues(mActivity.getIntent());
        }
        else { // restore last state
            restoreDataFromBundle(savedInstanceState);
        }
    }

    public void readIntentParametersOrSetDefaultValues(Intent intent) {
        Bundle b = intent.getBundleExtra(Constants.KEYDATABUNDLE);
        if(b==null){
            setDefaultValues();
        }
        else{
            restoreDataFromBundle(b);
        }
    }

    private void setDefaultValues() {
        mValueDisplay1 = DEFAULTVALUEDISPLAY1;
        mValueDisplay2 = DEFAULTVALUEDISPLAY2;
        mActiveDisplay = DEFAULTACTIVEDISPLAY;
        mStorageValues.clear();
    }

    public void saveDataInBundle(Bundle b) {
        b.putLong(Constants.KEYVALUEDISPLAY1, mValueDisplay1);
        b.putLong(Constants.KEYVALUEDISPLAY2, mValueDisplay2);
        b.putLong(Constants.KEYACTIVEDISPLAY, mActiveDisplay);
        long[] la = new long[mStorageValues.size()];
        for(int i = 0; i<mStorageValues.size(); i++) {
            la[i] = mStorageValues.get(i);
        }
        b.putLongArray(Constants.KEYSAVEDSTORAGEVALUES, la);
    }

    public void restoreDataFromBundle(Bundle b) {
        mValueDisplay1 = b.getLong(Constants.KEYVALUEDISPLAY1);
        mValueDisplay2 = b.getLong(Constants.KEYVALUEDISPLAY2);
        mActiveDisplay = b.getInt(Constants.KEYACTIVEDISPLAY);
        mStorageValues.clear();
        long[] la = b.getLongArray(Constants.KEYSAVEDSTORAGEVALUES);
        for(int i = 0; i<la.length; i++){
            mStorageValues.add(la[i]);
        }
    }


    // setter

    public void setValueDisplay1(long value) {
        mValueDisplay1 = value;
    }

    public void setValueDisplay2(long value) {
        mValueDisplay2 = value;
    }

    public void setActiveDisplay(int value) {
        mActiveDisplay = value;
    }


    // getter

    public Init getActivity () {
        return mActivity;
    }

    public long getValueDisplay1() {
        return mValueDisplay1;
    }

    public long getValueDisplay2() {
        return mValueDisplay2;
    }

    public int getActiveDisplay() {
        return mActiveDisplay;
    }


    // other

    public void saveValueInStorage(long value) {
        Log.d("LOGTAG", "saveValueInStorage ...");
        Log.d("LOGTAG", "  " + Arrays.toString(mStorageValues.toArray()));
        mStorageValues.add(value);
    }

}
