package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tx1;
    private Button bt1, bt2, bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tx1 = (TextView) findViewById(R.id.tx1);

        bt1 = (Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(this);
        bt2 = (Button) findViewById(R.id.bt2);
        bt2.setOnClickListener(this);
        bt3 = (Button) findViewById(R.id.bt3);
        bt3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view==bt1){
            Intent i = new Intent(this, Listar.class);
            startActivity(i);
        }else if(view==bt2){
            Intent i = new Intent(this, Cadastrar.class);
            startActivity(i);
        }else if(view==bt3){
            Intent i = new Intent(this, Roteiros.class);
            startActivity(i);
        }
    }
}