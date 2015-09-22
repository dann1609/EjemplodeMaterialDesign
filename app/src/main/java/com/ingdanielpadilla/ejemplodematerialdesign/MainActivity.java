package com.ingdanielpadilla.ejemplodematerialdesign;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    String SELECTED_ITEM_ID="SELECTED_ITEM_ID";
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mdrawerToggle ;
    Integer mSelectedId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(mToolbar);

        NavigationView mNavigationView =(NavigationView)findViewById(R.id.main_drawer);
        mNavigationView.setNavigationItemSelectedListener(this);

        mDrawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);
        mdrawerToggle =new ActionBarDrawerToggle(this,mDrawerLayout,mToolbar,R.string.drawer_open,R.string.drawer_close);
        mDrawerLayout.setDrawerListener(mdrawerToggle);
        mdrawerToggle.syncState();

        mSelectedId= savedInstanceState == null ? R.id.navigation_item_1 : savedInstanceState.getInt(SELECTED_ITEM_ID);

        navigate(mSelectedId);


    }

    @Override
    public void onSaveInstanceState(Bundle outState,PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SELECTED_ITEM_ID,mSelectedId);

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
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        menuItem.setChecked(true);
        mSelectedId = menuItem.getItemId();
        navigate(mSelectedId);
        return true;
    }

    private void navigate(int selected){
        Intent intent=null;
        if(selected == R.id.navigation_item_1){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this,SecondActivity.class);
            startActivity(intent);
        }
    }
}
