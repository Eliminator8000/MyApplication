package wip.simon.myapplication.activities.storage;



import android.view.View;
import wip.simon.myapplication.R;

public class ClickListener implements View.OnClickListener{

    private ApplicationLogic mApplicationLogic;

    public ClickListener(ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
    }

    @Override
    public void onClick(View view) {
        switch ( view.getId() ) {
            case R.id.idButtonInsert:
                mApplicationLogic.onButtonInsertClicked();
                break;
            case R.id.idButtonClear:
                mApplicationLogic.onButtonClearClicked();
                break;
        }
    }

}
