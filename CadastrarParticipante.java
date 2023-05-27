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

public class CadastrarParticipante extends AppCompatActivity implements View.OnClickListener{
    private TextView cadastrar;
    private EditText nome, endereco, cpf, idade, telefone;
    private Button button;
    ArrayList<String> arrayNome, arrayEndereco, arrayCpf, arrayIdade, arrayTelefone;
    private FileOutputStream out;
    private String pulaLinha= "\n";
    private String arquivo= "arquivo8.txt";
    private File file;
    private FileInputStream in;
    public int numeroCadastrado=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrarparticipante);

        cadastrar = (TextView) findViewById(R.id.cadastrar);

        nome= (EditText) findViewById(R.id.nome);
        endereco= (EditText) findViewById(R.id.endereco);
        cpf= (EditText) findViewById(R.id.cpf);
        idade= (EditText) findViewById(R.id.idade);
        telefone = (EditText) findViewById(R.id.telefone);

        button = (Button) findViewById(R.id.bt);
        button.setOnClickListener(this);

        arrayNome = new ArrayList<>();
        arrayEndereco = new ArrayList<>();
        arrayCpf = new ArrayList<>();
        arrayIdade = new ArrayList<>();
        arrayTelefone = new ArrayList<>();

    }

    @Override
    public void onClick(View view) {
        if (view==button){
            arrayNome.add(nome.getText().toString());
            arrayEndereco.add(endereco.getText().toString());
            arrayCpf.add(cpf.getText().toString());
            arrayIdade.add(idade.getText().toString());
            arrayTelefone.add(telefone.getText().toString());
            try{
                if(nome.getText().toString() != ("") && endereco.getText().toString()!=("") && cpf.getText().toString() != ("") && idade.getText().toString() != ("") && telefone.getText().toString() != ("")) {
                    out = openFileOutput(arquivo, MODE_APPEND);
                    out.write(arrayNome.get(numeroCadastrado).getBytes());
                    out.write("$".getBytes());
                    out.write(arrayEndereco.get(numeroCadastrado).getBytes());
                    out.write("$".getBytes());
                    out.write(arrayCpf.get(numeroCadastrado).getBytes());
                    out.write("$$".getBytes());
                    out.write(arrayIdade.get(numeroCadastrado).getBytes());
                    out.write("$$".getBytes());
                    out.write(arrayEndereco.get(numeroCadastrado).getBytes());
                    out.write("\n\n".getBytes());
                    out.close();
                }
                if(numeroCadastrado>=arrayNome.size()){
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