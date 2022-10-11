package br.ulbra.sistemadecadastro;

import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaListagemUsuarios {
    MainActivity act;
    TelaPrincipal tela_principal;
    Button btAnterior, btProximo, btFechar;
    TextView txtNome, txtTelefone, txtEndereco, txtStatus;
    int index;


    public TelaListagemUsuarios(MainActivity act, TelaPrincipal tela_principal) {
        this.act = act;
        this.tela_principal = tela_principal;
        index = 0;
    }

    public void CarregarTela() {
        if (act.getRegistros().size() == 0) {
            (new AlertDialog.Builder(act)).setTitle("Aviso")
                    .setMessage("Não existe nenhum usuário cadastrado.")
                    .setNeutralButton("OK", null).show();
            return;
        }
        act.setContentView(R.layout.tela_listagem);
        btAnterior = (Button) act.findViewById(R.id.Anterior);
        btProximo = (Button) act.findViewById(R.id.Proximo);
        btFechar = (Button) act.findViewById(R.id.Fechar);
        txtNome = (TextView) act.findViewById(R.id.txtNome3);
        txtEndereco = (TextView) act.findViewById(R.id.txtEndereco3);
        txtTelefone = (TextView) act.findViewById(R.id.txtTelefone3);
        txtStatus = (TextView) act.findViewById(R.id.txtStatus3);
        PreencheCampos(index);


        btAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index > 0) {
                    index--;
                    PreencheCampos(index);
                    AtualizaStatus(index);
                }
            }
        });

        btProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index < act.getRegistros().size() - 1) {
                    index++;
                    PreencheCampos(index);
                    AtualizaStatus(index);
                }
            }});

                    btFechar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            tela_principal.CarregarTela();
                        }
                    });

                }

                private void PreencheCampos ( int idx){
                    txtNome.setText(act.getRegistros().get(idx).getNome());
                    txtEndereco.setText(act.getRegistros().get(idx).getEndereco());
                    txtTelefone.setText(act.getRegistros().get(idx).getTelefone());
                }

                private void AtualizaStatus ( int idx){
                    int total = act.getRegistros().size();
                    txtStatus.setText("Registros: " + (idx + 1) + "/" + total);
                }

            }

