package wip.simon.myapplication.activities.main;

        import android.widget.Button;
        import android.widget.TextView;
        import wip.simon.myapplication.R;


public class Gui {

    private TextView mTextViewDisplay1;
    private TextView mTextViewDisplay2;
    private Button mButtonZero;
    private Button mButtonOne;
    private Button mButtonDelete;
    private Button mButtonAdd;
    private Button mButtonMult;
    private Button mButtonSave;
    private Button mButtonRestore;

    public Gui (Init activity) {
        activity.setContentView(R.layout.main);

        mTextViewDisplay1 = (TextView) activity.findViewById(R.id.idDisplay1);
        mTextViewDisplay2 = (TextView) activity.findViewById(R.id.idDisplay2);
        mButtonZero = (Button) activity.findViewById(R.id.idButtonZero);
        mButtonOne = (Button) activity.findViewById(R.id.idButtonOne);
        mButtonDelete = (Button) activity.findViewById(R.id.idButtonDelete);
        mButtonAdd = (Button) activity.findViewById(R.id.idButtonAdd);
        mButtonMult = (Button) activity.findViewById(R.id.idButtonMult);
        mButtonSave = (Button) activity.findViewById(R.id.idButtonSave);
        mButtonRestore = (Button) activity.findViewById(R.id.idButtonRestore);
    }

    // getter to access views

    public TextView getTextViewDisplay1() {
        return mTextViewDisplay1;
    }

    public TextView getTextViewDisplay2() {
        return mTextViewDisplay2;
    }

    public Button getButtonZero() {
        return mButtonZero;
    }

    public Button getButtonOne() {
        return mButtonOne;
    }

    public Button getButtonDelete() {
        return mButtonDelete;
    }

    public Button getButtonAdd() {
        return mButtonAdd;
    }

    public Button getButtonMult() {
        return mButtonMult;
    }

    public Button getButtonSave() {
        return mButtonSave;
    }

    public Button getButtonRestore() {
        return mButtonRestore;
    }


    // methods to change view attributes

    // ....

}
