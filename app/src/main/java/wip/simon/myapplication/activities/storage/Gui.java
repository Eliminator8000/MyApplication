package wip.simon.myapplication.activities.storage;


import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import wip.simon.myapplication.R;

public class Gui {

    private Button mButtonInsert;
    private Button mButtonDelete;
    private ListView mListView;

    public Gui (Init activity) {
        activity.setContentView(R.layout.storage);

        mButtonInsert = (Button) activity.findViewById(R.id.idButtonInsert);
        mButtonDelete = (Button) activity.findViewById(R.id.idButtonClear);
        mListView = (ListView) activity.findViewById(R.id.idListview);
    }

    // getter to access views

    public Button getButtonInsert() {
        return mButtonInsert;
    }

    public Button getButtonDelete() {
        return mButtonDelete;
    }

    public ListView getListView() {
        return mListView;
    }

    // methods to change view attributes
    // ....

}
