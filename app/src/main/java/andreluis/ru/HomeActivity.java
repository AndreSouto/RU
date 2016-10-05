package andreluis.ru;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

//import android.support.v4.app.Fragment;

public class HomeActivity extends FragmentActivity {

    protected Button mDesjejumButton, mAlmocoButton, mJantarButton;
    protected ImageButton mInfoButton, mCardapioButton, mFavButton, mCredButton;

    ListFragment df = new DesjejumFragment();         //Criação de objetos para troca de fragments
    ListFragment af = new AlmocoFragment();
    ListFragment jf = new JantarFragment();

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
        replaceFragment(df);

    }

    public void almocoFragment(View view){
        replaceFragment(af);

    }

    public void jantarFragment(View view){
        replaceFragment(jf);

    }


    private void replaceFragment(ListFragment listfragment) {

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.addToBackStack(null);

        transaction.replace(R.id.content,listfragment);

        transaction.commit();
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