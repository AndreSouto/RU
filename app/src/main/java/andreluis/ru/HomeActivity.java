package andreluis.ru;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

//import android.support.v4.app.Fragment;

public class HomeActivity extends FragmentActivity {

    protected Button mDesjejumButton, mAlmocoButton, mJantarButton;
    protected ImageButton mInfoButton, mCardapioButton, mFavButton, mCredButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Context contexto = getApplicationContext(); //(??) --Necessario para funcionamento do toast


        String texto_toast = "Este é o cardápio";                           //Toast caso o mCardapioButton seja clicado
        int duracao = Toast.LENGTH_LONG;
        final Toast toast = Toast.makeText(contexto, texto_toast, duracao);


        mDesjejumButton = (Button) findViewById(R.id.desjejumButton);
        mAlmocoButton = (Button) findViewById(R.id.almocoButton);
        mJantarButton = (Button) findViewById(R.id.jantarButton);
        mCardapioButton = (ImageButton) findViewById(R.id.cardapioButton);
        mCredButton = (ImageButton) findViewById(R.id.creditoButton);
        mInfoButton = (ImageButton) findViewById(R.id.infoButton);
        mFavButton = (ImageButton) findViewById(R.id.favButton);


        View.OnClickListener listenerFav = new View.OnClickListener() {  // Ao clicar no botao de configurações

            public void onClick(View view) {
                startActivityFav(view);

            }

        };


        View.OnClickListener listenerInfo = new View.OnClickListener() {  // Ao clicar no botao de informações

            public void onClick(View view) {
                startActivityInfo(view);

            }

        };


        View.OnClickListener listenerCred = new View.OnClickListener() {  // Ao clicar no botao de créditos

            public void onClick(View view) {
                startActivityCredit(view);

            }

        };


        View.OnClickListener listenerCard = new View.OnClickListener() {  // Ao clicar no botao de cardápio

            public void onClick(View view) {
                toast.show();

            }

        };


        View.OnClickListener listenerDesjejum = new View.OnClickListener() {  // Ao clicar no botao Desjejum

            public void onClick(View view) {
                desjejumFragment(view);

            }

        };


        View.OnClickListener listenerAlmoco = new View.OnClickListener() {  // Ao clicar no botao Almoco

            public void onClick(View view) {
                almocoFragment(view);

            }
        };


        View.OnClickListener listenerJantar = new View.OnClickListener() {  // Ao clicar no botao Jantar

            public void onClick(View view) {
                 jantarFragment(view);

            }
        };


        mDesjejumButton.setOnClickListener(listenerDesjejum);
        mAlmocoButton.setOnClickListener(listenerAlmoco);
        mJantarButton.setOnClickListener(listenerJantar);
        mCardapioButton.setOnClickListener(listenerCard);
        mCredButton.setOnClickListener(listenerCred);
        mFavButton.setOnClickListener(listenerFav);
        mInfoButton.setOnClickListener(listenerInfo);


    }


    public void desjejumFragment(View view){

        ArrayList<HashMap<String, String>> hms =  new ArrayList<>();

        String[] atividades = new String[]{
                "Pão de queijo",
                "Sucrilhos Kelloggs",
                "Presunto",
                "Leite com nescau"};

        Integer imagens = R.drawable.starr;

        for(int i = 0; i < 4; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("texto", atividades[i]);
            hm.put("imagem", Integer.toString(imagens));

            hms.add(hm);
        }


        String[] from = new String[]{"texto","imagem"};

        int layout = R.layout.item_list;

        int[] to = new int[]{R.id.t1,R.id.i1};


        ListView lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(new SimpleAdapter(this, hms,layout, from, to));

    }

    public void almocoFragment(View view){

        ArrayList<HashMap<String, String>> hms =  new ArrayList<>();

        String[] atividades = new String[]{
                "Arroz branco",
                "Feijão preto",
                "Almôndega",
                "Lasanha",
                "Suco de Uva"};


        Integer imagens = R.drawable.starr;

        for(int i = 0; i < 4; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("texto", atividades[i]);
            hm.put("imagem", Integer.toString(imagens));

            hms.add(hm);
        }


        String[] from = new String[]{"texto","imagem"};

        int layout = R.layout.item_list;

        int[] to = new int[]{R.id.t1,R.id.i1};


        ListView lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(new SimpleAdapter(this, hms,layout, from, to));


    }

    public void jantarFragment(View view){

        ArrayList<HashMap<String, String>> hms =  new ArrayList<>();

        String[] atividades = new String[]{
                "Caçarola marinada(paleta)",
                "Cuzcuz vegetariano",
                "Feijoada",
                "Acelga e nabo com tomate",
                "Suco de Laranja",
                "Suco de Uva",
                "Brigadeiro"};


        Integer imagens = R.drawable.starr;

        for(int i = 0; i < 7; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("texto", atividades[i]);
            hm.put("imagem", Integer.toString(imagens));

            hms.add(hm);
        }


        String[] from = new String[]{"texto","imagem"};

        int layout = R.layout.item_list;

        int[] to = new int[]{R.id.t1,R.id.i1};


        ListView lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(new SimpleAdapter(this, hms,layout, from, to));

    }


    public void startActivityCredit(View view) {

        //Intent creditActivity = new Intent(this, HomeActivity.class);
        //startActivity(creditActivity);
    }

    public void startActivityInfo(View view) {

        Intent infoActivity = new Intent(this, InfoActivity.class);
        startActivity(infoActivity);
    }

    public void startActivityFav(View view) {

        Intent favActivity = new Intent(this, FavActivity.class);
        startActivity(favActivity);
    }


}