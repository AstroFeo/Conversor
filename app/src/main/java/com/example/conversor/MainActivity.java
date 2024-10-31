package com.example.conversor;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button calcular;
    private TextView resultado;
    private EditText celsius, fahrenheit;
    private double inputC, inputF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        calcular = findViewById(R.id.calcular);
        resultado = findViewById(R.id.resultado);
        celsius = findViewById(R.id.editCelsius);
        fahrenheit = findViewById(R.id.editFahrenheit);

        calcular.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if(!celsius.getText().toString().isEmpty()) {
                    inputC = Double.parseDouble(celsius.getText().toString());
                }
                if(!fahrenheit.getText().toString().isEmpty()) {
                    inputF = Double.parseDouble(fahrenheit.getText().toString());
                }

                if(celsius.getText().toString().isEmpty() && fahrenheit.getText().toString().isEmpty()) {
                    resultado.setText(0);
                }else if(!celsius.getText().toString().isEmpty() && !fahrenheit.getText().toString().isEmpty()){
                    resultado.setText("No puedes los dos a la vez");
                }else if (celsius.getText().toString().isEmpty()) {
                    inputF = (inputF - 32) * 5 / 9;
                    resultado.setText(inputF+" ºC");
                }else if (fahrenheit.getText().toString().isEmpty()) {
                    inputC = (inputC * 9 / 5) + 32;
                    resultado.setText(inputC+" ºF");
                }
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}