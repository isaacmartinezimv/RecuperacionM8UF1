package com.example.isaac.recum8uf1;

import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        FragmentTalleres.OnFragmentInteractionListener,
        FragmentHacerReserva.OnFragmentInteractionListener,
        FragmentVerReservas.OnFragmentInteractionListener,
        FragmentWellcome.OnFragmentInteractionListener {

    Toolbar toolbar;  // Declaramos una variable de tipo toolbar

    //Declaramos fragments
    FragmentWellcome wellcomeScreen;
    FragmentTalleres talleresMenu;
    FragmentHacerReserva hacerReserva;
    FragmentVerReservas verReservas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //asociar variables a un nuevo fragment
        wellcomeScreen = new FragmentWellcome();
        talleresMenu = new FragmentTalleres();
        hacerReserva = new FragmentHacerReserva();
        verReservas = new FragmentVerReservas();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragments, wellcomeScreen).commit();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (item.getItemId()){
            case R.id.menuPlatosID: // Este es el ID que asociamos en el archivo main_menu.xml
                transaction.replace(R.id.contenedorFragments, talleresMenu);
                break;
            case R.id.menuHacerReservaID:
                transaction.replace(R.id.contenedorFragments, verReservas);
                break;
            case R.id.menuVerReservaID:
                transaction.replace(R.id.contenedorFragments, hacerReserva);
                break;
        }
        transaction.commit();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
