package id.ac.unand.pmob1311521032.pokemon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZikRi on 06/10/2016.
 */
public class sqlite  extends SQLiteOpenHelper{
        public static final String TABLE_POKE = "pokemon";
        public static final String COLUMN_ID = "_ID";
        public static final String COLUMN_NAMA = "Nama";
        public static final String COLUMN_ATK = "ATK";
        public static final String COLUMN_HP = "HP";
        private static final String db_name ="1311521032.db";
        private static final int db_version=1;
        private static final String db_create = "create table "
                + TABLE_POKE + "("
                + COLUMN_ID +" integer primary key autoincrement, "
                + COLUMN_NAMA+ " varchar(50) not null, "
                + COLUMN_ATK+ " varchar(50) not null, "
                + COLUMN_HP+ " varchar(50) not null);";

        public sqlite(Context context) {
            super(context, db_name, null, db_version);
            // Auto generated
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(db_create);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(sqlite.class.getName(),"Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_POKE);
            onCreate(db);

        }
//
//    public void addPokemon(Pokemon pokemon) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_NAMA, pokemon.getNama());
//        values.put(COLUMN_ATK, pokemon.getATK());
//        values.put(COLUMN_HP, pokemon.getHP());
//
//        db.insert(TABLE_POKE, null, values);
//        db.close(); // Closing database connection
//    }
//
//    public Pokemon getpokemon(int id) {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(TABLE_POKE, new String[]{COLUMN_NAMA, COLUMN_ATK, COLUMN_HP}, COLUMN_ID + "=?",
//                new String[]{String.valueOf(id)}, null, null, null, null);
//        if (cursor != null)
//            cursor.moveToFirst();
//        Pokemon pokemon = new Pokemon();
//        return pokemon;
//    }
//    public List<Pokemon> getAllPokemon() {
//        List<Pokemon> pokedex = new ArrayList<Pokemon>();
//        String selectQuery = "SELECT  * FROM " + TABLE_POKE;
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//        if (cursor.moveToFirst()) {
//            do {
//                Pokemon pokemon = new Pokemon();
//                pokemon.setNama(cursor.getString(1));
//                pokemon.setATK(cursor.getInt(2));
//                pokemon.setHP(cursor.getInt(3));
//                pokedex.add(pokemon);
//            } while (cursor.moveToNext());
//        }
//
//        return pokedex;
//    }
//
//    public int updatePokemon(Pokemon pokemon, String id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        Log.e("UPDATE", " " + pokemon.get_ID() + " " + pokemon.getNama() + " " + pokemon.getATK() + " " + pokemon.getHP());
//        values.put(COLUMN_NAMA, pokemon.getNama());
//        values.put(COLUMN_ATK, pokemon.getATK());
//        values.put(COLUMN_HP, pokemon.getHP());
//        return db.update(TABLE_POKE, values, COLUMN_ID + " = ?",new String[]{id});
//    }
//
//    public void deletePokemon(Pokemon pokemon) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_POKE, COLUMN_ID + " = ?",
//                new String[]{String.valueOf(pokemon.get_ID())});
//        db.close();
//    }
//    public int getPokemonCount() {
//        String countQuery = "SELECT  * FROM " + TABLE_POKE;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//        cursor.close();
//        return cursor.getCount();
//    }
}
