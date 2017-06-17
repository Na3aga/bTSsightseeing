package whitechurchapplication.sig.mvp.view.about;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import whitechurchapplication.sig.R;
import whitechurchapplication.sig.mvp.presenter.AboutContract;
import whitechurchapplication.sig.mvp.presenter.AboutPresenterImpl;
import whitechurchapplication.sig.mvp.view.main.MainActivity;

public class AboutBCerkvaActivity extends AppCompatActivity implements AboutContract.AboutView {

    private AboutContract.AboutPresenter aboutPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_bcerkva);
        ButterKnife.bind(this);

        }
        @OnClick(R.id.home1)
        protected void switch1() {
            Intent intent = new Intent(AboutBCerkvaActivity.this, MainActivity.class);
            startActivity(intent);

        }
        //aboutPresenter = new AboutPresenterImpl();
        //aboutPresenter.setView(this);
        //aboutPresenter.getNumberOfLocationsInDb();


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
