package topicos_avancados.com.br.usingsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PedroPaulo on 02/03/17.
 */

public class ContatoDatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contatos";
    private static final String TABLE_CONTACTS = "contatos";

    private static final String KEY_ID = BaseColumns._ID;
    private static final String KEY_NAME = "nome";
    private static final String KEY_PH_NO = "telefone";

    public ContatoDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
                    + KEY_NAME + " TEXT," + KEY_PH_NO + " TEXT" + ")";

        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        onCreate(db);
    }

    public void addContato(Contato contato) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contato.getNome());
        values.put(KEY_PH_NO, contato.getTelefone());
        db.insert(TABLE_CONTACTS, null, values); db.close();
    }

    public void apagarContato(Contato contato) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?", new String[] {
                                                                    String.valueOf(contato.get_id())
                                                                });
        db.close();
    }

    public List<Contato> getContatos() {
        List<Contato> contactList = new ArrayList<Contato>();
        String selectQuery = "SELECT * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Contato contact = new Contato();
                contact.set_id(Integer.parseInt(cursor.getString(0)));
                contact.setNome(cursor.getString(1));
                contact.setTelefone(cursor.getString(2));
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        return contactList;
    }
}
