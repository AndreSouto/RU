package andreluis.ru;


import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


public class JantarFragment extends ListFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_jantar, container,
                false);

        String[] values = new String[]{"Caçarola marinada(paleta)", "Cuzcuz vegetariano","Feijoada", "Acelga e nabo com tomate", "Laranja"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_expandable_list_item_1, values);

        setListAdapter(adapter);
        return rootView;
    }
}