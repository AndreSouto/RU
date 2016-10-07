package andreluis.ru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class FavActivity extends AppCompatActivity {

    protected ImageButton mInfoButton, mCardapioButton, mFavButton, mCredButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);
        Parse.initialize(new Parse.Configuration.Builder(this)
            .applicationId("BuDxTVLBouV1tIRCZU0g2yNuk361NZ4JOmBXvja4")
            .clientKey("wLDfm3Os2ypS6j62PqZzRgocNZwzMgRRZUKFzPYM")
            .server("https://parseapi.back4app.com")
        .build()
        );

        mCardapioButton = (ImageButton) findViewById(R.id.cardapioButton);
        mCredButton = (ImageButton) findViewById(R.id.creditoButton);
        mInfoButton = (ImageButton) findViewById(R.id.infoButton);
        mFavButton = (ImageButton) findViewById(R.id.favButton);



        View.OnClickListener listenerFav = new View.OnClickListener() {  // Ao clicar no botao de configurações

            public void onClick(View view) {
                Toast toast = Toast.makeText (FavActivity.this ,"Esta é a tela de favoritos " , Toast.LENGTH_SHORT);
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
        final Switch paletaSwitch = (Switch) findViewById(R.id.paletaSwitch);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Comida");

        query.getInBackground("UblMYZ8STV", new GetCallback<ParseObject>() {
            public void done(ParseObject paleta, ParseException e) {
                if (e == null) {
                    // Now let's update it with some new data. In this case, only cheatMode and score
                    // will get sent to the Parse Cloud. playerName hasn't changed.
                    paleta.put("favorito", paletaSwitch.isChecked());
                    paleta.saveInBackground();
                }
            }
        });

        Toast toast = Toast.makeText ( this ,
                "paleta:" + paletaSwitch.isChecked() , Toast.LENGTH_SHORT );
        toast.show();
    }

    public void lasanhaFunc(View view) {
        final Switch lasanhaSwitch = (Switch) findViewById(R.id.lasanhaSwitch);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Comida");

        query.getInBackground("dFKcBrE7iS", new GetCallback<ParseObject>() {
            public void done(ParseObject lasanha, ParseException e) {
                if (e == null) {
                    // Now let's update it with some new data. In this case, only cheatMode and score
                    // will get sent to the Parse Cloud. playerName hasn't changed.
                    lasanha.put("favorito", lasanhaSwitch.isChecked());
                    lasanha.saveInBackground();
                }
            }
        });

        Toast toast = Toast.makeText ( this ,
                "lasanha:" + lasanhaSwitch.isChecked() , Toast.LENGTH_SHORT );
        toast.show();
    }

    public void almondegaFunc(View view) {
        final Switch almondegaSwitch = (Switch) findViewById(R.id.almondegaSwitch);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Comida");

        query.getInBackground("y7G3Tpqyri", new GetCallback<ParseObject>() {
            public void done(ParseObject almondega, ParseException e) {
                if (e == null) {
                    // Now let's update it with some new data. In this case, only cheatMode and score
                    // will get sent to the Parse Cloud. playerName hasn't changed.
                    almondega.put("favorito", almondegaSwitch.isChecked());
                    almondega.saveInBackground();
                }
            }
        });

        Toast toast = Toast.makeText ( this ,
                "almondega:" + almondegaSwitch.isChecked() , Toast.LENGTH_SHORT );
        toast.show();
    }

    public void feijoadaFunc(View view) {
        final Switch feijoadaSwitch = (Switch) findViewById(R.id.feijoadaSwitch);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Comida");

        query.getInBackground("IycwfR2Cc1", new GetCallback<ParseObject>() {
            public void done(ParseObject feijoada, ParseException e) {
                if (e == null) {
                    // Now let's update it with some new data. In this case, only cheatMode and score
                    // will get sent to the Parse Cloud. playerName hasn't changed.
                    feijoada.put("favorito", feijoadaSwitch.isChecked());
                    feijoada.saveInBackground();
                }
            }
        });

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