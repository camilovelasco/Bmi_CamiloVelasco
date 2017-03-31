package com.example.camilovelasco.bmi_camilovelasco;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    private EditText p1,e1;
    private TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1=(EditText)findViewById(R.id.p1);
        e1=(EditText)findViewById(R.id.e1);
        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);

        p1=(EditText)findViewById(R.id.p1);
        e1=(EditText)findViewById(R.id.e1);
        SharedPreferences prefe=getSharedPreferences("datos", Context.MODE_PRIVATE);
        p1.setText(prefe.getString("Peso",""));
        e1.setText(prefe.getString("Altura",""));
    }
    public void acercade(View view) {
        Intent i = new Intent(this, AcercaDe.class );
        startActivity(i);
    }

    public void imc(View view) {
        Intent i = new Intent(this, Imc.class );
        startActivity(i);
    }

    public void historial(View view) {
        Intent i = new Intent(this, Historial.class );
        startActivity(i);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void calcular(View view)


    {

        SharedPreferences preferencias=getSharedPreferences("datos",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferencias.edit();
        editor.putString("Peso", p1.getText().toString());
        editor.putString("Altura", e1.getText().toString());
        editor.commit();

        String valor1=p1.getText().toString();
        Float valor2=Float.parseFloat(e1.getText().toString());
        double nro1=Integer.parseInt(valor1);
        double  nro2 = valor2;
        DecimalFormat df =new DecimalFormat("####.##");
        double form=nro1/(nro2*nro2);
        t1.setText(df.format(form));



        if (form < 16.0) {
            t2.setText(R.string.delgadez);
        }
        else if (form >= 40.0) {
            t2.setText(R.string.obesidad);
        }
        else if (form >= 16.0 && form <= 16.99) {
            t2.setText(R.string.dm);
        }
        else if (form >= 17.0 && form <= 18.49) {
            t2.setText(R.string.dl);
        }
        else if (form >= 18.5 && form <= 24.99)
        {
            t2.setText(R.string.feliz);
        }
        else
        {
            if (form >= 25.0 && form <= 29.99)
            {

                t2.setText(R.string.preobe);
            }
            else
            {
                if (form >= 30.0 && form <= 34.99)
                {
                    t2.setText(R.string.ol);
                }
                else
                {
                    if (form >= 35.0 && form <= 39.99)
                    {
                        t2.setText(R.string.om);

                    }
                }
            }
        }
    }
}
