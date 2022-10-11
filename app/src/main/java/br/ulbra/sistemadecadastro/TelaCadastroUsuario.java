package br.ulbra.sistemadecadastro;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelaCadastroUsuario {
    MainActivity act;
    EditText ednome, edendereco, edtelefone;
    Button btcadastrar, btcancelar;
    TelaPrincipal telaPrincipal;

    public TelaCadastroUsuario(MainActivity act, TelaPrincipal telaPrincipal) {
        this.act = act;
        this.telaPrincipal = telaPrincipal;
    }

    public void CarregarTela() {
        act.setContentView(R.layout.tela_cadastro);
        ednome = (EditText) act.findViewById(R.id.edNome);
        edendereco = (EditText) act.findViewById(R.id.edEndereco);
        edtelefone = (EditText) act.findViewById(R.id.edTel);
        btcancelar = (Button) act.findViewById(R.id.btCancelar2);
        btcadastrar = (Button) act.findViewById(R.id.btCadastrar2);
        btcadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogo = new AlertDialog.Builder(act);
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Cadastrar Usuário?");
                dialogo.setNegativeButton("Não", null);
                dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String nome = ednome.getText().toString();
                        String endereco = edendereco.getText().toString();
                        String telefone = edtelefone.getText().toString();
                        act.getRegistros().add(new Registro(nome, endereco, telefone));
                        act.ExibirMensagem("Cadastro Efetuado com Sucesso.");
                        telaPrincipal.CarregarTela();
                    }

                });
                dialogo.show();
            }
        });
        btcancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogo = new AlertDialog.Builder(act);
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Sair do Cadastro?");
                dialogo.setNegativeButton("Não", null);
                dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        telaPrincipal.CarregarTela();
                    }
                });
                dialogo.show();
            }
        });
    }
}