package topicos_avancados.com.br.usingsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int ADD_ACTION_CODE = 1;
    private ContatoDatabaseHandler handler;
    private ContatoArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new ContatoDatabaseHandler(this);
        Button bAdd = (Button) findViewById(R.id.add);
        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ContatoAddActivity.class);
                startActivityForResult(i, ADD_ACTION_CODE); }
                adapter = new ContatoArrayAdapter(this, getContatos());
                setListAdapter(adapter);
        }
}
