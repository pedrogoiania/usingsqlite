package topicos_avancados.com.br.usingsqlite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by PedroPaulo on 02/03/17.
 */

public class ContatoAddActivity extends Activity {

    public static final String EXTRA_NOME = "contato.nome";
    public static final String EXTRA_TELEFONE = "contato.telefone";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);

        final EditText etNome = (EditText) findViewById(R.id.etNome);
        final EditText etTelefone = (EditText) findViewById(R.id.etTelefone);
        Button bOk = (Button) findViewById(R.id.bOk);
        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra(EXTRA_NOME, etNome.getText().toString());
                data.putExtra(EXTRA_TELEFONE, etTelefone.getText().toString());
                setResult(RESULT_OK, data);
                finish();
            }
        });
        Button bCancelar = (Button) findViewById(R.id.bCancelar);
        bCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });


    }
}
