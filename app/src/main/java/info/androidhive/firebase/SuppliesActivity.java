package info.androidhive.firebase;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SuppliesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    Button buttonAgregarC;
    Button buttonEliminarC;
    Button buttonActualizarC;
    EditText editTextCategoria;
    ArrayList<String> categorias;
    CategoriaAdapter categoriasAdapter;
    ListView listCatgorias;

    Activity activity;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplies);

        buttonAgregarC = (Button)findViewById(R.id.buttonAgregarC);
        buttonActualizarC = (Button)findViewById(R.id.buttonActualizar);
        buttonEliminarC = (Button)findViewById(R.id.buttonEliminar);
        editTextCategoria = (EditText)findViewById(R.id.editTextCategoria);
        listCatgorias = (ListView)findViewById(R.id.listCategorias);

        categorias = new ArrayList<String>();

        //listCatgorias.setAdapter(null);

        categoriasAdapter = new CategoriaAdapter(categorias,this);
        listCatgorias.setAdapter(categoriasAdapter);
        listCatgorias.setOnItemClickListener(this);

        categoriasAdapter.notifyDataSetChanged();

        activity = this;
    }

    @Override
    protected void onStart() {
        super.onStart();

        rootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot dataSnapshot) {

                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    categorias.add(child.getKey());
                }

               // categoriasAdapter = new CategoriaAdapter(categorias,activity);
               // listCatgorias.setAdapter(categoriasAdapter);

                buttonAgregarC.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        String key = editTextCategoria.getText().toString();
                        DatabaseReference newRef = rootRef.child(key).push();
                        newRef.setValue("");

                        categorias.add(key);
                        activity.finish();
                        startActivity(activity.getIntent());
                        // categoriasAdapter.notifyDataSetChanged();

                         // categoriasAdapter = new CategoriaAdapter(categorias,activity);
                         // listCatgorias.setAdapter(categoriasAdapter);
                    }
                });

                buttonEliminarC.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String key = editTextCategoria.getText().toString();
                        DatabaseReference childRef = rootRef.child(key);
                        childRef.removeValue();

                        for(int i = 0; i < categorias.size(); i++) {
                            if(categorias.get(i).toString().equals(key)) {
                                categorias.remove(i);
                                break;
                            }
                        }
                        activity.finish();
                        startActivity(activity.getIntent());
                        //categoriasAdapter.notifyDataSetChanged();

                        // categoriasAdapter = new CategoriaAdapter(categorias,activity);
                        //listCatgorias.setAdapter(categoriasAdapter);

                    }
                });

                buttonActualizarC.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String key = editTextCategoria.getText().toString();
                        DatabaseReference childRef = rootRef.child(key);
                        childRef.removeValue();

                        for(int i = 0; i < categorias.size(); i++) {
                            if(categorias.get(i).toString().equals(key)) {
                                categorias.set(i,key);
                                break;
                            }
                        }
                        activity.finish();
                        startActivity(activity.getIntent());
                        //categoriasAdapter.notifyDataSetChanged();

                        // categoriasAdapter = new CategoriaAdapter(categorias,activity);
                        //listCatgorias.setAdapter(categoriasAdapter);

                    }
                });
               // listCatgorias.setAdapter(null);
                 //categoriasAdapter = new CategoriaAdapter(categorias,activity);
                 //listCatgorias.setAdapter(categoriasAdapter);
                //categoriasAdapter.notifyDataSetChanged();

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }


        });
        //categoriasAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        Toast.makeText(this, "dato enviado: "+categorias.get(i), Toast.LENGTH_LONG).show();
        Intent intent = new Intent(SuppliesActivity.this,StoreActivity.class);
        intent.putExtra("Test", categorias.get(i).toString());
        startActivity(intent);

    }
}
