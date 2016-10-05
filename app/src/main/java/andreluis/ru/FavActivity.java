package andreluis.ru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class FavActivity extends AppCompatActivity {

    boolean favorites[] = new boolean[4];
    protected ImageButton mInfoButton, mCardapioButton, mFavButton, mCredButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);



        mCardapioButton = (ImageButton) findViewById(R.id.cardapioButton);
        mCredButton = (ImageButton) findViewById(R.id.creditoButton);
        mInfoButton = (ImageButton) findViewById(R.id.infoButton);
        mFavButton = (ImageButton) findViewById(R.id.favButton);



        View.OnClickListener listenerFav = new View.OnClickListener() {  // Ao clicar no botao de configurações

            public void onClick(View view) {

                Toast toast = Toast.makeText (FavActivity.this ,"Esta é a tela de favoritos", Toast.LENGTH_SHORT);
                toast.show();

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
                startActivityHome(view);


            }

        };


        mCardapioButton.setOnClickListener(listenerCard);
        mCredButton.setOnClickListener(listenerCred);
        mFavButton.setOnClickListener(listenerFav);
        mInfoButton.setOnClickListener(listenerInfo);


    }


    public void paletaFunc(View view) {
        Switch paletaSwitch = (Switch) findViewById(R.id.paletaSwitch);
        favorites[0] = paletaSwitch.isChecked();

        Toast toast = Toast.makeText ( this ,
                "paleta:" + paletaSwitch.isChecked() , Toast.LENGTH_SHORT );
        toast.show();
    }

    public void lasanhaFunc(View view) {
        Switch lasanhaSwitch = (Switch) findViewById(R.id.lasanhaSwitch);
        favorites[1] = lasanhaSwitch.isChecked();

        Toast toast = Toast.makeText ( this ,
                "lasanha:" + lasanhaSwitch.isChecked() , Toast.LENGTH_SHORT );
        toast.show();
    }

    public void almondegaFunc(View view) {
        Switch almondegaSwitch = (Switch) findViewById(R.id.almondegaSwitch);
        favorites[2] = almondegaSwitch.isChecked();

        Toast toast = Toast.makeText ( this ,
                "almondega:" + almondegaSwitch.isChecked() , Toast.LENGTH_SHORT );
        toast.show();
    }

    public void feijoadaFunc(View view) {
        Switch feijoadaSwitch = (Switch) findViewById(R.id.feijoadaSwitch);
        favorites[3] = feijoadaSwitch.isChecked();

        Toast toast = Toast.makeText ( this ,
                "feijoada:" + feijoadaSwitch.isChecked() , Toast.LENGTH_SHORT );
        toast.show();
    }




    public void startActivityCredit(View view) {

        //Intent creditActivity = new Intent(this, HomeActivity.class);
        //startActivity(creditActivity);
    }

    public void startActivityInfo(View view) {

        Intent infoActivity = new Intent(this, InfoActivity.class);
        startActivity(infoActivity);
    }

    public void startActivityHome(View view) {

        Intent homeActivity = new Intent(this, HomeActivity.class);
        startActivity(homeActivity);
    }

}