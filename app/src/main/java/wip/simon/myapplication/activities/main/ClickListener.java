package wip.simon.myapplication.activities.main;

        import android.view.View;
        import wip.simon.myapplication.R;

public class ClickListener implements View.OnClickListener {

    private ApplicationLogic mApplicationLogic;

    public ClickListener(ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
    }

    @Override
    public void onClick(View view) {
        switch ( view.getId() ) {
            case R.id.idDisplay1:
                mApplicationLogic.onTextViewDisplay1Clicked();
                break;
            case R.id.idDisplay2:
                mApplicationLogic.onTextViewDisplay2Clicked();
                break;
            case R.id.idButtonZero:
                mApplicationLogic.onButtonZeroClicked();
                break;
            case R.id.idButtonOne:
                mApplicationLogic.onButtonOneClicked();
                break;
            case R.id.idButtonDelete:
                mApplicationLogic.onButtonDeleteClicked();
                break;
            case R.id.idButtonAdd:
                mApplicationLogic.onButtonAddClicked();
                break;
            case R.id.idButtonMult:
                mApplicationLogic.onButtonMultClicked();
                break;
            case R.id.idButtonSave:
                mApplicationLogic.onButtonSaveClicked();
                break;
            case R.id.idButtonRestore:
                mApplicationLogic.onButtonRestoreClicked();
                break;
        }
    }

}
