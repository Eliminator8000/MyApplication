package wip.simon.myapplication.activities.storage;


        import android.view.View;
        import android.widget.AdapterView;

public class ListItemClickListener implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private ApplicationLogic mApplicationLogic;

    ListItemClickListener(ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        mApplicationLogic.onListItemClicked(position);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
        mApplicationLogic.onListItemLongClicked(position);
        return true; // handle this click and don't propagate it
    }

}
