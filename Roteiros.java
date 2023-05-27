package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Roteiros extends AppCompatActivity implements View.OnClickListener {
    private Button bt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roteiros);

        bt3 = (Button) findViewById(R.id.bt3);
        bt3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==bt3){
            Intent i= new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }
}