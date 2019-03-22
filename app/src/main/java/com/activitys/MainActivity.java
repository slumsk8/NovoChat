package com.activitys;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.novochat.R;
import com.fragments.LoginFragment;
import com.fragments.RegisterFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Novo Chat");
        setSupportActionBar(toolbar);

        mostrarFragmentLogin();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    /* Colocando eventos nos botões do menu.
     * Recebe um item do tipo MenuItem
     * getItemId recupera qual o id(botão) selecionado */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_logout:
                logoutUser();
                return true;
            case R.id.item_enter:
                mostrarFragmentLogin();
                return true;
            case R.id.item_add:
                mostrarFragmentRegister();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    /* Simulando um logout - sairei do app para essa simulação
     * Quando implementar o firebase conserto o logout */
    public void logoutUser(){
        finish();
    }


    public void mostrarFragmentLogin(){
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.flContainer, new LoginFragment(), "Login");
        transaction.commitAllowingStateLoss();
        toolbar.setTitle("Login");
    }

    public void mostrarFragmentRegister(){
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.flContainer, new RegisterFragment(), "Registrar");
        transaction.commitAllowingStateLoss();
        toolbar.setTitle("Registrar");
    }
}

