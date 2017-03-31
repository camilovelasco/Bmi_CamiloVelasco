package com.example.camilovelasco.bmi_camilovelasco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Historial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
    }
    public void salir(View v) {
        finish();
}
}
