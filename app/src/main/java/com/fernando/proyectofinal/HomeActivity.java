package com.fernando.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.fernando.proyectofinal.AsyncTask.OrderTask;
import com.fernando.proyectofinal.AsyncTask.SearchTask;
import com.fernando.proyectofinal.AsyncTask.UpdateOrderTask;
import com.fernando.proyectofinal.controller.MemberCardAdapter;
import com.fernando.proyectofinal.controller.MemberController;
import com.fernando.proyectofinal.model.Member;
import com.fernando.proyectofinal.model.MemberStore;
import com.fernando.proyectofinal.model.Product;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private EditText memberCode;
    private TextView codeTextView;
    private RecyclerView lastVisited;
    private RecyclerView.Adapter rCAdapter;
    private RecyclerView.LayoutManager rCLayoutManager;
    private List<MemberStore> lastMemberVisited;
    private ImageButton searchButton;
    private String memberStoreToSearch;
    private MemberStore memberStoreFound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        findViews();


        //Recycler View

        //Start by doing provisional String Array
        //this method will always return an arraylist of memberStore
        lastMemberVisited = getLastVisited();


        //
        lastVisited.setHasFixedSize(true);
        rCLayoutManager = new LinearLayoutManager(this);
        lastVisited.setLayoutManager(rCLayoutManager);
        rCAdapter = new MemberCardAdapter(this, lastMemberVisited);
        lastVisited.setAdapter(rCAdapter);
        //

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Open the Associate screen
            Intent intent = new Intent(this, AssociateActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
            // Create Store

            if(!memberHasStore()){
                Intent intent = new Intent(this, CreateStoreActivity.class);
                startActivity(intent);
            }

        } else if (id == R.id.nav_slideshow) {
            checkOrders();

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void findViews(){
        memberCode = (EditText)findViewById(R.id.memberCode);
        codeTextView=(TextView)findViewById(R.id.codeTextView);
        lastVisited = (RecyclerView)findViewById(R.id.lastVisitedRecyclerView);
    }

    private ArrayList getLastVisited(){
        ArrayList lastVisitedArray;
        lastVisitedArray = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(3, "bag3", "bag3", 15.2, R.drawable.bag3, 2));
        ArrayList<Product> products1 = new ArrayList<>();
        products1.add(new Product(2, "bag2", "bag2", 27.8, R.drawable.bag2, 1));
        lastVisitedArray.add(new MemberStore("Maria", "La tienda de María ", R.drawable.kelvin,1,products));
        lastVisitedArray.add(new MemberStore("Juanita", "La tienda de Juanita ", R.drawable.marivi,2,products1));

        return lastVisitedArray;
    }

    public void searchCode(View view){
        memberStoreToSearch = memberCode.getText().toString();

        if(memberStoreToSearch.isEmpty()){
            Toast.makeText(this, "You need to insert a code to search", Toast.LENGTH_SHORT).show();
        }else{
            SearchTask search = new SearchTask(this);
            search.execute(1);
        }

    }

    public void checkOrders(){
        UpdateOrderTask updateOrderTask =new UpdateOrderTask(this);
        updateOrderTask.execute(1);
    }


    private boolean memberHasStore(){
        return false;
    }







}
