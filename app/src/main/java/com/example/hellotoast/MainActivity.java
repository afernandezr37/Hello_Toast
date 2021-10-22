package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int contador =0;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState((savedInstanceState));
        savedInstanceState.putInt("contador", contador);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View bContador = findViewById(R.id.button_count);
        View bToast = findViewById(R.id.button_toast);
        if (savedInstanceState != null) {
            contador = savedInstanceState.getInt("contador", 0);
        }
        TextView textView = (TextView) findViewById(R.id.show_count);
        textView.setText(String.valueOf(contador));
        bContador.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                contador++;
                textView.setText(String.valueOf(contador));
            }
        });
        bToast.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), String.valueOf(contador), Toast.LENGTH_LONG).show();
            }
        });
    }


}