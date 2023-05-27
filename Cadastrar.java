package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cadastrar extends AppCompatActivity implements View.OnClickListener {
    private TextView tx2;
    private Button bt, bt3, bt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        tx2 = (TextView) findViewById(R.id.cadastrar);

        bt = (Button) findViewById(R.id.bt);
        bt.setOnClickListener(this);
        bt3 = (Button) findViewById(R.id.bt3);
        bt3.setOnClickListener(this);
        bt4 = (Button) findViewById(R.id.bt4);
        bt4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view==bt){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        if (view==bt3){
            Intent i = new Intent(this, CadastrarParticipante.class);
            startActivity(i);
        }
        if (view==bt4){
            Intent i = new Intent(this, CadastrarAtividade.class);
            startActivity(i);
        }
    }
}