package andreluis.ru;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ViewFlipper;

/**
 * Created by Felipe on 04/10/2016.
 */

public class InfoActivity extends AppCompatActivity {

    protected ImageButton mInfoButton, mCardapioButton, mFavButton, mCredButton;
    protected ImageButton setaEsquerda;
    protected ImageButton setaDireita;
    ViewFlipper viewFlipper;
    private float lastX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);

        Context contexto = getApplicationContext(); // Necessario para funcionamento do toast

        String texto_toast = "Esta é a tela de informações";              //Toast caso o mInfoButton seja clicado
        int duracao = Toast.LENGTH_LONG;
        final Toast toast = Toast.makeText(contexto, texto_toast, duracao);

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
        mFavButton.setOnClickListener(listenerFav);
        mInfoButton.setOnClickListener(listenerInfo);

        /** Texto da TextView no codigo ao inves de no xml
         TextView fornecedores_text = (TextView) findViewById(R.id.fornecedores_text);
         fornecedores_text.setText("A produção e distribuição de refeições do RU é de competência da empresa terceirizada " +
         "especializada. Atualmente, a empresa prestadora desse serviço é a Sanoli, que atua no mercado há 36 anos." +
         " Tem sede em Brasília, onde funciona sua cozinha central.");
         */
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

    public void startActivityCredit(View view) {

        //Intent creditActivity = new Intent(this, HomeActivity.class);
        //startActivity(creditActivity);
    }

    public void startActivityCard(View view) {

        Intent homeActivity = new Intent(this, HomeActivity.class);
        startActivity(homeActivity);
    }

    public void startActivityFav(View view) {

        Intent favActivity = new Intent(this, FavActivity.class);
        startActivity(favActivity);
    }


}
