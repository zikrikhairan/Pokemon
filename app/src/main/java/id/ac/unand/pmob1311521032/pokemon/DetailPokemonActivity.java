package id.ac.unand.pmob1311521032.pokemon;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;

/**
 * Created by ZikRi on 06/10/2016.
 */

public class DetailPokemonActivity extends ListActivity implements OnItemLongClickListener{
    //inisialisasi kontroller
    private DBPokemon dataSource;
    private ArrayList<Pokemon> values;
    private Button editButton;
    private Button delButton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailpokemon);
        dataSource = new DBPokemon(this);
        dataSource.open();
        values = dataSource.getAllPokemon();
        ArrayAdapter<Pokemon> adapter = new ArrayAdapter<Pokemon>(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);

        ListView lvw = (ListView) findViewById(android.R.id.list);
        lvw.setOnItemLongClickListener(this);
    }
    public boolean onItemLongClick(final AdapterView<?> adapter, View v, int pos,
                                   final long id) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialogview);
        dialog.setTitle("Pilih Aksi");
        dialog.show();
        final Pokemon pokemon = (Pokemon) getListAdapter().getItem(pos);
        editButton = (Button) dialog.findViewById(R.id.button_edit_data);
        editButton.setOnClickListener(
                new OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        switchToEdit(pokemon.get_ID());
                        dialog.dismiss();
                    }
                }
        );
        return true;
    }
    //method untuk edit data
    public void switchToEdit(int id)
    {
        Pokemon pokemon = dataSource.getPokemon(id);
        Intent i = new Intent(this, EditPokemonActivity.class);
        Bundle bun = new Bundle();
        bun.putInt("id", pokemon.get_ID());
        bun.putString("nama", pokemon.getNama());
        bun.putInt("atk", pokemon.getATK());
        bun.putInt("hp", pokemon.getHP());
        i.putExtras(bun);
        finale();
        startActivity(i);
    }
    //method yang dipanggil ketika edit data selesai
    public void finale()
    {
        DetailPokemonActivity.this.finish();
        dataSource.close();
    }
    @Override
    protected void onResume() {
        dataSource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        dataSource.close();
        super.onPause();
    }
}
