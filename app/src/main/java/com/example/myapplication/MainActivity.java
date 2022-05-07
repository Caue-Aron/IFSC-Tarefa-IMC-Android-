package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView img;
    private EditText edtPeso, edtAltura;
    private TextView txtCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.img);
        edtPeso = findViewById(R.id.txtPeso);
        edtAltura = findViewById(R.id.txtAltura);
        txtCalc = findViewById(R.id.txtCalc);
    }

    public void OnCalcularClick(View v){
        float peso = Float.parseFloat(edtPeso.getText().toString());
        float altura = Float.parseFloat(edtAltura.getText().toString());

        float imc = peso/(altura*altura);
        String msg;

        if (imc < 18.5){
            msg = "Abaixo do peso";
            img.setImageResource(R.drawable.abaixopeso);
        }
        else if (imc < 24.9){
            msg = "Peso ideal";
            img.setImageResource(R.drawable.normal);
        }
        else if (imc < 29.9){
            msg = "Levemente acima do peso";
            img.setImageResource(R.drawable.sobrepeso);
        }
        else if (imc < 34.9){
            msg = "Obesidade I";
            img.setImageResource(R.drawable.obesidade1);
        }
        else if (imc < 39.9){
            msg = "Obesidade II (severa)";
            img.setImageResource(R.drawable.obesidade2);
        }
        else{
            msg = "Obesidade III (mórbida)";
            img.setImageResource(R.drawable.obesidade3);
        }

        txtCalc.setText("IMC Calculado: " + String.format("%.2f", imc) + "\n" + msg);
    }
}