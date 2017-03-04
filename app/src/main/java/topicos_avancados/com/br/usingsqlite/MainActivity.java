package topicos_avancados.com.br.usingsqlite;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    private static final int ADD_ACTION_CODE = 1;
    private ContatoDatabaseHandler handler;
    private ContatoArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new ContatoDatabaseHandler(this);
        Button bAdd = (Button) findViewById(R.id.addContato);
        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ContatoAddActivity.class);
                startActivityForResult(i, ADD_ACTION_CODE);
            }

        });

        adapter = new ContatoArrayAdapter(this, handler.getContatos());
        setListAdapter(adapter);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == ADD_ACTION_CODE) {
            Contato contato = new Contato();
            contato.setNome(data.getExtras().getString(ContatoAddActivity.EXTRA_NOME));
            contato.setTelefone(data.getExtras().getString(ContatoAddActivity.EXTRA_TELEFONE));
            handler.addContato(contato);
            adapter.add(contato);
        }
    }
}
