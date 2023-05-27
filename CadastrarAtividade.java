package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class CadastrarAtividade extends AppCompatActivity implements View.OnClickListener{
    private TextView cadastrar;
    private EditText nomeatividade, resposta, descricao;
    private Button button;
    ArrayList<String> arrayNomeAtividade, arrayResposta, arrayDescricao;
    private FileOutputStream out;
    private String pulaLinha= "\n";
    private String arquivo= "arquivo7.txt";
    private File file;
    private FileInputStream in;
    public int numeroCadastrado=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_atividade);

        cadastrar = (TextView) findViewById(R.id.cadastrar);

        nomeatividade= (EditText) findViewById(R.id.nomeatividade);
        resposta= (EditText) findViewById(R.id.resposta);
        descricao= (EditText) findViewById(R.id.nome);

        button = (Button) findViewById(R.id.bt);
        button.setOnClickListener(this);

        arrayNomeAtividade = new ArrayList<>();
        arrayResposta = new ArrayList<>();
        arrayDescricao = new ArrayList<>();
    }

    public void onClick(View view) {
        if (view==button){
            arrayNomeAtividade.add(nomeatividade.getText().toString());
            arrayResposta.add(resposta.getText().toString());
            arrayDescricao.add(descricao.getText().toString());
            try{
                if(nomeatividade.getText().toString() != ("") && resposta.getText().toString()!=("") && resposta.getText().toString() != ("")) {
                    out = openFileOutput(arquivo, MODE_APPEND);
                    out.write(arrayNomeAtividade.get(numeroCadastrado).getBytes());
                    out.write("#".getBytes());
                    out.write(arrayResposta.get(numeroCadastrado).getBytes());
                    out.write("##".getBytes());
                    out.write(arrayDescricao.get(numeroCadastrado).getBytes());
                    out.write("\n\n".getBytes());
                    out.close();
                }
                if(numeroCadastrado>=arrayNomeAtividade.size()){
                    numeroCadastrado=0;
                }else{
                    numeroCadastrado++;
                }
                out.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                cadastrar.setText("Erro na abertura!");
            } catch (IOException e) {
                e.printStackTrace();
                cadastrar.setText("Erro na gravação!");
            }
            Intent i = new Intent(this, Cadastrar.class);
            startActivity(i);
        }
    }
}