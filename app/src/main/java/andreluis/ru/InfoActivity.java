package andreluis.ru;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class InfoActivity extends AppCompatActivity {

    protected ImageButton mInfoButton, mCardapioButton, mConfigButton, mCredButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);


        Context contexto = getApplicationContext(); // Necessario para funcionamento do toast

        String texto_toast = "Esta é a tela de informações";              //Toast caso o mInfoButton seja clicado
        int duracao = Toast.LENGTH_LONG;
        final Toast toast = Toast.makeText(contexto, texto_toast, duracao);

        mCardapioButton = (ImageButton) findViewById(R.id.cardapioButton);
        mCredButton = (ImageButton) findViewById(R.id.creditoButton);
        mInfoButton = (ImageButton) findViewById(R.id.infoButton);
        mConfigButton = (ImageButton) findViewById(R.id.configButton);



        View.OnClickListener listenerConfig = new View.OnClickListener() {  // Ao clicar no botao de configurações

            public void onClick(View view) {
                startActivityConfig(view);

            }

        };


        View.OnClickListener listenerInfo = new View.OnClickListener() {  // Ao clicar no botao de informações

            public void onClick(View view) {
                toast.show();

            }

        };


        View.OnClickListener listenerCred = new View.OnClickListener() {  // Ao clicar no botao de créditos

            public void onClick(View view) {
                startActivityCredit(view);

            }

        };


        View.OnClickListener listenerCard = new View.OnClickListener() {  // Ao clicar no botao de cardápio

            public void onClick(View view) {
                startActivityCard(view);

            }

        };


        mCardapioButton.setOnClickListener(listenerCard);
        mCredButton.setOnClickListener(listenerCred);
        mConfigButton.setOnClickListener(listenerConfig);
        mInfoButton.setOnClickListener(listenerInfo);

    }


    public void startActivityCredit(View view) {

        //Intent creditActivity = new Intent(this, HomeActivity.class);
        //startActivity(creditActivity);
    }

    public void startActivityCard(View view) {

        Intent homeActivity = new Intent(this, HomeActivity.class);
        startActivity(homeActivity);
    }

    public void startActivityConfig(View view) {

        //Intent homeActivity = new Intent(this, HomeActivity.class);
        //startActivity(homeActivity);
    }


}
