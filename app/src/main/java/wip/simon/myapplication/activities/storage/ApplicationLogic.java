package wip.simon.myapplication.activities.storage;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import wip.simon.myapplication.datastructures.Constants;

public class ApplicationLogic {

    private Data mData;
    private Gui mGui;
    private MyAdapter mDataAdapter;

    public ApplicationLogic (Data data, Gui gui) {
        mData = data;
        mGui = gui;
        initGui();
        initListener();
    }

    private void initGui() {
        int value;

        mDataAdapter = new MyAdapter(mData);
        mGui.getListView().setAdapter(mDataAdapter);
    }

    private void initListener() {
        ClickListener cl;
        ListItemClickListener licl;

        cl = new ClickListener(this);
        mGui.getButtonInsert().setOnClickListener(cl);
        mGui.getButtonDelete().setOnClickListener(cl);
        licl = new ListItemClickListener(this);
        mGui.getListView().setOnItemClickListener(licl);
        mGui.getListView().setOnItemLongClickListener(licl);
    }

    public void dataToGui() {
    }

    public void onButtonInsertClicked() {
        Log.d("LOGTAG", "onButtonInsertClicked ...");
        mData.saveValueInStorage(0xFF000000 | (int) (Math.random() * 0x01000000));
        mDataAdapter.notifyDataSetChanged();
    }

    public void onButtonClearClicked() {
        Log.d("LOGTAG", "onButtonClearClicked ...");
        mData.clearStorage();
        mDataAdapter.notifyDataSetChanged();
    }

    public void onActivityReturned(int requestCode, int resultCode, Intent data) {
        Log.d("LOGTAG", "onActivityReturned ...");
        int value;
        if ( resultCode == Activity.RESULT_OK ) {
            switch ( requestCode ) {
                case Constants.REQUESTCODEONE:
                    // TODO
                    break;
            }
        }
    }

    public void onListItemClicked(int position) {
        Log.d("LOGTAG", "onListItemClicked ...");
        Log.d("LOGTAG", "  position " + position + " clicked");

        long value = mData.getStorageValue(position);
        if ( mData.getActiveDisplay() == 1 ) {
            mData.setValueDisplay1(value);
        }
        else {
            mData.setValueDisplay2(value);
        }
        defineActivityReturnValues();
        mData.getActivity().finish();
    }

    public void onListItemLongClicked(int position) {
        Log.d("LOGTAG", "onListItemLongClicked ...");
        Log.d("LOGTAG", "  position " + position + " clicked");
        mData.deleteValueFromStorage(position);
        mDataAdapter.notifyDataSetChanged();
    }

    private void defineActivityReturnValues () {
        Bundle b = new Bundle;
        mData.saveDataInBundle(b);
        Intent intent = new Intent();
        intent.putExtra(Constants.KEYDATABUNDLE,b);
        mData.getActivity().setResult(Activity.RESULT_OK,intent);
    }

}
