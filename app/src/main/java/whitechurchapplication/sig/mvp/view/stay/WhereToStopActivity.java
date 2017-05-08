package whitechurchapplication.sig.mvp.view.stay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.ButterKnife;
import whitechurchapplication.sig.R;
import whitechurchapplication.sig.mvp.presenter.MainContract;
import whitechurchapplication.sig.mvp.presenter.MainPresenterImpl;

public class WhereToStopActivity extends AppCompatActivity {
    MainContract.MainPresenter mainPresenter;


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_where_to_stop);
        ButterKnife.bind(this);
        mainPresenter = new MainPresenterImpl(this);
        mainPresenter.getLocationsByType("ресторан");
       mRecyclerView = (RecyclerView)findViewById(R.id.stopplaceRV);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        }}
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
       // mainPresenter = new MainPresenterImpl(this);
       // mainPresenter.getLocationsByType("ресторан");


