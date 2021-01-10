package com.dmrem.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.dmrem.tictactoe.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void StartVsAI(View view){
        Snackbar snackbar = Snackbar.make(view, "Sorry, this is not yet implemented!", Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    public void StartVsHuman(View view){
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "Human");
        startActivity(intent);
    }
}