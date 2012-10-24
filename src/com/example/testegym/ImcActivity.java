package com.example.testegym;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.NumberPicker;

public class ImcActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        carregaImc();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_imc, menu);
        return true;
    }
    
    public void carregaImc(){
    	setContentView(R.layout.activity_imc);
//    	Button calcula_imc = (Button) findViewById(R.id.btcalcimc);
//    	calcula_imc.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				int peso_kg = R.id.numberPickerKg;
//				int peso_g = R.id.numberPickerGrama;
//				int altura_m = R.id.numberPickerMetros;
//				int altura_cm = R.id.numberPickerCm;
//				
//				float peso = peso_kg + peso_g/100;
//				float altura = altura_m + altura_cm/100;
//				
//				float imc = peso/(altura*altura);
//				
//			}
//		});
    }
}
