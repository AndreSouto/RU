package andreluis.ru;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.HashMap;

//import android.support.v4.app.Fragment;

public class HomeActivity extends FragmentActivity {

    protected Button mDesjejumButton, mAlmocoButton, mJantarButton, mDesjejumButton2, mAlmocoButton2, mJantarButton2;
    protected ImageButton mInfoButton, mCardapioButton, mFavButton, mCredButton;
    ViewFlipper viewFlipper;
    private float lastX;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Context contexto = getApplicationContext(); //--Necessario para funcionamento do toast


        String texto_toast = "Este é o cardápio";                           //Toast caso o mCardapioButton seja clicado
        int duracao = Toast.LENGTH_LONG;
        final Toast toast = Toast.makeText(contexto, texto_toast, duracao);


        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);
        mDesjejumButton = (Button) findViewById(R.id.desjejumButton);
        mAlmocoButton = (Button) findViewById(R.id.almocoButton);
        mJantarButton = (Button) findViewById(R.id.jantarButton);
        mDesjejumButton2 = (Button) findViewById(R.id.desjejumButton2);
        mAlmocoButton2 = (Button) findViewById(R.id.almocoButton2);
        mJantarButton2 = (Button) findViewById(R.id.jantarButton2);
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
                desjejumList(view);

            }

        };


        View.OnClickListener listenerAlmoco = new View.OnClickListener() {  // Ao clicar no botao Almoco

            public void onClick(View view) {
                almocoList(view);

            }
        };


        View.OnClickListener listenerJantar = new View.OnClickListener() {  // Ao clicar no botao Jantar

            public void onClick(View view) {
                 jantarList(view);

            }
        };

        View.OnClickListener listenerDesjejum2 = new View.OnClickListener() {  // Ao clicar no botao Desjejum

            public void onClick(View view) {
                desjejumList2(view);

            }

        };


        View.OnClickListener listenerAlmoco2 = new View.OnClickListener() {  // Ao clicar no botao Almoco

            public void onClick(View view) {
                almocoList2(view);

            }
        };


        View.OnClickListener listenerJantar2 = new View.OnClickListener() {  // Ao clicar no botao Jantar

            public void onClick(View view) {
                jantarList2(view);

            }
        };

        mDesjejumButton2.setOnClickListener(listenerDesjejum2);
        mAlmocoButton2.setOnClickListener(listenerAlmoco2);
        mJantarButton2.setOnClickListener(listenerJantar2);
        mDesjejumButton.setOnClickListener(listenerDesjejum);
        mAlmocoButton.setOnClickListener(listenerAlmoco);
        mJantarButton.setOnClickListener(listenerJantar);
        mCardapioButton.setOnClickListener(listenerCard);
        mCredButton.setOnClickListener(listenerCred);
        mFavButton.setOnClickListener(listenerFav);
        mInfoButton.setOnClickListener(listenerInfo);


    }


    public void desjejumList(View view){

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

    public void almocoList(View view){

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

    public void jantarList(View view){

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

    public void desjejumList2(View view){

        ArrayList<HashMap<String, String>> hms =  new ArrayList<>();

        String[] atividades = new String[]{
                "Pão com presunto",
                "Cereal",
                "Queijo",
                "Leite com toddy"};

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


        ListView lv = (ListView) findViewById(R.id.list2);
        lv.setAdapter(new SimpleAdapter(this, hms,layout, from, to));

    }

    public void almocoList2(View view){

        ArrayList<HashMap<String, String>> hms =  new ArrayList<>();

        String[] atividades = new String[]{
                "Arroz integral",
                "Feijão marrom",
                "Peixe frito",
                "Lasanha",
                "Suco de Uva",
                "Coca-Cola"};


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


        ListView lv = (ListView) findViewById(R.id.list2);
        lv.setAdapter(new SimpleAdapter(this, hms,layout, from, to));


    }

    public void jantarList2(View view){

        ArrayList<HashMap<String, String>> hms =  new ArrayList<>();

        String[] atividades = new String[]{
                "Macarrão",
                "Molho de queijo",
                "Feijoada",
                "Beterraba",
                "Suco de Laranja",
                "Pepsi",
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


        ListView lv = (ListView) findViewById(R.id.list2);
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


    //handling screen swaps
    public boolean onTouchEvent(MotionEvent touchevent) {
        switch (touchevent.getAction()) {

            case MotionEvent.ACTION_DOWN: //initial starting location
                lastX = touchevent.getX();
                break;
            case MotionEvent.ACTION_UP: //final release location
                float currentX = touchevent.getX();

                //handling left to right screen swap
                if (lastX < currentX) {

                    //nao tem child -> break
                    if (viewFlipper.getDisplayedChild() == 0)
                        break;

                    //prox tela vem da esquerda
                    viewFlipper.setInAnimation(this, R.anim.slide_in_from_left);

                    //tela atual sai pela direita
                    viewFlipper.setOutAnimation(this, R.anim.slide_out_to_right);

                    //mostra prox tela
                    viewFlipper.showNext();
                }

                //right to left swap
                if (lastX > currentX) {

                    //if theres a child to the left -> break
                    if (viewFlipper.getDisplayedChild() == 1)
                        break;

                    //prox tela vem da direita
                    viewFlipper.setInAnimation(this, R.anim.slide_in_from_right);

                    //tela atual sai pela esquerda
                    viewFlipper.setOutAnimation(this, R.anim.slide_out_to_left);

                    //mostra tela anterior
                    viewFlipper.showPrevious();
                }
                break;
        }
        return false;
    }


}