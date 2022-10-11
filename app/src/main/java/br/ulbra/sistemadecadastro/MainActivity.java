package br.ulbra.sistemadecadastro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Registro> aRegistro;
    TelaPrincipal tela_Principal;
    TelaCadastroUsuario tela_cadastro;
    TelaListagemUsuarios tela_listagem;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        aRegistro = new ArrayList<Registro>();
        tela_Principal = new TelaPrincipal(this);
        tela_cadastro = new TelaCadastroUsuario(this, tela_Principal);
        tela_listagem = new TelaListagemUsuarios(this, tela_Principal);
        tela_Principal.setTela_cadastro(tela_cadastro);
        tela_Principal.setTela_listagem(tela_listagem);
        tela_Principal.CarregarTela();
    }

    public ArrayList<Registro> getRegistros(){
        return aRegistro;
    }

    public void ExibirMensagem(String msg){
        AlertDialog.Builder d = new AlertDialog.Builder(MainActivity.this);
        d.setTitle("Aviso");
        d.setMessage(msg);
        d.setNeutralButton("OK",null);
        d.show();

    }

}
