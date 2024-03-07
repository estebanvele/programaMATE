package com.esteban.programamate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextAngulo, editTextLado1, editTextLado2;
    private TextView textViewBienvenida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAngulo = findViewById(R.id.editTextAngulo);
        editTextLado1 = findViewById(R.id.editTextLado1);
        editTextLado2 = findViewById(R.id.editTextLado2);
        textViewBienvenida = findViewById(R.id.textViewBienvenida);

        findViewById(R.id.buttonCalcular).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String anguloStr = editTextAngulo.getText().toString();
                String lado1Str = editTextLado1.getText().toString();
                String lado2Str = editTextLado2.getText().toString();

                // Validación de entrada (combinada y mejorada)
                if (TextUtils.isEmpty(anguloStr) || TextUtils.isEmpty(lado1Str) || TextUtils.isEmpty(lado2Str)) {
                    Toast.makeText(MainActivity.this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
                    return;
                }

                double angulo = Double.parseDouble(anguloStr);
                double lado1 = Double.parseDouble(lado1Str);
                double lado2 = Double.parseDouble(lado2Str);

                // Cálculo de valores
                double coseno = Math.cos(angulo);
                double seno = Math.sin(angulo);
                double area = lado1 * lado2;
                double perimetro = 2 * lado1 + 2 * lado2;

                // Enviar datos a la actividad ResultadosActivity
                Intent intent = new Intent(MainActivity.this, ResultadosActivity.class);
                intent.putExtra("angulo", angulo);
                intent.putExtra("coseno", coseno);
                intent.putExtra("seno", seno);
                intent.putExtra("area", area);
                intent.putExtra("perimetro", perimetro);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Cambiar el texto de TextView en onResume()
        textViewBienvenida.setText("DIGITE LOS DATOS PARA CONTINUAR!");
    }
}
