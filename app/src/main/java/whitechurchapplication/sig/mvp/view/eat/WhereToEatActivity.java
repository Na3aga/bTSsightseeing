package whitechurchapplication.sig.mvp.view.eat;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import whitechurchapplication.sig.R;
import whitechurchapplication.sig.mvp.presenter.WhereToEatContract;
import whitechurchapplication.sig.mvp.presenter.WhereToEatPresenterImpl;

public class WhereToEatActivity extends AppCompatActivity implements WhereToEatContract.WhereToEatView {
    private WhereToEatContract.WhereToEatPresenter whereToEatPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_where_to_eat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        whereToEatPresenter = new WhereToEatPresenterImpl();
        whereToEatPresenter.setView(this);
        whereToEatPresenter.getNumberOfLocationsInDb();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (whereToEatPresenter != null) {
            whereToEatPresenter.setView(null);
        }
    }

    @Override
    public void showMessage(String message) {

    }
}


