package info.androidhive.firebase;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Sales extends AppCompatActivity {

    Button buttonSales;
    Button buttonUpdate;
    Intent i;
    EditText editTextValor;
    EditText editTextArticulo;
    Button contacts_button;
    Button store_button;
    ArrayList<TextView> textViewsVal;
    ArrayList<TextView> textViewsName;
    ArrayList<String> categorias;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference;
    TextView textViewLacteos1;
    TextView textViewLacteosLecheValor;
    TextView textViewLacteos2;
    TextView textViewLacteosLecheValor2;
    TextView textViewLacteos3;
    TextView textViewLacteosLecheValor3;
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales2);
        categorias = new ArrayList<String>();
        i = getIntent();
        buttonSales = (Button) findViewById(R.id.sales);
        editTextValor = (EditText) findViewById(R.id.quantity);
        editTextArticulo = (EditText) findViewById(R.id.article);
        textViewLacteos1 = (TextView)findViewById(R.id.textViewLacteos1);
        textViewLacteosLecheValor = (TextView)findViewById(R.id.textViewLecheValor);
        textViewLacteos2 = (TextView)findViewById(R.id.textViewLacteos2);
        textViewLacteosLecheValor2 = (TextView)findViewById(R.id.textViewLecheValor2);
        textViewLacteos3 = (TextView)findViewById(R.id.textView10);
        textViewLacteosLecheValor3 = (TextView)findViewById(R.id.textView11);
        textViewsName = new ArrayList<TextView>();
        textViewsName.add(textViewLacteos1);
        textViewsName.add(textViewLacteos2);
        textViewsName.add(textViewLacteos3);

        textViewsVal = new ArrayList<TextView>();
        textViewsVal.add(textViewLacteosLecheValor);
        textViewsVal.add(textViewLacteosLecheValor2);
        textViewsVal.add(textViewLacteosLecheValor3);
        Button btn_back=(Button)findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sales.this, LoginActivity.class);
                startActivity(intent);
            }
        });



    }


    protected void onStart() {
        super.onStart();
        //if (i.getStringExtra("Test").equals("Lacteos")) {
            reference = database.getReference("Lacteos");

            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot dataSnapshot) {
                    int i = 0;
                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                        if (i < 3) {
//                            textViewsName.get(i).setText(child.getKey());
  //                          textViewsVal.get(i).setText(child.getValue().toString());
                            Log.d("User key", child.getKey());
                            Log.d("User ref", child.getRef().toString());
                            Log.d("User val", child.getValue().toString());
                            i++;
                        }

                    }


                    buttonSales.setOnClickListener(new View.OnClickListener() {

                        //AQUI SE DEBE HACER EL CAMBIO EN EL SIGUIENTE COMENTARIO SE DEBE RECIBIR EL VALOR DE TIPO INT
                        //DEL KEY QUE ESTAMOS LLAMANDO, Y ESO RESTARLE "VALUE" PARA QUE SE ACTUALIE EL STORE
                        @Override
                        public void onClick(View v) {

                                String key = editTextArticulo.getText().toString().trim();
                                String value = editTextValor.getText().toString();
                                String cantidad_store="Ventas del dia:";

                                int our_value=Integer.parseInt(value);
                                DatabaseReference childRef = reference.child(key);

                                int auxBD = Integer.parseInt(dataSnapshot.child(key).getValue().toString());

                                if(auxBD>0){
                                    int auxOper = auxBD - our_value;
                                    childRef.setValue(auxOper);
                                    Toast.makeText(getApplicationContext(),"VENDIDO",Toast.LENGTH_SHORT).show();


                                    //DatabaseReference newRef = rootRef.child(cantidad_store).push();
                                    DatabaseReference newRef = rootRef.child(key).child(key).push();
                                    newRef.setValue(our_value);
                                       // categorias.add(cantidad_store);


                                }
                                else{
                                    Toast.makeText(getApplicationContext(),"No hay suficientes productos",Toast.LENGTH_SHORT).show();
                                }


                        }

                        });


                }
                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }



    }

