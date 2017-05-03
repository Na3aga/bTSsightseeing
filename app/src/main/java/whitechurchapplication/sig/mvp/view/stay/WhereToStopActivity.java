package whitechurchapplication.sig.mvp.view.stay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_where_to_stop);
        ButterKnife.bind(this);
        mRecyclerView = (RecyclerView)findViewById(R.id.stopplaceRV);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        }}
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
       // mainPresenter = new MainPresenterImpl(this);
       // mainPresenter.getLocationsByType("ресторан");


