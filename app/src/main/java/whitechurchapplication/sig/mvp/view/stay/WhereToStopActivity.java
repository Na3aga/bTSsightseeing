package whitechurchapplication.sig.mvp.view.stay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.ButterKnife;
import butterknife.OnClick;
import whitechurchapplication.sig.R;
import whitechurchapplication.sig.mvp.presenter.MainContract;
import whitechurchapplication.sig.mvp.presenter.MainPresenterImpl;
import whitechurchapplication.sig.mvp.view.about.AboutBCerkvaActivity;
import whitechurchapplication.sig.mvp.view.main.MainActivity;

public class WhereToStopActivity extends AppCompatActivity {
    MainContract.MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_where_to_stop);
        ButterKnife.bind(this);}

        @OnClick(R.id.buttonbeck2)
        protected void switch1() {
            Intent intent = new Intent(WhereToStopActivity.this, MainActivity.class);
            startActivity(intent);

        }
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
       // mainPresenter = new MainPresenterImpl(this);
       // mainPresenter.getLocationsByType("ресторан");
    }

