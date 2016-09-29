package andreluis.ru;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends FragmentActivity {

    protected Button mDesjejumButton, mAlmocoButton, mJantarButton;

    Fragment df = new DesjejumFragment();         //Criação de objetos para troca de fragments
    Fragment af = new AlmocoFragment();
    Fragment jf = new JantarFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mDesjejumButton = (Button) findViewById(R.id.desjejumButton);
        mAlmocoButton = (Button) findViewById(R.id.almocoButton);
        mJantarButton = (Button) findViewById(R.id.jantarButton);


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

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.fragments, fragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }

}