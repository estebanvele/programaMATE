package com.esteban.programamate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        TextView textViewAngulo = findViewById(R.id.textViewValorAngulo);
        TextView textViewCoseno = findViewById(R.id.textViewCoseno);
        TextView textViewSeno = findViewById(R.id.textViewSeno);
        TextView textViewArea = findViewById(R.id.textViewArea);
        TextView textViewPerimetro = findViewById(R.id.textViewPerimetro);

        // Recibir datos deL MainActivity
        Intent intent = getIntent();
        double angulo = intent.getDoubleExtra("angulo", 0.0);
        double coseno = intent.getDoubleExtra("coseno", 0.0);
        double seno = intent.getDoubleExtra("seno", 0.0);
        double area = intent.getDoubleExtra("area", 0.0);
        double perimetro = intent.getDoubleExtra("perimetro", 0.0);

        // Mostrar resultados
        textViewAngulo.setText(getString(R.string.angulo_resultado, "Ángulo:", angulo));
        textViewCoseno.setText(getString(R.string.coseno_resultado, "Coseno:", coseno));
        textViewSeno.setText(getString(R.string.seno_resultado, "Seno:", seno));
        textViewArea.setText(getString(R.string.area_resultado, "Área:", area));
        textViewPerimetro.setText(getString(R.string.perimetro_resultado, "Perímetro:", perimetro));
    }
}
