package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.formulario.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLimpar.setOnClickListener(this);
        binding.btnExibir.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLimpar){
            //Toast.makeText(this,"Limpar",Toast.LENGTH_SHORT).show();

            // Limpar campos de tipo Texto
            binding.edtNome.setText("");
            binding.edtEmail.setText("");
            binding.edtTelefone.setText("");

            // Limpar campos de tipo Switch
            binding.swtNotificacao.setChecked(false);

            // Limpar campos de tipo RadioButton através do RadioGroup
            binding.rdgSexo.clearCheck();

            // Limpar campos de tipo CheckBox
            binding.chkCinema.setChecked(false);
            binding.chkEsporte.setChecked(false);
            binding.chkGastronomia.setChecked(false);
            binding.chkMusica.setChecked(false);
            binding.lblDados.setVisibility(View.INVISIBLE);

        }else if(v.getId() == R.id.btnExibir) {
            Toast.makeText(this, "Confirmar",Toast.LENGTH_LONG).show();
            binding.lblDados.setVisibility(View.VISIBLE);
            binding.txtNome.setText("Nome: " + binding.edtNome.getText().toString());
            binding.txtEmail.setText("Email: " + binding.edtEmail.getText().toString());
            binding.txtTelefone.setText("Telefone: " + binding.edtTelefone.getText().toString());
            if(binding.swtNotificacao.isChecked())
                binding.txtNotificacao.setText("Notificação: " + binding.swtNotificacao.getTextOn());

            else
                binding.txtNotificacao.setText("WhatsApp: " + binding.swtNotificacao.getTextOff());

            int idrdbselecionado = binding.rdgSexo.getCheckedRadioButtonId();
            if (idrdbselecionado > 0){
                RadioButton rdbselecionado = findViewById(idrdbselecionado);
                binding.txtSexo.setText("Sexo: " + rdbselecionado.getText().toString());
            }

            String pref ="";
            if(binding.chkCinema.isChecked())
                pref = binding.chkCinema.getText().toString();
            if(binding.chkEsporte.isChecked()) {
                pref += " ";
                pref += binding.chkEsporte.getText().toString();
            }
            if(binding.chkMusica.isChecked()) {
                pref += " ";
                pref += binding.chkMusica.getText().toString();
            }
            if(binding.chkGastronomia.isChecked()){
                pref += " ";
                pref += binding.chkGastronomia.getText().toString();
            }
            binding.txtPref.setText("Preferências: " + pref);
        }
    }
}