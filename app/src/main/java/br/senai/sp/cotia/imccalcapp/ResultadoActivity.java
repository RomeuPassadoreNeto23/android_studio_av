package br.senai.sp.cotia.imccalcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class ResultadoActivity extends AppCompatActivity {
    private ImageView imageVie;
    private String genero = "";
    private  double imc = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado2);
        //referecia a imageview
        imageVie = findViewById(R.id.image_view);

        //
        if (getIntent().hasExtra("imc")){
            imc = getIntent().getDoubleExtra("imc",0);
        }
        if (getIntent().hasExtra("genero")) {

            genero = getIntent().getStringExtra("genero");
        }
        if (genero.equals("masculino")){
            if(imc <= 21){
                imageVie.setImageResource(R.drawable.magro);
            }else if (imc <= 26){
                imageVie.setImageResource(R.drawable.brad);
            }else{
                imageVie.setImageResource(R.drawable.josoares);
            }
        }
        if (genero.equals("feminino")){
            if(imc <= 21){
                imageVie.setImageResource(R.drawable.olivia);
            }else if (imc <= 26){
                imageVie.setImageResource(R.drawable.agenlina);
            }else{
                imageVie.setImageResource(R.drawable.thais);
            }
        }

    }
}