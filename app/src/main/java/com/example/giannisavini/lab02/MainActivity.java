package com.example.giannisavini.lab02;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lsvsStates;
    private TextView txtClickedItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Creazione dei riferimento con gli elementi della view tramite l'id univoco assegnatoli
        lsvsStates = (ListView) findViewById(R.id.lsv_states);
        //List<State> states = new ArrayList<>();
        String[] states = {"Italia", "Regno Unito", "Francia", "Germania", "Spagana", "Svizzera",
                            "Belgio", "Portogallo", "Austria", "Norvegia", "Svezia", "Finlandia"};
        /**
         * Creazione di un'istanza della classe ArrayAdapter. Tramite il costruttore vengono passati alla classe il riferimento all'activity
         * (tramite la parola chiave this), il nome del layout che definirà l'interfaccia di una singola cella, l'id della TextView all'interno
         * del suddetto layout che si occuperà della presentazione della stringa, e la collezzione di stringhe da presentare.
         */
        ArrayAdapter<String> stateAdapter = new ArrayAdapter<>(this, R.layout.list_item_state ,R.id.txv_state, states);
        //L'adapter appena creato viene passato alla ListView tramite il metodo apposito
        lsvsStates.setAdapter(stateAdapter);
        // Evento base di un'AdapterView, serve a gestire il click su un singolo elemento della stessa.
        lsvsStates.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /**
                 * Recupero l'oggetto corrispondente alla cella cliccata (Oggetto nell'adapterView corrispondente alla
                 * posiozione position) ed effettuo una conversione esplicita verso la classe a cui appartiene (String).
                 */
                String itemClicked = (String) parent.getItemAtPosition(position);
                /**
                 * Costrutto per generare un classico Toast...I parametri del metodo makeText sono:
                 * -1) Il riferimento all'activity (MainActivity.this),
                 * -2) Il Testo (Stinga) da mostrare all'utente,
                 * -3) Una costante che indica il tempo di durata del Toast.
                 * per mostrarlo richiamare infine il metodo show();
                 *
                 */
                Toast.makeText(MainActivity.this, itemClicked, Toast.LENGTH_SHORT).show();
            }
        });

        lsvsStates.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String itemClicked = (String) parent.getItemAtPosition(position);
                /**
                 * Costrutto per la creazione di un AlertDialog. Tramite la sottoclasse Builder è possibile definire diversi aspetti del dialog.
                 * Le proprietà solitamente definite sono il titolo e il messaggio da mostrare all'utente.
                 * E' inoltre possibile avere dei bottoni per permettere all'utente di interagire con il dialog. I bottoni possono essere definiti
                 * "positivi" o "negativi"; in base a questa classificazione il sistema adotterà delle particolari scelte grafice e strutturali.
                 * Per ogni bottone è definibile il testo da mostrare al suo interno, ed eventualmente un oggetto di tipo OnClickListener, per poter
                 * intercettare il click dell'utente sul bottone stesso.
                 */
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Long Click!")
                        .setMessage("Hai premuto a lungo la cella " + itemClicked)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "E' stato cliccato il bottone OK", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("Annulla", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "E' stato cliccato il bottone Annulla", Toast.LENGTH_LONG).show();
                            }
                        }).show();
                return true;
            }
        });

    }
}
