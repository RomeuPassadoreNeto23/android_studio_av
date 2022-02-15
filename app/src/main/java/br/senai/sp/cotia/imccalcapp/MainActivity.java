package br.senai.sp.cotia.imccalcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private EditText editPesso, editAltura;
    private TextView tvValor,tvClassificacao;
    private Button btCalcular, btLimpar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //referencia os componen
        editPesso = findViewById(R.id.edit_peso);
        editAltura = findViewById(R.id.edit_altura);
        btCalcular = findViewById(R.id.bt_calcular);
        btLimpar = findViewById(R.id.bt_limpar);
        tvValor = findViewById(R.id.valor);
        tvClassificacao = findViewById(R.id.clasifi);

        btCalcular.setOnClickListener(v -> {
            if (editPesso.getText().toString().isEmpty()){
                editPesso.setError(getString(R.string.Valida_peso));
                Toast.makeText(getBaseContext(), R.string.Valida_peso, Toast.LENGTH_SHORT).show();
            }else if(editAltura.getText().toString().isEmpty()){
                editAltura.setError(getString(R.string.Valida_altura));
                Toast.makeText(getBaseContext(), R.string.Valida_altura, Toast.LENGTH_SHORT).show();
            }else {
              double peso, alrura,imc;
              peso = Double.parseDouble(editPesso.getText().toString());
              alrura = Double.parseDouble(editAltura.getText().toString());
              imc = peso / ( alrura * alrura);




              if (imc < 16){
                  tvClassificacao.setText(R.string.margreza_abisoluta);
                  tvClassificacao.setBackgroundColor(getResources().getColor(R.color.vermelho));
              }else if(imc < 17){
                  tvClassificacao.setText(R.string.margreza_abismaul);
                  tvClassificacao.setBackgroundColor(getResources().getColor(R.color.vermelho_medio));

              }else if(imc < 18.5){
                  tvClassificacao.setText(R.string.margreza_animal);
                  tvClassificacao.setBackgroundColor(getResources().getColor(R.color.vermelho_claro));
              }else  if(imc < 25){
                  tvClassificacao.setText(R.string.normal);
                  tvClassificacao.setBackgroundColor(getResources().getColor(R.color.teal_200));

              }else  if(imc < 30){
                  tvClassificacao.setText(R.string.obesidade_grau1);
                  tvClassificacao.setBackgroundColor(getResources().getColor(R.color.vermelho_claro));


              }else if(imc < 35){
                  tvClassificacao.setText(R.string.obesidade_grau2);
                  tvClassificacao.setBackgroundColor(getResources().getColor(R.color.vermelho_medio));
              }else if(imc < 40){
                  tvClassificacao.setText(R.string.obesidade_grau3);
                  tvClassificacao.setBackgroundColor(getResources().getColor(R.color.vermelho_medio));
              }else {
                  tvClassificacao.setText(R.string.obesidade_grau4);
                  tvClassificacao.setBackgroundColor(getResources().getColor(R.color.vermelho));
              }

                tvValor.setText(String.format("Seu IMC é %5.2f", imc));


            }
        });
        btLimpar.setOnClickListener(b ->{
            tvClassificacao.setText(null);
            tvClassificacao.setBackgroundColor(getResources().getColor(R.color.fundo));
            tvValor.setText(null);
        });
    }
}