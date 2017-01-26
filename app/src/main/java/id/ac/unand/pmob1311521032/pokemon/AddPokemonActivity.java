package id.ac.unand.pmob1311521032.pokemon;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ZikRi on 06/10/2016.
 */

public class AddPokemonActivity extends MainActivity implements View.OnClickListener {
    private Button buttonSubmit;
    private EditText edNama;
    private EditText edATK;
    private EditText edHP;
    private DBPokemon dataSource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addpokemon);

        buttonSubmit = (Button) findViewById(R.id.buttom_submit);
        buttonSubmit.setOnClickListener(this);
        edNama = (EditText) findViewById(R.id.nama_pokemon);
        edATK = (EditText) findViewById(R.id.atk_pokemon);
        edHP = (EditText) findViewById(R.id.hp_pokemon);
        dataSource = new DBPokemon(this);
        dataSource.open();
    }
    @Override
    public void onClick(View v) {
        String nama = null;
        String atk = null;
        String hp = null;
        @SuppressWarnings("unused")
        Pokemon pokemon = null;
        if(edNama.getText()!=null && edATK.getText()!=null && edHP.getText()!=null)
        {
            nama = edNama.getText().toString();
            atk = edATK.getText().toString();
            hp = edHP.getText().toString();
        }
        switch(v.getId())
        {
            case R.id.buttom_submit:
                pokemon = dataSource.createPokemon(nama, atk, hp);
                Toast.makeText(this, "Pokemon terindex dengan :\n" +
                        "Nama   :" + pokemon.getNama() +
                        "\nAtk   :" + pokemon.getATK() +
                        "\nHP :" + pokemon.getHP(), Toast.LENGTH_LONG).show();
                break;
        }

    }
}
