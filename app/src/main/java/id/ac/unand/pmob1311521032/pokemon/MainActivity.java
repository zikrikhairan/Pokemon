package id.ac.unand.pmob1311521032.pokemon;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import static java.security.AccessController.getContext;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bTambah;
    private Button bLihat;
    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.Adapter adapter2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bTambah = (Button) findViewById(R.id.button_tambah);
        bTambah.setOnClickListener(this);
        bLihat = (Button) findViewById(R.id.button_view);
        bLihat.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.button_tambah :
                Intent i = new Intent(this, AddPokemonActivity.class);
                startActivity(i);
                break;
            case R.id.button_view :
                Intent i2 = new Intent(this, DetailPokemonActivity.class);
                startActivity(i2);
                break;
        }
    }
}
