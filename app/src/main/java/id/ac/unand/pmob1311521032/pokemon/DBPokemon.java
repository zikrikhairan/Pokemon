package id.ac.unand.pmob1311521032.pokemon;

import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
/**
 * Created by ZikRi on 06/10/2016.
 */

public class DBPokemon {
    private SQLiteDatabase database;

    private sqlite sqlite;

    private String[] allColumns = { sqlite.COLUMN_ID,
            sqlite.COLUMN_NAMA, sqlite.COLUMN_ATK,sqlite.COLUMN_HP};

    public DBPokemon(Context context)
    {
        sqlite = new sqlite(context);
    }
    public void open() throws SQLException {
        database = sqlite.getWritableDatabase();
    }
    public void close() {
        sqlite.close();
    }
    public Pokemon createPokemon(String nama, String atk, String hp) {

        ContentValues values = new ContentValues();
        values.put(sqlite.COLUMN_NAMA, nama);
        values.put(sqlite.COLUMN_ATK, atk);
        values.put(sqlite.COLUMN_HP, hp);
        long insertId = database.insert(sqlite.TABLE_POKE, null,
                values);
        Cursor cursor = database.query(sqlite.TABLE_POKE,
                allColumns, sqlite.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Pokemon newPokemon = cursorToPokemon(cursor);
        cursor.close();
        return newPokemon;
    }

    private Pokemon cursorToPokemon(Cursor cursor)
    {
        Pokemon pokemon = new Pokemon();
        Log.v("info", "The getINT "+cursor.getInt(0));
        Log.v("info", "The setLatLng "+cursor.getString(1)+","+cursor.getString(2));
        pokemon.set_ID(cursor.getInt(0));
        pokemon.setNama(cursor.getString(1));
        pokemon.setATK(cursor.getInt(2));
        pokemon.setHP(cursor.getInt(3));
        return pokemon;
    }
    public ArrayList<Pokemon> getAllPokemon() {
        ArrayList<Pokemon> listPokemon = new ArrayList<Pokemon>();
        Cursor cursor = database.query(sqlite.TABLE_POKE,
                allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Pokemon pokemon = cursorToPokemon(cursor);
            listPokemon.add(pokemon);
            cursor.moveToNext();
        }
        cursor.close();
        return listPokemon;
    }
    public Pokemon getPokemon(int id)
    {
        Pokemon pokemon = new Pokemon();
        Cursor cursor = database.query(sqlite.TABLE_POKE, allColumns, "_id ="+id, null, null, null, null);
        cursor.moveToFirst();
        pokemon = cursorToPokemon(cursor);
        cursor.close();
        return pokemon;
    }
    public void updatePokemon(Pokemon pokemon)
    {
        String strFilter = "_id=" + pokemon.get_ID();
        ContentValues args = new ContentValues();
        args.put(sqlite.COLUMN_NAMA, pokemon.getNama());
        args.put(sqlite.COLUMN_ATK, pokemon.getATK());
        args.put(sqlite.COLUMN_HP, pokemon.getHP() );
        database.update(sqlite.TABLE_POKE, args, strFilter, null);
    }
}
