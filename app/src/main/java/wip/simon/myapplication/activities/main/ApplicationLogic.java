package wip.simon.myapplication.activities.main;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import wip.simon.myapplication.datastructures.Constants;

public class ApplicationLogic {

    private Data mData;
    private Gui mGui;

    public ApplicationLogic (Data data, Gui gui) {
        mData = data;
        mGui = gui;
        initGui();
        initListener();
    }

    private void initGui() {
        dataToGui();
    }

    private void initListener() {
        ClickListener cl;

        cl = new ClickListener(this);
        mGui.getTextViewDisplay1().setOnClickListener(cl);
        mGui.getTextViewDisplay2().setOnClickListener(cl);
        mGui.getButtonZero().setOnClickListener(cl);
        mGui.getButtonOne().setOnClickListener(cl);
        mGui.getButtonDelete().setOnClickListener(cl);
        mGui.getButtonAdd().setOnClickListener(cl);
        mGui.getButtonMult().setOnClickListener(cl);
        mGui.getButtonSave().setOnClickListener(cl);
        mGui.getButtonRestore().setOnClickListener(cl);
    }

    public void dataToGui() {
        mGui.getTextViewDisplay1().setText(Long.toBinaryString(mData.getValueDisplay1()));
        mGui.getTextViewDisplay2().setText(Long.toBinaryString(mData.getValueDisplay2()));
        setTextColorInDisplays();
    }

    private void setTextColorInDisplays() {
        if ( mData.getActiveDisplay() == 1 ) {
            mGui.getTextViewDisplay1().setTextColor(0xFF000000);  // black
            mGui.getTextViewDisplay2().setTextColor(0xFFaaaaaa);  // grey
        }
        else {
            mGui.getTextViewDisplay2().setTextColor(0xFF000000);  // black
            mGui.getTextViewDisplay1().setTextColor(0xFFaaaaaa);  // grey
        }
    }

    public void onTextViewDisplay1Clicked() {
        Log.d("LOGTAG", "onTextViewDisplay1Clicked ...");
        mData.setActiveDisplay(1);
        dataToGui();
    }

    public void onTextViewDisplay2Clicked() {
        Log.d("LOGTAG", "onTextViewDisplay2Clicked ...");
        mData.setActiveDisplay(2);
        dataToGui();
    }

    public void onButtonZeroClicked() {
        long v;
        Log.d("LOGTAG", "onButtonZeroClicked ...");
        if ( mData.getActiveDisplay() == 1 ) {
            v = mData.getValueDisplay1();
            v *= 2;
            mData.setValueDisplay1(v);
        }
        else {
            v = mData.getValueDisplay2();
            v *= 2;
            mData.setValueDisplay2(v);
        }
        dataToGui();
    }

    public void onButtonOneClicked() {
        long v;
        Log.d("LOGTAG", "onButtonOneClicked ...");
        if ( mData.getActiveDisplay() == 1 ) {
            v = mData.getValueDisplay1();
            v = 2 * v + 1;
            mData.setValueDisplay1(v);
        }
        else {
            v = mData.getValueDisplay2();
            v = 2 * v + 1;
            mData.setValueDisplay2(v);
        }
        dataToGui();
    }

    public void onButtonDeleteClicked() {
        long v;
        Log.d("LOGTAG", "onButtonDeleteClicked ...");
        if ( mData.getActiveDisplay() == 1 ) {
            v = mData.getValueDisplay1();
            v /= 2;
            mData.setValueDisplay1(v);
        }
        else {
            v = mData.getValueDisplay2();
            v /= 2;
            mData.setValueDisplay2(v);
        }
        dataToGui();
    }

    public void onButtonAddClicked() {
        long v1, v2, result;
        Log.d("LOGTAG", "onButtonAddClicked ...");
        v1 = mData.getValueDisplay1();
        v2 = mData.getValueDisplay2();
        result = v1 + v2;
        if ( mData.getActiveDisplay() == 1 ) {
            mData.setValueDisplay1(result);
        }
        else {
            mData.setValueDisplay2(result);
        }
        dataToGui();
    }

    public void onButtonMultClicked() {
        long v1, v2, result;
        Log.d("LOGTAG", "onButtonMultClicked ...");
        v1 = mData.getValueDisplay1();
        v2 = mData.getValueDisplay2();
        result = v1 * v2;
        if ( mData.getActiveDisplay() == 1 ) {
            mData.setValueDisplay1(result);
        }
        else {
            mData.setValueDisplay2(result);
        }
        dataToGui();
    }

    public void onButtonSaveClicked() {
        Log.d("LOGTAG", "onButtonSaveClicked ...");
        if ( mData.getActiveDisplay() == 1 ) {
            mData.saveValueInStorage(mData.getValueDisplay1());
        } else {
            mData.saveValueInStorage(mData.getValueDisplay2());
        }
    }

    public void onButtonRestoreClicked() {
        Log.d("LOGTAG", "onButtonRestoreClicked ...");
        Intent intent;
        intent = new Intent();
        intent.setClass(mData.getActivity(),Constants.ACTIVITYSTORAGECLASS);
        Bundle b = new Bundle();
        mData.saveDataInBundle(b);
        intent.putExtra(Constants.KEYDATABUNDLE, b);
        mData.getActivity().startActivityForResult(intent, Constants.REQUESTCODEONE);
    }

    public void onActivityReturned(int requestCode, int resultCode, Intent intent) {
        Log.d("LOGTAG", "onActivityReturned ...");
        Log.d("LOGTAG", "  resultCode: " + resultCode);
        int value;
        if ( resultCode == Activity.RESULT_OK ) {
            switch ( requestCode ) {
                case Constants.REQUESTCODEONE:
                    mData.readIntentParametersOrSetDefaultValues(intent);
                    dataToGui();
                    break;
            }
        }
    }

}
