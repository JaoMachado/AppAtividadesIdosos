package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Listar extends AppCompatActivity implements View.OnClickListener{
    private Button bt, bt1;
    private String arquivoparticipantes= "arquivo8.txt";
    private String arquivoatividades= "arquivo7.txt";
    private File file;
    private FileInputStream in, in1;
    private LinearLayout l, l1;
    private TextView tx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        l = new LinearLayout(this);
        l.setOrientation(LinearLayout.VERTICAL);

        tx = (TextView)findViewById(R.id.textView);

        bt = (Button) findViewById(R.id.bt3);
        bt.setOnClickListener(this);
        bt1 = (Button) findViewById(R.id.button);
        bt1.setOnClickListener(this);

        LinearLayout l_layout1 = (LinearLayout) findViewById(R.id.linear_layout1);
        file = getFileStreamPath(arquivoparticipantes);
        String texto = new String();
        if(file.exists()){
            try {
                in = openFileInput(arquivoparticipantes);
                int tamanho = in.available();
                byte bytes[] = new byte[tamanho];
                in.read(bytes);
                texto = new String (bytes);
                String vetDados[];
                vetDados = texto.split("\n\n");

                String nomeParticipante[] = new String[vetDados.length];
                for(int i=0; i< vetDados.length;i++){
                    int posicao = vetDados[i].indexOf("$");
                    nomeParticipante[i] = vetDados[i].substring(0, posicao);
                }

                for(int i=0; i< nomeParticipante.length; i++){
                    Button btn = new Button(Listar.this);
                    btn.setText(nomeParticipante[i]);
                    btn.setTag(nomeParticipante[i]);
                    l.addView(btn);
                    btn.setOnClickListener(this);
                }

            }catch (IOException e) {
                e.printStackTrace();
            }
            }
        l_layout1.addView(l);

        l1 = new LinearLayout(this);
        l1.setOrientation(LinearLayout.VERTICAL);

        LinearLayout l_layout = (LinearLayout) findViewById(R.id.linear_layout);
        file = getFileStreamPath(arquivoatividades);
        String texto1 = new String();
        if(file.exists()){
            try {
                in1 = openFileInput(arquivoatividades);
                int tamanho1 = in1.available();
                byte bytes1[] = new byte[tamanho1];
                in1.read(bytes1);
                texto1 = new String (bytes1);
                String vetDados1[];
                //vetDados vai receber string grande contendo nome + resposta + descrição
                vetDados1 = texto1.split("\n\n");

                //criar um vetor de string somente para os nomes das atividades
                String nomeAtividade[] = new String[vetDados1.length];
                for(int i=0; i< vetDados1.length;i++){
                    int posiçao = vetDados1[i].indexOf("#");
                    nomeAtividade[i] = vetDados1[i].substring(0,posiçao);
                }

                for(int i=0; i< nomeAtividade.length; i++) {
                    Button btn1 = new Button(Listar.this);
                    btn1.setText(nomeAtividade[i]);
                    btn1.setTag(nomeAtividade[i]);
                    l1.addView(btn1);
                    btn1.setOnClickListener(this);
                }

            }catch (IOException e) {
                e.printStackTrace();
            }
        }

        l_layout.addView(l1);
    }

    @Override
    public void onClick(View view) {
        if(view==bt){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }else if(view==bt1){

        }else{
            Button b = (Button) view;
            tx.setText(b.getText().toString());
        }
    }
}