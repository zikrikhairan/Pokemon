package id.ac.unand.pmob1311521032.pokemon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ZikRi on 06/10/2016.
 */

public class EditPokemonActivity extends MainActivity implements View.OnClickListener {
    private DBPokemon dataSource;

    private Integer id;
    private String nama;
    private Integer atk;
    private Integer hp;
    private EditText edNama;
    private EditText edATK;
    private EditText edHP;
    private TextView txId;
    private Button btnSave;
    private Button btnCancel;
    private Pokemon pokemon;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editpokemon);
        edNama = (EditText) findViewById(R.id.editText_nama);
        edATK = (EditText) findViewById(R.id.editText_atk);
        edHP = (EditText) findViewById(R.id.editText_hp);
        txId = (TextView) findViewById(R.id.text_id_pokemon);
        dataSource = new DBPokemon(this);
        dataSource.open();
        Bundle bun = this.getIntent().getExtras();
        id = bun.getInt("id");
        atk = bun.getInt("atk");
        hp = bun.getInt("hp");
        nama = bun.getString("nama").toString();
        txId.append(String.valueOf(id));
        edNama.setText(nama);
        edATK.setText(String.valueOf(atk));
        edHP.setText(String.valueOf(hp));
        btnSave = (Button) findViewById(R.id.button_save_update);
        btnSave.setOnClickListener(this);
        btnCancel = (Button) findViewById(R.id.button_cancel_update);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch(v.getId())
        {
            case R.id.button_save_update :
                pokemon = new Pokemon();
                pokemon.set_ID(Integer.valueOf(java.lang.Long.toString(id)));
                pokemon.setNama(edNama.getText().toString());
                pokemon.setATK(Integer.valueOf(edATK.getText().toString()));
                pokemon.setHP(Integer.valueOf(edHP.getText().toString()));
                dataSource.updatePokemon(pokemon);
                Intent i = new Intent(this, DetailPokemonActivity.class);
                startActivity(i);
                EditPokemonActivity.this.finish();
                dataSource.close();
                break;
            case R.id.button_cancel_update :
                finish();
                dataSource.close();
                break;
        }
    }
}
