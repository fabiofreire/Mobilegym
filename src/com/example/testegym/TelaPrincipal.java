package com.example.testegym;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaPrincipal extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		carregaTelaPrincipal();
	}

	public void carregaTelaPrincipal(){
		setContentView(R.layout.tela_principal);
		Button btCadAluno = (Button) findViewById(R.id.btCadAluno);
		Button btInformacao = (Button) findViewById(R.id.btInformacao);

		btCadAluno.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				carregaCadastro();

			}
		});

		btInformacao.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				informacao();

			}
		});
	}
	
	public void carregaCadastro(){
		setContentView(R.layout.activity_main);
	}
	
	public void informacao(){
		setContentView(R.layout.tela_informacao);
	}
}
