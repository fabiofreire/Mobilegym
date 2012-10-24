package com.example.testegym;

import java.util.ArrayList;
import java.util.ListIterator;

import android.os.Bundle;
import android.os.Message;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private ArrayAdapter<Aluno> adapter;
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	private Aluno aluno = new Aluno();
	private EditText ednome, edendereco, edtelefone, edobjetivo;
	private ListIterator<Aluno> iterator;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		carregaCadastro();
		adapter = new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, alunos);
		iterator = alunos.listIterator();
	}

	public void carregaCadastro(){
		setContentView(R.layout.activity_main);
		Button btnovo = (Button) findViewById(R.id.btnovo);
		Button btcadastrados = (Button) findViewById(R.id.btcadastrados);
		Button btImc = (Button) findViewById(R.id.btcalcimc);
		
		btnovo.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				carregaCadastroAluno();

			}
		});

		btcadastrados.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				listagemCadastrados();

			}
		});
		
		btImc.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, ImcActivity.class);
				startActivity(intent);
			}
		});
		
	}
	
	public void carregaCadastroAluno(){
		setContentView(R.layout.cadastro_aluno);
		
		Button btconfirma = (Button) findViewById(R.cadastro.btconfirma);
		Button btcancelar = (Button) findViewById(R.cadastro.btcancelar);
		
		btconfirma.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ednome = (EditText) findViewById(R.cadastro.ednome);
				edendereco = (EditText) findViewById(R.cadastro.edendereco);
				edtelefone = (EditText) findViewById(R.cadastro.edtelefone);
				edobjetivo = (EditText) findViewById(R.cadastro.edobjetivo);
				
				aluno.setNome(ednome.getText().toString());
				aluno.setEndereco(edendereco.getText().toString());
				aluno.setTelefone(edtelefone.getText().toString());
				aluno.setObjetivo(edobjetivo.getText().toString());

				alunos.add(aluno);
				adapter.notifyDataSetChanged();
				
				AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).create();
				alertDialog.setTitle("Cadastro realizado");
				alertDialog.setMessage("Cadastro realizado com sucesso");
				carregaCadastro();

			}
		}); 

		btcancelar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				carregaCadastro();
			}
		});
	}

	public void listagemCadastrados(){
		
		
		if(alunos.isEmpty()){
			carregaCadastro();
			return;
		}
		
		setContentView(R.layout.list_aluno);
		TextView txtnome = (TextView) findViewById(R.cadastrados.txtnome);
		TextView txtendereco = (TextView) findViewById(R.cadastrados.txtendereco);
		TextView txttelefone = (TextView) findViewById(R.cadastrados.txttelefone);
		TextView txtobjetivo = (TextView) findViewById(R.cadastrados.txtobjetivo);
			
		
		Button btmenu = (Button) findViewById(R.cadastrados.btmenu);
		Button btavancar = (Button) findViewById(R.cadastrados.btavancar);
		Button btvoltar = (Button) findViewById(R.cadastrados.btvoltar);
		
		txtnome.setText(alunos.get(0).getNome());
		txtendereco.setText(alunos.listIterator().next().getEndereco());
		txttelefone.setText(alunos.listIterator().next().getTelefone());
		txtobjetivo.setText(alunos.listIterator().next().getObjetivo());
		
		btmenu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				carregaCadastro();
			}
		});
		
		btvoltar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(iterator.hasPrevious()){
					Aluno prev = iterator.previous();
					
					TextView txtnome = (TextView) findViewById(R.cadastrados.txtnome);
					TextView txtendereco = (TextView) findViewById(R.cadastrados.txtendereco);
					TextView txttelefone = (TextView) findViewById(R.cadastrados.txttelefone);
					TextView txtobjetivo = (TextView) findViewById(R.cadastrados.txtobjetivo);
					
					txtnome.setText(alunos.listIterator().next().getEndereco());
					txtendereco.setText(prev.getEndereco());
					txttelefone.setText(prev.getTelefone());
					txtobjetivo.setText(prev.getObjetivo());
				}
				
			}
		});
		
		btavancar.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				if(iterator.hasNext()){
					Aluno next = iterator.next();

					TextView txtnome = (TextView) findViewById(R.cadastrados.txtnome);
					TextView txtendereco = (TextView) findViewById(R.cadastrados.txtendereco);
					TextView txttelefone = (TextView) findViewById(R.cadastrados.txttelefone);
					TextView txtobjetivo = (TextView) findViewById(R.cadastrados.txtobjetivo);

					txtnome.setText(next.getNome());
					txtendereco.setText(next.getEndereco());
					txttelefone.setText(next.getTelefone());
					txtobjetivo.setText(next.getObjetivo());

				}

			}
		});
	}
}
