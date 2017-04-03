package info.androidhive.firebase;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ja-he on 02/04/2017.
 */

public class CategoriaAdapter extends BaseAdapter {

    private ArrayList<String> datos;
    private Activity activity;

    public  CategoriaAdapter(ArrayList<String> datos, Activity activity){
        this.datos = datos;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int position) {

        return datos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null){
            view = activity.getLayoutInflater().inflate(R.layout.row_categorias,null);
        }

        TextView textViewCategorias = (TextView)view.findViewById(R.id.textViewCategoria);


        Log.d("EN ADAPTER: ", datos.get(i).toString() );

        textViewCategorias.setText(datos.get(i).toString());

        return view;
    }
}
