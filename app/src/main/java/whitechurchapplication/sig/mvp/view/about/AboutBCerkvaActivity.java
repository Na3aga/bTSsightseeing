package whitechurchapplication.sig.mvp.view.about;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import whitechurchapplication.sig.R;
import whitechurchapplication.sig.mvp.presenter.AboutContract;
import whitechurchapplication.sig.mvp.presenter.AboutPresenterImpl;

public class AboutBCerkvaActivity extends AppCompatActivity implements AboutContract.AboutView {

    private AboutContract.AboutPresenter aboutPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_bcerkva);
        aboutPresenter = new AboutPresenterImpl();
        aboutPresenter.setView(this);
        aboutPresenter.getNumberOfLocationsInDb();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (aboutPresenter != null) {
            aboutPresenter.setView(null);
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}
