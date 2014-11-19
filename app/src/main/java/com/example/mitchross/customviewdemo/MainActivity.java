package com.example.mitchross.customviewdemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.mitchross.customviewdemo.views.CustomViewOne;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends ActionBarActivity implements CustomViewOne.CustomViewOneListener {

    @InjectView(R.id.custom_view_one_layout)
    protected CustomViewOne customViewOne;

    @OnClick(R.id.activity_button_one)
    protected void buttonOneClick()
    {
            customViewOne.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.activity_button_two)
    protected void buttonTwoClick()
    {
        //Being lazy and short cutting  "forcing: the view for now.
        customViewOne.setVisibility(View.VISIBLE);
        customViewOne.setText( " Hello World From Activity Button ");


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        customViewOne.setListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onButtonClicked(String message) {
        //Being lazy and short cutting  "forcing: the view for now.
        customViewOne.setVisibility(View.VISIBLE);
        customViewOne.setText( message );

    }
}
